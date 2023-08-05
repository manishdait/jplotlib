/*
 * MIT License
 * 
 * Copyright (c) 2023 Manish Dait
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.manishdait.jplotlib.chart;

import java.awt.Color;
import java.util.List;

import io.github.manishdait.jplotlib.data.StyleData;
import io.github.manishdait.jplotlib.internal.util.ChartType;
import io.github.manishdait.jplotlib.style.line.BaseStroke;
import io.github.manishdait.jplotlib.style.marker.BaseMarker;


public class LineGraph {
    
  private LineSeries lineSeries;
  private List<StyleData> styleDatas;

  public LineGraph(List<StyleData> styleDatas) {
    this.lineSeries = new LineSeries();
    this.styleDatas = styleDatas;
  }
  
  public LineGraph marker(BaseMarker marker) {
    marker = marker == null ? BaseMarker.NONE : marker;
    lineSeries.setMarker(marker);
    return this;
  }

  public LineGraph color(Color color) {
    this.lineSeries.setColor(color);
    return this;
  }

  public LineGraph markerColor(Color color) {
    this.lineSeries.setMarkerColor(color);
    return this;
  }

  public LineGraph lineStyle(BaseStroke style) {
    style = style == null ? BaseStroke.NONE : style;
    this.lineSeries.setLineStyle(style);
    return this;
  }

  public LineGraph lineWidth(float width) {
    width = width < 1 ? 1 : width;
    width = width > 15 ? 15 : width;
    this.lineSeries.setLineWidth(width);
    return this;
  }

  public LineGraph markerSize(int size) {
    lineSeries.setMarkerSize(size);
    return this;
  }

  private LineSeries getMeta() {
    return this.lineSeries;
  }

  public void build() {
    StyleData styleData = new StyleData();
    styleData.setChartType(ChartType.LINE);
    styleData.setLineSeries(this.getMeta());
    this.styleDatas.add(styleData);
  }

}

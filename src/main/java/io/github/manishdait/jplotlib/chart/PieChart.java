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


public class PieChart {

  private List<StyleData> styleDatas;
  private PieSeries pieSeries;

  public PieChart(List<StyleData> styleDatas) {
    this.styleDatas = styleDatas;
    this.pieSeries = new PieSeries();
  }

  public PieChart color(Color[] color) {
    this.pieSeries.setColor(color);
    return this;
  }

  public void build() {
    StyleData styleData = new StyleData();
    styleData.setChartType(ChartType.PIE);
    styleData.setPieSeries(this.pieSeries);
    styleDatas.clear();
    styleDatas.add(styleData);
  }
    
}

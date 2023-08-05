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

import io.github.manishdait.jplotlib.style.line.BaseStroke;
import io.github.manishdait.jplotlib.style.marker.BaseMarker;


public class LineSeries {

    private BaseMarker marker = BaseMarker.NONE;
    private Color color;
    private Color markerColor;
    private int markerSize;
    private BaseStroke lineStyle = BaseStroke.NONE;
    private float lineWidth = 2F;
  
    public LineSeries() {}
  
    public BaseMarker getMarker() {
      return marker;
    }
    public void setMarker(BaseMarker marker) {
      this.marker = marker;
    }
  
    public Color getColor() {
      return color;
    }
    public void setColor(Color color) {
      this.color = color;
    }
  
    public BaseStroke getLineStyle() {
      return lineStyle;
    }
    public void setLineStyle(BaseStroke lineStyle) {
      this.lineStyle = lineStyle;
    }
  
    public Color getMarkerColor() {
      return markerColor;
    }
    public void setMarkerColor(Color markerColor) {
      this.markerColor = markerColor;
    }

    public float getLineWidth() {
      return lineWidth;
    }
    public void setLineWidth(float lineWidth) {
      this.lineWidth = lineWidth;
    }

    public int getMarkerSize() {
      return markerSize;
    }
    public void setMarkerSize(int markerSize) {
      this.markerSize = markerSize;
    }

}

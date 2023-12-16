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

package io.github.manishdait.jplotlib.charts.line;

import java.awt.Color;

import io.github.manishdait.jplotlib.defaults.line.Stroke;
import io.github.manishdait.jplotlib.defaults.marker.Marker;

/**
 * The LineChartStyle class holds style properties for configuring the
 * appearance of a line chart.
 * It includes settings for markers, colors, line styles, and widths.
 * 
 */
public class LineChartStyle {

    private Marker marker;
    private Color color;
    private Color markerColor;
    private int markerSize;
    private Stroke lineStyle;
    private float lineWidth;

    /**
     * Constructs a LineChartStyle with default style settings.
     */
    public LineChartStyle() {
        this.marker = Marker.NONE;
        color = null;
        markerColor = null;
        lineStyle = Stroke.NONE;
        lineWidth = 2F;
        this.markerSize = 0;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getMarkerColor() {
        return markerColor;
    }

    public void setMarkerColor(Color markerColor) {
        this.markerColor = markerColor;
    }

    public int getMarkerSize() {
        return markerSize;
    }

    public void setMarkerSize(int markerSize) {
        this.markerSize = markerSize;
    }

    public Stroke getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(Stroke lineStyle) {
        this.lineStyle = lineStyle;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }
    
}

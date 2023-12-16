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

import io.github.manishdait.jplotlib.charts.helper.Graph;
import io.github.manishdait.jplotlib.data.util.Data;
import io.github.manishdait.jplotlib.defaults.line.Stroke;
import io.github.manishdait.jplotlib.defaults.marker.Marker;
import io.github.manishdait.jplotlib.internals.util.ChartType;

/**
 * The LineChart class implements the Graph interface and represents a line
 * chart.
 * It allows plotting data using lines with customizable styles such as markers,
 * colors, line styles, etc.
 * 
 */
public class LineChart implements Graph {

    private Data coordinates;
    private LineChartStyle style;
    private static final ChartType CHART_TYPE = ChartType.LINE;

    protected LineChart() {
    }

    /**
     * Constructs a LineChart with the provided data coordinates and initializes
     * default style settings.
     *
     * @param coordinates
     *            The data coordinates to be plotted on the line chart.
     */
    public LineChart(Data coordinates) {
        this.coordinates = coordinates;
        style = new LineChartStyle();
    }

    public Data getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Data coordinates) {
        this.coordinates = coordinates;
    }

    public LineChartStyle getStyle() {
        return style;
    }

    public void setStyle(LineChartStyle style) {
        this.style = style;
    }

    public ChartType getChartType() {
        return CHART_TYPE;
    }

    public LineChart marker(Marker marker) {
        style.setMarker(marker);
        return this;
    }

    public LineChart color(Color color) {
        style.setColor(color);
        return this;
    }

    public LineChart markerColor(Color color) {
        style.setMarkerColor(color);
        return this;
    }

    public LineChart lineStyle(Stroke stroke) {
        style.setLineStyle(stroke == null ? Stroke.NONE : stroke);
        return this;
    }

    public LineChart lineWidth(float width) {
        width = width < 1 ? 1 : width;
        width = width > 15 ? 15 : width;
        style.setLineWidth(width);
        return this;
    }

    public LineChart markerSize(int size) {
        style.setMarkerSize(size);
        return this;
    }

}

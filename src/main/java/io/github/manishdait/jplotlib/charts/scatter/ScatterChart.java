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
package io.github.manishdait.jplotlib.charts.scatter;

import java.awt.Color;

import io.github.manishdait.jplotlib.charts.helper.Graph;
import io.github.manishdait.jplotlib.data.util.Data;
import io.github.manishdait.jplotlib.defaults.marker.Marker;
import io.github.manishdait.jplotlib.internals.util.ChartType;

/**
 * The ScatterChart class implements the Graph interface and represents a
 * scatter chart.
 * It enables plotting data points using markers with customizable styles such
 * as markers, sizes, colors, etc.
 * 
 */
public class ScatterChart implements Graph {

    private Data coordinates;
    private ScatterChartStyle style;
    private static final ChartType CHART_TYPE = ChartType.SCATTER;

    public ScatterChart() {
    }

    /**
     * Constructs a ScatterChart with the provided data coordinates and initializes
     * default style settings.
     *
     * @param coordinates
     *            The data coordinates to be plotted on the scatter chart.
     */
    public ScatterChart(Data coordinates) {
        this.coordinates = coordinates;
        style = new ScatterChartStyle();
    }

    public Data getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Data coordinates) {
        this.coordinates = coordinates;
    }

    public ScatterChartStyle getStyle() {
        return style;
    }

    public void setStyle(ScatterChartStyle style) {
        this.style = style;
    }

    public ChartType getChartType() {
        return CHART_TYPE;
    }

    public ScatterChart marker(Marker marker) {
        marker = marker == null ? Marker.NONE : marker;
        style.setMarker(marker);
        return this;
    }

    public ScatterChart size(int[] size) {
        style.setScale(size);
        return this;
    }

    public ScatterChart color(Color color) {
        style.setColor(color);
        return this;
    }

    public ScatterChart alpha(float alpha) {
        style.setAlpha(alpha);
        return this;
    }

}

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

package io.github.manishdait.jplotlib.charts.area;

import java.awt.Color;

import io.github.manishdait.jplotlib.charts.helper.Graph;
import io.github.manishdait.jplotlib.data.util.Data;
import io.github.manishdait.jplotlib.internals.util.ChartType;

/**
 * The AreaChart class implements the Graph interface and represents a area
 * chart.
 * It allows plotting area chart using polygon with customizable styles.
 * 
 */
public class AreaChart implements Graph {

    private Data data;
    private AreaChartStyle style;
    private static final ChartType CHART_TYPE = ChartType.AREA;

    /**
     * Constructs a AreaChart with the provided data coordinates and initializes
     * default style settings.
     *
     * @param data
     *            The data coordinates to be plotted on the area chart.
     */
    public AreaChart(Data data) {
        this.data = data;
        this.style = new AreaChartStyle();
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public AreaChartStyle getStyle() {
        return style;
    }

    public void setStyle(AreaChartStyle style) {
        this.style = style;
    }

    public static ChartType getChartType() {
        return CHART_TYPE;
    }

    public AreaChart color(Color color) {
        style.setColor(color);
        return this;
    }

    public AreaChart alpha(float alpha) {
        if (alpha > 1 || alpha < 0) {
            alpha = 1;
        }
        style.setAlpha(alpha);
        return this;
    }

}

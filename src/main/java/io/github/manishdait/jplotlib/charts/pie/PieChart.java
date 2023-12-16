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

package io.github.manishdait.jplotlib.charts.pie;

import io.github.manishdait.jplotlib.charts.helper.Graph;
import io.github.manishdait.jplotlib.data.util.Data;
import io.github.manishdait.jplotlib.internals.util.ChartType;

/**
 * The PieChart class represents a pie chart configuration containing data
 * values and style settings
 * for rendering a pie chart within the JPlotLib library.
 * It implements the Graph interface and provides methods to access and modify
 * pie chart properties.
 * 
 */
public class PieChart implements Graph {

    private Data values;
    private PieChartStyle style;
    private static final ChartType CHART_TYPE = ChartType.PIE;

    /**
     * Constructs a PieChart object with the provided data values and default style
     * settings.
     *
     * @param values
     *            The Data object containing values for the pie chart.
     */
    public PieChart(Data values) {
        this.values = values;
        this.style = new PieChartStyle();
    }

    public Data getValues() {
        return values;
    }

    public void setValues(Data values) {
        this.values = values;
    }

    public ChartType getChartType() {
        return CHART_TYPE;
    }

    public PieChartStyle getStyle() {
        return style;
    }

    public void setStyle(PieChartStyle style) {
        this.style = style;
    }

}

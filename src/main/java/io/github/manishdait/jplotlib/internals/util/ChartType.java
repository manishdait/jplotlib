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

package io.github.manishdait.jplotlib.internals.util;

/**
 * The ChartType enum represents the types of charts that can be created using
 * Jplotlib.
 * 
 * This enum provides four values for different chart types: LINE, SCATTER, BAR,
 * and PIE. Each value corresponds to a specific type of chart that can be
 * generated using Jplotlib.
 * 
 * The ChartType enum is used to specify the type of chart to be created in
 * Jplotlib.
 * 
 */
public enum ChartType {

    /**
     * The LINE chart type represents a line plot.
     */
    LINE,

    /**
     * The SCATTER chart type represents a scatter plot.
     */
    SCATTER,

    /**
     * The BAR chart type represents a bar chart.
     */
    BAR,

    /**
     * The PIE chart type represents a pie chart.
     */
    PIE,

    /**
     * The AREA chart type represents a area chart.
     */
    AREA;

}

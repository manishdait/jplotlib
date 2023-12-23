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

/**
 * The LineChartOptions interface defines methods for configuring and plotting
 * line charts.
 * Implementing classes can provide various options for plotting line charts
 * based on data points.
 * 
 */
public interface LineChartOptions {
    /**
     * Plots a line chart using provided x and y data points.
     *
     * @param xPoints
     *            The array of x-axis data points.
     * @param yPoints
     *            The array of y-axis data points.
     * @return The LineChart object representing the plotted line chart.
     */
    LineChart plot(double[] xPoints, double[] yPoints);

    /**
     * Plots a line chart using only y-axis data points.
     *
     * @param yPoints
     *            The array of y-axis data points.
     * @return The LineChart object representing the plotted line chart.
     */
    LineChart plot(double[] yPoints);

}

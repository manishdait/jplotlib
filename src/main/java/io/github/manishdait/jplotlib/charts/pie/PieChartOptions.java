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

/**
 * The PieChartOptions interface provides a method to create a pie chart with
 * data points.
 * Implementations of this interface are expected to generate a PieChart object
 * based on the provided data points.
 * 
 */
public interface PieChartOptions {
    /**
     * Creates a pie chart with the given data points.
     *
     * @param dataPoints
     *                   An array of doubles representing the data points for the
     *                   pie chart
     *                   slices.
     * @return PieChart A PieChart object representing a pie chart with the provided
     *         data points.
     */
    PieChart pie(double[] dataPoints);

    /**
     * Creates a pie chart with labeled segments using the given data points and
     * labels.
     * 
     * @param dataPoints
     *                   An array of doubles representing the data points for the
     *                   pie chart slices.
     * @param labels
     *                   An array of Strings providing labels for the corresponding
     *                   data points.
     *                   Each data point in the chart will be labeled accordingly.
     * @return PieChart
     *         A PieChart object representing a labeled pie chart with the provided
     *         data points and labels.
     */
    PieChart pie(double[] dataPoints, String[] labels);

}

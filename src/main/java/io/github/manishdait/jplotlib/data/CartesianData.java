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

package io.github.manishdait.jplotlib.data;

import io.github.manishdait.jplotlib.data.util.Data;

/**
 * The CartesianData class implements the Data interface and represents a set of
 * Cartesian data points. It contains x and y coordinate arrays for plotting
 * Cartesian coordinates.
 * 
 */
public class CartesianData implements Data {
    private double[] xPoints;
    private double[] yPoints;

    /**
     * Constructs a CartesianData object with the given x and y coordinate arrays.
     *
     * @param xPoints
     *            The array containing the x-coordinates.
     * @param yPoints
     *            The array containing the y-coordinates.
     */
    public CartesianData(double[] xPoints, double[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public double[] getxPoints() {
        return xPoints;
    }

    public void setxPoints(double[] xPoints) {
        this.xPoints = xPoints;
    }

    public double[] getyPoints() {
        return yPoints;
    }

    public void setyPoints(double[] yPoints) {
        this.yPoints = yPoints;
    }
}

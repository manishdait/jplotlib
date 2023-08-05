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

/**
 * The Coordinates class represents a set of x and y points for a series plot.
 *
 */

public class Coordinates {
    
  private double[] xPoints;
  private double[] yPoints;

  /**
   * Default constructor for Coordinates.
   */
  public Coordinates() {}

  /**
   * Get the x points array.
   *
   * @return The x points array.
   */
  public double[] getxPoints() {
    return this.xPoints;
  }

  /**
   * Set the x points array.
   * 
   * @param xPoints The x points array.
   */
  public void setxPoints(double[] xPoints) {
    this.xPoints = xPoints;
  }

  /**
   * Get the y points array.
   * 
   * @return The y points array.
   */
  public double[] getyPoints() {
    return this.yPoints;
  }

  /**
   * Set the y points array.
   *
   * @param yPoints The y points array.
   */
  public void setyPoints(double[] yPoints) {
    this.yPoints = yPoints;
  }

}

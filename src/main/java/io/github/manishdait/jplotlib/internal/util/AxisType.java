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

package io.github.manishdait.jplotlib.internal.util;

/**
 * The AxisType enum represents the types of axes used in Jplotlib charts.
 * 
 * This enum provides three values for different chart types: PLOT, BAR, and 
 * PIE. Each value has a corresponding priority, which determines the order in
 * which the axes are rendered.
 * 
 * The AxisType enum is used to indicate the type of axis to be used in a
 * particular chart.
 * 
 * 
 */

public enum AxisType {
  
  /**
   * The PLOT axis type represents a regular plot chart with X and Y axes.
   */
  PLOT(1),

  /**
   * The BAR axis type represents a bar chart with X and Y axes.
   */
  BAR(2),

  /**
   * The PIE axis type represents a pie chart with no traditional X and Y axes.
   */
  PIE(3);
  
  private int priority;



  /**
   * Constructs an AxisType enum with the specified priority.
   * 
   * @param priority the priority of the axis type, used for rendering order.
   */
  AxisType(int priority) {
    this.priority = priority;
  }

  /**
   * Gets the priority value of the axis type.
   * 
   * @return the priority value.
   */
  public int getPriority() {
    return this.priority;
  }

}

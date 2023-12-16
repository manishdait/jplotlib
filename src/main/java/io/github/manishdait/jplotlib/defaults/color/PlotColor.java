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

package io.github.manishdait.jplotlib.defaults.color;

import java.awt.Color;

/**
 * The PLotColor class provides a set of predefined colors for series in a
 * chart.
 * 
 */
public class PlotColor {

  private static final Color[] colors = {
    new Color(31, 119, 181),
    new Color(251, 127, 15),
    new Color(46, 161, 47),
    new Color(215, 42, 44),
    new Color(148, 104, 189),
    new Color(141, 86, 75),
    new Color(227, 119, 194),
    new Color(127, 127, 127),
    new Color(188, 189, 35),
    new Color(44, 193, 209)
  };

  /**
   * Get the color associated with the given index.
   *
   * @param index The index of the color to retrieve.
   * @return The color associated with the index.
   */
  public static Color getColor(int indx) {
    return colors[indx];
  }

}

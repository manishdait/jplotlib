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
 * The Constants class contains various constant values used in the Jplotlib
 * library.
 * 
 * This class provides constant values for the chart provider, chart dimensions,
 * margins, and marker scales.
 * 
 * The Constants class is used internally by the Jplotlib library and is not
 * intended to be used directly by users.
 * 
 * 
 */

public class Constants {
    
  /**
   * The name of the chart provider (Jplotlib).
   */
  public static final String PROVIDER = "io.github.manishdait.jplotlib.Jplotlib";

  /**
   * The default width of the chart.
   */
  public static final int WIDTH = 750;

  /**
   * The default height of the chart.
   */
  public static final int HEIGTH = 600;

  /**
   * The margin size for the chart.
   */
  public static final int MARGIN = 90;

  /**
   * The minimum scale value for markers.
   */
  public static final int MIN_MARKER_SCALE = 5;

  /**
   * The maximum scale value for markers.
   */
  public static final int MAX_MARKER_SCALE = 50;

  /**
   * The default scale value for markers.
   */
  public static final int DEFAULT_MARKER_SCALE = 10;

}

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

package io.github.manishdait.jplotlib.style.color;

import java.awt.Color;

/**
 * The BaseColor enum represents a set of predefined colors.
 * 
 */
public enum BaseColor {
  
  BLUE(new Color(31, 119, 181)),
  ORANGE(new Color(251, 127, 15)),
  GREEN(new Color(46, 161, 47)),
  RED(new Color(215, 42, 44)),
  PURPLE(new Color(148, 104, 189)),
  BROWN(new Color(141, 86, 75)),
  PINK(new Color(227, 119, 194)),
  GREY(new Color(127, 127, 127)),
  LIME(new Color(188, 189, 35)),
  SKY(new Color(44, 193, 209));

  private Color color;

  BaseColor(Color color) {
    this.color = color;
  }

  /**
   * Get the color associated with the BaseColor.
   *
   * @return The color.
   */
  public Color getColor() {
    return this.color;
  }

}

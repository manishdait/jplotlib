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

package io.github.manishdait.jplotlib.internal.component.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.internal.util.Constants;


/**
 * The Axis class represents a base class for building and drawing axes in
 * Jplotlib charts.
 * 
 * This class is used to create and draw the axes (X-axis and Y-axis) for
 * Jplotlib charts. It provides
 * functionality to build and render the axes with borders, ticks, and labels,
 * based on the provided Graphics object, SeriesData, and JPanel context.
 * 
 * The Axis class is not intended for direct instantiation, as it serves as a
 * base class for specific axis implementations. Instead, specific axis classes
 * such as HorizontalAxis and VerticalAxis extend this class to create and draw
 * the respective axes.
 * 
 * 
 */


class Axis {

  protected Graphics2D g;
  protected SeriesData seriesData;
  protected JPanel context;

  /**
   * Constructs a new Axis object with the specified Graphics, JPanel context,
   * and SeriesData.
   *
   * @param g the Graphics object used for drawing the axis.
   * @param context the JPanel context within which the axis will be drawn.
   * @param seriesData the SeriesData containing data points for the chart.
   */

  public Axis(Graphics g, JPanel context, SeriesData seriesData) {
    this.g = (Graphics2D) g;
    this.seriesData = seriesData;
    this.context = context;
  }

  /**
   * Builds and draws the borders for the X-axis and Y-axis of the chart.
   */
  public void buildBorder() {
    this.g.setStroke(new BasicStroke(1.2F));
    this.g.setColor(Color.BLACK);

    int height = this.context.getHeight();
    int width = this.context.getWidth();

    this.g.drawLine(
      Constants.MARGIN, 
      height - Constants.MARGIN, 
      width - Constants.MARGIN, 
      height - Constants.MARGIN
    );
    this.g.drawLine(
      Constants.MARGIN, 
      Constants.MARGIN, 
      width - Constants.MARGIN, 
      Constants.MARGIN
    );

    this.g.drawLine(
      Constants.MARGIN, 
      Constants.MARGIN, 
      Constants.MARGIN, 
      height - Constants.MARGIN
    );
    this.g.drawLine(
      width - Constants.MARGIN, 
      Constants.MARGIN, 
      width - Constants.MARGIN, 
      height - Constants.MARGIN
    );
  }

}

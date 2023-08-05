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

import java.awt.Graphics;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.internal.util.AxisType;

/**
 * The AxisBuilder class is responsible for building and rendering the axis 
 * components for Jplotlib charts.
 * 
 * This class extends the Coordinate class, which provides the functionality for
 * drawing and labeling the X-axis and Y-axis. The AxisBuilder further enhances
 * this functionality by adding a border and grid for non-pie charts.
 * 
 * The AxisBuilder is not intended for direct instantiation, as it is used 
 * internally by Jplotlib to render the axis components.
 * 
 *
 */

public class AxisBuilder extends Coordinate {

  /**
   * Constructs a new AxisBuilder object with the specified Graphics, JPanel
   * context, and SeriesData.
   *
   * @param g the Graphics object used for drawing the axis components.
   * @param context the JPanel context within which the axis components will be
   * drawn.
   * @param seriesData the SeriesData containing data points for the chart.
   */
  public AxisBuilder(Graphics g, JPanel context, SeriesData seriesData) {
    super(g, context, seriesData);
  }

  /**
   * Builds and renders the axis components, including the border and grid
   * (if applicable) for non-pie charts.
   */
  public void buildAxis() {
    if(seriesData.getAxisType() !=  AxisType.PIE) {
    buildBorder();
    drawCoordinates();
    
    new Grid(g, context, seriesData).buildGrid();
    }
  }

}

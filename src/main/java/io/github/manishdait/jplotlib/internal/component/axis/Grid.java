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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.internal.util.AxisType;
import io.github.manishdait.jplotlib.internal.util.Constants;


/**
 * The Grid class is responsible for drawing the grid lines on the chart.
 * 
 * This class provides methods to build the grid lines for different chart types,
 * including regular plot charts and bar charts. The grid lines are drawn based
 * on the data points and axis bounds provided in the SeriesData object.
 * 
 * The Grid class is used internally by the Jplotlib library and is not intended
 * to be used directly by users
 *
 *  
 */

class Grid {

  private Graphics2D g;
  private SeriesData seriesData;
  private JPanel context;

  int xTotalPoints;
  int yTotalPoints;

  int xBounds;
  int yBounds;

  int xValDiff;
  int yValDiff;

  /**
   * Constructs a Grid object with the specified graphics context, chart context,
   * and series data.
   * 
   * @param g           the graphics context for drawing the grid lines.
   * @param context     the chart context (JPanel) where the grid lines will be
   * drawn.
   * @param seriesData  the series data containing the data points and axis
   * bounds.
   */
  public Grid(Graphics g, JPanel context, SeriesData seriesData) {
    this.g = (Graphics2D) g;
    this.seriesData = seriesData;
    this.context = context;  
  }

  /**
   * Builds the grid lines for the chart based on the chart type (plot or bar).
   */
  public void buildGrid() {

    this.g.setColor(new Color(176, 176, 176, 255));

    xBounds = seriesData.getxUpperBound() - seriesData.getxLowerBound();
    yBounds = seriesData.getyUpperBound() - seriesData.getyLowerBound();

    xValDiff = seriesData.getxValDiff();
    yValDiff = seriesData.getyValDiff();

    xTotalPoints = xBounds / xValDiff;
    yTotalPoints = yBounds / yValDiff;

    xTotalPoints = (xBounds % xValDiff) == 0 ? xTotalPoints : xTotalPoints + 1;
    yTotalPoints = (yBounds % yValDiff) == 0 ? yTotalPoints : yTotalPoints + 1;

    if(seriesData.getAxisType() != AxisType.BAR) {
      baseGrid();
    } else {
      barGrid();
    }

  }

  /**
   * Draws the grid lines for regular plot charts.
   */
  private void baseGrid() {
    int xIncrement = this.seriesData.getxIncrement();
    int yIncrement = this.seriesData.getyIncrement();

    int extraSpace = (int) (Math.max(xIncrement, yIncrement) * 0.25);

    if (this.seriesData.isxGrid()) {
      for(int i = 0; i <= xTotalPoints; i ++) {
        int x = Constants.MARGIN + (xIncrement * i) + extraSpace;
        this.g.drawLine(
          x, 
          Constants.MARGIN, 
          x, 
          this.context.getHeight() - Constants.MARGIN
        );
      }
    }

    if (this.seriesData.isyGrid()) {
      for(int  i = 0; i <= yTotalPoints; i ++) {
        int y = this.context.getHeight() - Constants.MARGIN - (yIncrement * i);
        this.g.drawLine(
          Constants.MARGIN, 
          y - extraSpace, 
          this.context.getWidth() - Constants.MARGIN, 
          y - extraSpace
        );
      }
    }
  }

  /**
   * Draws the grid lines for bar charts.
   */
  private void barGrid() {
    int xIncrement = this.seriesData.getxIncrement();
    int yIncrement = this.seriesData.getyIncrement();

    int extraSpace = (int) (Math.max(xIncrement, yIncrement) * 0.25);

    if (this.seriesData.isxGrid()) {
      for(int i = 0; i < seriesData.getLabel().length; i ++) {
        int x = Constants.MARGIN + (xIncrement * (i*2+1));
        this.g.drawLine(
          x, 
          Constants.MARGIN, 
          x, 
          this.context.getHeight() - Constants.MARGIN
        );
      }
    }

    if (this.seriesData.isyGrid()) {
      for(int  i = 0; i <= yTotalPoints; i ++) {
        int y = this.context.getHeight() - Constants.MARGIN - (yIncrement * i);
        this.g.drawLine(
          Constants.MARGIN, 
          y - extraSpace, 
          this.context.getWidth() - Constants.MARGIN, 
          y - extraSpace
        );
      }
    }
  }

}

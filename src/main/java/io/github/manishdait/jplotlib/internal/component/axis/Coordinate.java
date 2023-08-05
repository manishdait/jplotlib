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
import java.awt.RenderingHints;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.data.util.DataDiff;
import io.github.manishdait.jplotlib.data.util.PreProcessor;
import io.github.manishdait.jplotlib.internal.util.AxisType;
import io.github.manishdait.jplotlib.internal.util.Constants;



/**
 * The Coordinate class represents an axis layout and labeling component for
 * Jplotlib charts.
 * 
 * This class is responsible for drawing and labeling the X-axis and Y-axis of
 * Jplotlib charts. It calculates the axis bounds, increments, and labels based
 * on the provided Graphics, JPanel context, and SeriesData. The layout and
 * labels are rendered dynamically based on the data points and chart type.
 * 
 * The Coordinate class is not intended for direct instantiation, as it is used
 * internally by other Jplotlib components. It extends the Axis class, which is
 * a base class for building and drawing axes in Jplotlib charts.
 * 
 * 
 */

class Coordinate extends Axis {
  private int yUpperBound;
  private int xUpperBound;

  private int yLowerBound;
  private int xLowerBound;

  private double[] xPoints;
  private double[] yPoints; 

  private PreProcessor preProcessor;

  /**
   * Constructs a new Coordinate object with the specified Graphics, JPanel 
   * context, and SeriesData.
   *
   * @param g the Graphics object used for drawing the axes.
   * @param context the JPanel context within which the axes will be drawn.
   * @param seriesData the SeriesData containing data points for the chart.
   */
  public  Coordinate(Graphics g, JPanel context, SeriesData seriesData) {
    super(g, context, seriesData);
    this.preProcessor = new PreProcessor();
  }

  /**
   * Draws the X-axis and Y-axis coordinates, labels, and ticks based on the 
   * SeriesData.
   */
  public void drawCoordinates() {
    this.xPoints = preProcessor.processX(seriesData.getCoordinates());
    this.yPoints = preProcessor.processY(seriesData.getCoordinates());

    this.xUpperBound = preProcessor.getUpperBound(xPoints);
    this.yUpperBound = preProcessor.getUpperBound(yPoints);

    this.xLowerBound = preProcessor.getLowerBound(xPoints);
    this.yLowerBound = preProcessor.getLowerBound(yPoints);

    seriesData.setxUpperBound(this.xUpperBound);
    seriesData.setyUpperBound(this.yUpperBound);

    seriesData.setyLowerBound(this.yLowerBound);
    seriesData.setxLowerBound(this.xLowerBound);

    this.g.setRenderingHint(
      RenderingHints.KEY_TEXT_ANTIALIASING, 
      RenderingHints.VALUE_TEXT_ANTIALIAS_ON
    );
    this.g.setRenderingHint(
      RenderingHints.KEY_RENDERING, 
      RenderingHints.VALUE_RENDER_QUALITY
    );

    if(seriesData.getAxisType() != AxisType.BAR) {
      baseLayout();
    } else {
      barLayout();
    }
  }

  private void baseLayout() {
    int xBound = xUpperBound - xLowerBound;
    int xValDiff = DataDiff.getValDiff(
      xPoints,
      preProcessor.getMaxLengthX(seriesData.getCoordinates())
    );
    int totalX = xBound / xValDiff;
    totalX = (xBound % xValDiff) == 0 ? totalX : totalX + 1;
    int xIncrement = getIncrement(this.context.getWidth(), totalX); 
    
    seriesData.setxValDiff(xValDiff);
    seriesData.setxIncrement(xIncrement);

    int yBound = yUpperBound - yLowerBound;
    int yValDiff = DataDiff.getValDiff(
      yPoints,
      preProcessor.getMaxLengthY(seriesData.getCoordinates())
    );
    int totalY = yBound / yValDiff;
    totalY = (yBound % yValDiff) == 0 ? totalY : totalY + 1;
    int yIncrement = getIncrement(this.context.getHeight(), totalY);

    seriesData.setyValDiff(yValDiff);
    seriesData.setyIncrement(yIncrement);

    int extraSpace = (int) (Math.max(xIncrement, yIncrement) * 0.25);

    for(int i = 0; i <= totalX; i ++) {
      int x = Constants.MARGIN + xIncrement * i;
      int y = this.context.getHeight() - Constants.MARGIN + 20;
      int val = xValDiff * i + xLowerBound;
      this.g.drawString(Integer.toString(val), x + extraSpace, y);
    }

    for(int i = 0; i <= (totalY); i ++) {
      int x = Constants.MARGIN - 30;
      int y = this.context.getHeight() - Constants.MARGIN - yIncrement * i;
      int val = yValDiff * i + yLowerBound;
      this.g.drawString(Integer.toString(val), x, y - extraSpace );
    }
  }

  private void barLayout() {
    int totalX = seriesData.getLabel().length;
    int xIncrement = getIncrement(this.context.getWidth(), totalX * 2);

    for(int i = 0; i < totalX; i++) {
      int x = Constants.MARGIN + (xIncrement * (i * 2 + 1));
      int y = this.context.getHeight() - Constants.MARGIN + 20;
      this.g.drawString(seriesData.getLabel()[i], x, y);
    }

    seriesData.setxIncrement(xIncrement);

    int yBound = yUpperBound - yLowerBound;
    int yValDiff = DataDiff.getValDiff(
      yPoints,
      preProcessor.getMaxLengthY(seriesData.getCoordinates())
    );
    int totalY = yBound / yValDiff;
    totalY = (yBound % yValDiff) == 0 ? totalY : totalY + 1;
    int yIncrement = getIncrement(this.context.getHeight(), totalY);

    seriesData.setyValDiff(yValDiff);
    seriesData.setxValDiff(yValDiff);
    seriesData.setyIncrement(yIncrement);

    int extraSpace = (int) (Math.max(xIncrement, yIncrement) * 0.25);

    for(int i = 0; i <= totalY; i ++) {
      int x = Constants.MARGIN - 30;
      int y = this.context.getHeight() - Constants.MARGIN - yIncrement * i;
      int val = yValDiff * i + yLowerBound;
      this.g.drawString(Integer.toString(val), x, y - extraSpace );
    }
  }


  private int getIncrement(int width, int total) {
    return (width - Constants.MARGIN * 2) / (total + 1);
  }
  
}

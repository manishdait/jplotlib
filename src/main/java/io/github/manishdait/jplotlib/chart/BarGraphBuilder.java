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

package io.github.manishdait.jplotlib.chart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.plotter.Plotter;
import io.github.manishdait.jplotlib.style.color.BaseSeriesColor;


public class BarGraphBuilder implements Plotter {

  private Graphics2D g;
  private JPanel context;
  private SeriesData seriesData;
  private BarSeries barSeries;
  private int indx;

  public BarGraphBuilder(
    Graphics g, 
    JPanel context, 
    SeriesData seriesData,
    BarSeries barSeries,
    int indx
  ) {
    this.g = (Graphics2D) g;
    this.context = context;
    this.seriesData = seriesData;
    this.barSeries = barSeries;
    this.indx = indx;
  }

  @Override
  public void draw() {
    double[] yPoints = this.seriesData.getCoordinates().get(indx).getyPoints();

    this.g.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING, 
      RenderingHints.VALUE_ANTIALIAS_ON
    );

    Color color = barSeries.getColor();
    if(color == null) {
      color = BaseSeriesColor.getColor(indx);
    }
    
    this.g.setColor(color);

    int yLowerBound = seriesData.getyLowerBound();

    int xIncrement = seriesData.getxIncrement();
    int xValDiff = context.getWidth() / (yPoints.length * 2);

    int yIncrement = seriesData.getyIncrement();
    int yValDiff = seriesData.getyValDiff();

    int extraSpace = (int) (Math.max(xIncrement, yIncrement) * 0.25);

    for(int i = 0; i < yPoints.length; i++){
      int x = (xIncrement * (i * 2 + 1)) - xValDiff / 2;
      int y = context.getHeight() - ((int) (yIncrement * (yPoints[i] - yLowerBound)) / yValDiff);
      int h = (int) (yIncrement * (yPoints[i] - yLowerBound)) / yValDiff;

      this.g.fillRect(
        x , 
        y - extraSpace, 
        xValDiff, 
        h + extraSpace
      );
    }
  }
    
}

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


public class ScatterGraphBuilder implements Plotter {
    
  private Graphics2D g;
  private JPanel context;
  private SeriesData seriesData;
  private ScatterSeries scatterSeries;
  private int indx;

  public ScatterGraphBuilder(
    Graphics g, 
    JPanel context, 
    SeriesData seriesData, 
    ScatterSeries scatterSeries, 
    int indx
  ) {
    this.g = (Graphics2D) g;
    this.context = context;
    this.seriesData = seriesData;
    this.scatterSeries = scatterSeries;
    this.indx = indx;
  }

  @Override
  public void draw() {
    double[] xPoints = this.seriesData.getCoordinates().get(indx).getxPoints();
    double[] yPoints = this.seriesData.getCoordinates().get(indx).getyPoints();

    this.g.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING, 
      RenderingHints.VALUE_ANTIALIAS_ON
    );

    int yValDiff = seriesData.getyValDiff();
    int xValDiff = seriesData.getxValDiff();

    int xIncrement = seriesData.getxIncrement();
    int yIncrement = seriesData.getyIncrement();

    int xLowerBound = seriesData.getxLowerBound();
    int yLowerBound = seriesData.getyLowerBound();

    int extraSpace = (int) (Math.max(xIncrement, yIncrement) * 0.25);

    Color color = this.scatterSeries.getColor();

    if(color == null) {
        color = BaseSeriesColor.getColor(indx);
    }

    color = setAlpa(color);

    this.g.setColor(color);


    for(int i = 0; i < yPoints.length; i++) {
      int scale = scatterSeries.getScale() == null
        ? 10 : scatterSeries.getScale()[i] * 5;

      if(scale < 5 || scale > 50) {
        scale = 10;
      }
      
      int x = (int) (xIncrement * (xPoints[i] - xLowerBound)) / xValDiff - scale/2;
      int y = context.getHeight() - (int) (yIncrement * (yPoints[i] - yLowerBound)) / yValDiff - scale/2;
      switch (scatterSeries.getMarker()) {
        case NONE:
          case CIRCLE:
            this.g.fillOval(
              x + extraSpace, 
              y - extraSpace, 
              scale, 
              scale
            );
            break;
        
        case SQUARE:
          this.g.fillRect(
            x + extraSpace, 
            y - extraSpace, 
            scale, 
            scale
          );
          break;

        default:
          System.out.println("Error");
      }
      
    }
  }

  private Color setAlpa(Color color) {
    Color currColor = color;
    float alpha = scatterSeries.getAlpha();
    if(alpha < 0 || alpha > 1) {
      alpha = 1;
    }
    Color changeColor  = new Color(
      currColor.getRed(), 
      currColor.getGreen(), 
      currColor.getBlue(), 
      (int) (alpha * 255)
    );
    return changeColor;
  }

}

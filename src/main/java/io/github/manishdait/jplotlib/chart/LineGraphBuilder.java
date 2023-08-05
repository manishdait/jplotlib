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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.internal.util.Constants;
import io.github.manishdait.jplotlib.plotter.Plotter;
import io.github.manishdait.jplotlib.style.color.BaseSeriesColor;
import io.github.manishdait.jplotlib.style.marker.BaseMarker;


public class LineGraphBuilder implements Plotter {

  private Graphics2D g;
  private JPanel context;
  private SeriesData seriesData;
  private LineSeries lineSeries;
  private int indx;

  public LineGraphBuilder(
    Graphics g2, 
    JPanel context, 
    SeriesData seriesData, 
    LineSeries lineSeries, 
    int indx
  ) {
    this.g = (Graphics2D) g2;
    this.context = context;
    this.seriesData = seriesData;
    this.lineSeries = lineSeries;
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

    for(int i = 0 ; i < yPoints.length - 1; i++) {
      float lineWidth = this.lineSeries.getLineWidth();

      Color color = this.lineSeries.getColor();

      if(color == null) {
        color = BaseSeriesColor.getColor(indx);
      }

      if(lineSeries.getMarkerColor() == null) {
        lineSeries.setMarkerColor(color);
      }

      this.g.setColor(color);
      
      switch (this.lineSeries.getLineStyle()) {
        case NONE:
          this.g.setStroke(new BasicStroke(lineWidth));
          break;

        case DASHED:
          float[] dashPattern = {6F * (int) lineWidth, 6F * (int) lineWidth};
          BasicStroke dashedStroke = new BasicStroke(
            lineWidth, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_ROUND,
            0F,
            dashPattern,
            0F
          );
          g.setStroke(dashedStroke);
          break;

        default:
          this.g.setStroke(new BasicStroke(lineWidth));
      }


      double x1 = (xIncrement * (xPoints[i] - xLowerBound))  / xValDiff;
      double x2 = (xIncrement * (xPoints[i+1] - xLowerBound)) / xValDiff;

      double y1 = context.getHeight() - (yIncrement * (yPoints[i] - yLowerBound)) / yValDiff;
      double y2 = context.getHeight() - (yIncrement * (yPoints[i+1] - yLowerBound)) / yValDiff;

      Shape l = new Line2D.Double(
        x1 + extraSpace,
        y1 - extraSpace,
        x2 + extraSpace,
        y2 - extraSpace
      );

      g.draw(l);
    }

    if(this.lineSeries.getMarker() != BaseMarker.NONE){
      int scale = lineSeries.getMarkerSize() * Constants.MIN_MARKER_SCALE;

      if(scale < Constants.MIN_MARKER_SCALE || scale > Constants.MAX_MARKER_SCALE) {
        scale = Constants.DEFAULT_MARKER_SCALE;
      }

      for(int j = 0; j < yPoints.length; j++) {
        g.setColor(lineSeries.getMarkerColor());
        int x = (int) (xIncrement * (xPoints[j] - xLowerBound)) / xValDiff - (scale/2);
        int y = context.getHeight() - (int) (yIncrement * (yPoints[j] - yLowerBound)) / yValDiff - (scale/2);
        switch (this.lineSeries.getMarker()) {
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
            throw new IllegalArgumentException(
              "Unknown marker type: " + lineSeries.getMarker()
            );
        }
      }
    }
  }
    
}

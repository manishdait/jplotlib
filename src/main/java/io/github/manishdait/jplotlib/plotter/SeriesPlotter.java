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

package io.github.manishdait.jplotlib.plotter;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.chart.BarGraphBuilder;
import io.github.manishdait.jplotlib.chart.LineGraphBuilder;
import io.github.manishdait.jplotlib.chart.PieChartBuilder;
import io.github.manishdait.jplotlib.chart.ScatterGraphBuilder;
import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.data.StyleData;
import io.github.manishdait.jplotlib.internal.util.AxisType;


/**
 * The SeriesPlotter class is responsible for drawing series plots based on the
 * provided SeriesData and StyleData.
 *
 *
 */

public class SeriesPlotter extends JPanel {

  private SeriesData seriesData;
  private List<StyleData> styleData;

  /**
   * Creates a new SeriesPlotter with the given SeriesData and StyleData.
   *
   * @param seriesData The data for the series plot.
   * @param styleData  The style data for the series plot.
   */
  public SeriesPlotter(SeriesData seriesData, List<StyleData> styleData) {
    this.seriesData = seriesData;
    this.styleData = styleData;
  }
    
  @Override
  public void paintComponent(Graphics g) {
    if(seriesData.axisType != AxisType.PIE) {
      for(int i = 0; i < styleData.size(); i++) {
      switch (styleData.get(i).getChartType()) {
        case LINE:
          new LineGraphBuilder(
            g, 
            this, 
            seriesData, 
            styleData.get(i).getLineSeries(), 
            i
          ).draw();
          break;

        case SCATTER:
          new ScatterGraphBuilder(
            g, 
            this, 
            seriesData, 
            styleData.get(i).getScatterSeries(), 
            i
          ).draw();
          break;

        case BAR:
          new BarGraphBuilder(
            g, 
            this, 
            seriesData,
            styleData.get(i).getBarSeries(),
            i
          ).draw();
          break;

        default:
          throw new UnsupportedOperationException(
            "Unimplemented method 'draw'"
          );
        }
      }
    }

    else {
      new PieChartBuilder(
        g,
        this,
        seriesData,
        styleData.get(0).getPieSeries()
      ).draw();
    }
  
  } 

}

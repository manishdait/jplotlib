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

package io.github.manishdait.jplotlib.data;

import io.github.manishdait.jplotlib.chart.BarSeries;
import io.github.manishdait.jplotlib.chart.LineSeries;
import io.github.manishdait.jplotlib.chart.PieSeries;
import io.github.manishdait.jplotlib.chart.ScatterSeries;
import io.github.manishdait.jplotlib.internal.util.ChartType;


/**
 * The StyleData class represents the style and type of a chart series.
 *
 */

public class StyleData extends Coordinates {

  private ChartType chartType;

  private LineSeries lineSeries;
  private ScatterSeries scatterSeries;
  private BarSeries barSeries;
  private PieSeries pieSeries;

  public StyleData() {}

  /**
   * Get the chart type of the style data.
   *
   * @return The chart type.
   */
  public ChartType getChartType() {
    return chartType;
  }

  /**
   * Set the chart type of the style data.
   *
   * @param chartType The chart type to set.
   */
  public void setChartType(ChartType chartType) {
    this.chartType = chartType;
  }

  /**
   * Get the line series associated with the style data.
   *
   * @return The line series.
   */
  public LineSeries getLineSeries() {
    return lineSeries;
   }

  /**
   * Set the line series associated with the style data.
   *
   * @param lineSeries The line series to set.
   */
  public void setLineSeries(LineSeries lineSeries) {
    this.lineSeries = lineSeries;
  }

  /**
   * Get the scatter series associated with the style data.
   *
   * @return The scatter series.
   */
  public ScatterSeries getScatterSeries() {
    return scatterSeries;
  }

  /**
   * Set the scatter series associated with the style data.
   *
   * @param scatterSeries The scatter series to set.
   */
  public void setScatterSeries(ScatterSeries scatterSeries) {
    this.scatterSeries = scatterSeries;
  }

  /**
   * Get the bar series associated with the style data.
   *
   * @return The bar series.
   */
  public BarSeries getBarSeries() {
    return barSeries;
  }

  /**
   * Set the bar series associated with the style data.
   *
   * @param barSeries The bar series to set.
   */
  public void setBarSeries(BarSeries barSeries) {
    this.barSeries = barSeries;
  }

  /**
   * Get the pie series associated with the style data.
   *
   * @return The pie series.
   */
  public PieSeries getPieSeries() {
    return pieSeries;
  }

  /**
   * Set the pie series associated with the style data.
   *
   * @param pieSeries The pie series to set.
   */
  public void setPieSeries(PieSeries pieSeries) {
    this.pieSeries = pieSeries;
  }

}


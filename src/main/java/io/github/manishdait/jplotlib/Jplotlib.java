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

package io.github.manishdait.jplotlib;

import java.util.ArrayList;
import java.util.List;

import io.github.manishdait.jplotlib.chart.BarGraph;
import io.github.manishdait.jplotlib.chart.LineGraph;
import io.github.manishdait.jplotlib.chart.PieChart;
import io.github.manishdait.jplotlib.chart.ScatterGraph;
import io.github.manishdait.jplotlib.chart.helper.BarGraphOptions;
import io.github.manishdait.jplotlib.chart.helper.LineGraphOptions;
import io.github.manishdait.jplotlib.chart.helper.PieChartOptions;
import io.github.manishdait.jplotlib.chart.helper.ScatterGraphOptions;
import io.github.manishdait.jplotlib.data.Coordinates;
import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.data.StyleData;
import io.github.manishdait.jplotlib.error.ArrayLengthMissMatchException;
import io.github.manishdait.jplotlib.internal.util.AxisType;
import io.github.manishdait.jplotlib.ui.BaseFrame;

/**
 * Jplotlib is a Java library for creating and displaying different types of
 * charts. This class serves as the main entry point to create and customize
 * charts. It provides methods to set titles, labels, grid options, and create
 * line graphs, scatter graphs, bar graphs, and pie charts.
 * 
 * 
 * Usage example:
 * Jplotlib jplot = new Jplotlib();
 * jplot.title("My Chart");
 * jplot.xLabel("X Axis");
 * jplot.yLabel("Y Axis");
 * jplot.grid();
 * jplot.plot(new double[]{1, 2, 3, 4}, new double[]{10, 20, 30, 40});
 * jplot.scatter(new double[]{1, 2, 3, 4}, new double[]{10, 20, 30, 40});
 * jplot.bar(new String[]{"A", "B", "C", "D"}, new double[]{10, 20, 30, 40});
 * jplot.pie(new double[]{10, 20, 30, 40});
 * jplot.show();
 *
 * Note: The show() method will display the chart only if it has data points 
 * (coordinates or pieData).
 * 
 * @author Manish Dait
 * @version 1.0.0
 */

public class Jplotlib implements 
  LineGraphOptions, 
  ScatterGraphOptions, 
  BarGraphOptions, 
  PieChartOptions
{

  private BaseFrame baseFrame;
  private SeriesData seriesData;

  private List<StyleData> styleData;

  public Jplotlib() {
    this.seriesData = new SeriesData();
    this.styleData = new ArrayList<StyleData>();
  }

  public final void show() {
    if(seriesData.getCoordinates() == null && seriesData.getPieData() == null) {
      return;
    }
    this.baseFrame = new BaseFrame(this.seriesData, this.styleData);
    this.baseFrame.setVisible(true);
  }

  public final void title(final String str) {
    this.seriesData.setTitle(str);
  }

  public final void xLabel(final String str) {
    this.seriesData.setxLabel(str);
  }

  public final void yLabel(final String str) {
    this.seriesData.setyLabel(str);
  }

  public final void grid() {
    this.seriesData.setxGrid(true);
    this.seriesData.setyGrid(true);
  }

  public final void grid(final boolean xGrid, final boolean yGrid) {
    this.seriesData.setxGrid(xGrid);
    this.seriesData.setyGrid(yGrid);
  }

  private List<Coordinates> setCoordinates(
    final double[] xPoints,
    final double[] yPoints,
    AxisType axisType
  ) {
    List<Coordinates> currCoordinates = new ArrayList<>();
    if (this.seriesData.getCoordinates() != null) {
      currCoordinates = this.seriesData.getCoordinates();
    }

    Coordinates coordinates = new Coordinates();
    coordinates.setxPoints(xPoints);
    coordinates.setyPoints(yPoints);
    currCoordinates.add(coordinates);
    if (
      seriesData.getAxisType() == null ||
      seriesData.getAxisType().getPriority() < axisType.getPriority()
    ) {
      seriesData.setAxisType(axisType);
    }
    
    return currCoordinates;
  }

  private void setLabel(String[] label) {
    seriesData.setLabel(label);
  }

  private double[] tempArr(final double[] yPoints) {
    double[] arr = new double[yPoints.length];
    for (int i = 0; i < yPoints.length; i++) {
      arr[i] = i;
    }
    return arr;
  }

  // LINE GRAPH

  @Override
  public final LineGraph plot(
    final double[] yPoints
  ) {
    double[] temp = tempArr(yPoints);
    List<Coordinates> coordinates = setCoordinates(
      temp,
      yPoints,
      AxisType.PLOT
    );
    this.seriesData.setCoordinates(coordinates);
    LineGraph lineGraph = new LineGraph(this.styleData);
    return lineGraph;
  }

  @Override
  public final LineGraph plot(
    final double[] xPoints,
    final double[] yPoints
  ) {
    if (xPoints.length != yPoints.length) {
      throw new ArrayLengthMissMatchException(
        "xPoints and yPoints must be of same size."
      );
    }

    List<Coordinates> coordinates = setCoordinates(
      xPoints,
      yPoints,
      AxisType.PLOT
    );
    this.seriesData.setCoordinates(coordinates);
    LineGraph lineGraph = new LineGraph(this.styleData);
    return lineGraph;
  }

  // SCATTER GRAPH

  @Override
  public final ScatterGraph scatter(
    final double[] xPoints,
    final double[] yPoints
  ) {
    if (xPoints.length != yPoints.length) {
      throw new ArrayLengthMissMatchException(
        "xPoints and yPoints must be of same size."
      );
    }

    List<Coordinates> coordinates = setCoordinates(
      xPoints,
      yPoints,
      AxisType.PLOT
    );
    this.seriesData.setCoordinates(coordinates);
    ScatterGraph scatterGraph = new ScatterGraph(this.styleData);
    return scatterGraph;
  }

  // BAR GRAPH

  @Override
  public final BarGraph bar(String[] xLabels, double[] yPoints) {
    if (xLabels.length != yPoints.length) {
      throw new ArrayLengthMissMatchException(
        "yPoints and label must be of same size."
      );
    }
    
    List<Coordinates> coordinates = setCoordinates(
      tempArr(yPoints),
      yPoints,
      AxisType.BAR
    );
    setLabel(xLabels);
    this.seriesData.setCoordinates(coordinates);
    BarGraph barGraph = new BarGraph(styleData);
    return barGraph;
  }

  // PIE CHART

  @Override
  public final PieChart pie(double[] dataPoints) {
    this.seriesData.setAxisType(AxisType.PIE);
    this.seriesData.setPieData(dataPoints);
    PieChart pieChart = new PieChart(styleData);
    return pieChart;
  }

}

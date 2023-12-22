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

import io.github.manishdait.jplotlib.charts.bar.BarGraph;
import io.github.manishdait.jplotlib.charts.bar.BarGraphOptions;
import io.github.manishdait.jplotlib.charts.helper.Graph;
import io.github.manishdait.jplotlib.charts.line.LineChart;
import io.github.manishdait.jplotlib.charts.line.LineChartOptions;
import io.github.manishdait.jplotlib.charts.pie.PieChart;
import io.github.manishdait.jplotlib.charts.pie.PieChartOptions;
import io.github.manishdait.jplotlib.charts.scatter.ScatterChart;
import io.github.manishdait.jplotlib.charts.scatter.ScatterChartOptions;
import io.github.manishdait.jplotlib.data.GraphData;
import io.github.manishdait.jplotlib.error.JplotlibError;
import io.github.manishdait.jplotlib.error.util.ErrorConstants;
import io.github.manishdait.jplotlib.data.CartesianData;
import io.github.manishdait.jplotlib.internals.components.axis.Config;
import io.github.manishdait.jplotlib.internals.util.AxisType;
import io.github.manishdait.jplotlib.ui.Window;

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
 * @version 1.1.0
 */

public final class Jplotlib implements
    LineChartOptions,
    ScatterChartOptions,
    BarGraphOptions,
    PieChartOptions {

  protected Window window;
  protected Config axisConfiguration;
  protected List<Graph> graphs;

  private boolean isPlotable;

  public Jplotlib() {
    this.axisConfiguration = new Config();
    this.graphs = new ArrayList<>();
  }

  public final void show() {
    if (!isPlotable) {
      return;
    }
    this.window = new Window(this.axisConfiguration, this.graphs);
    this.window.setVisible(true);
  }

  public final void title(final String str) {
    this.axisConfiguration.setTitle(str);
  }

  public final void xLabel(final String str) {
    this.axisConfiguration.setxLabel(str);
  }

  public final void yLabel(final String str) {
    this.axisConfiguration.setyLabel(str);
  }

  public final void grid() {
    this.axisConfiguration.setxGrid(true);
    this.axisConfiguration.setyGrid(true);
  }

  public final void grid(final boolean xGrid, final boolean yGrid) {
    this.axisConfiguration.setxGrid(xGrid);
    this.axisConfiguration.setyGrid(yGrid);
  }

  private void setAxisType(AxisType axisType) {
    if (axisConfiguration.getAxisType() == null
        || axisConfiguration.getAxisType().getPriority() < axisType.getPriority()) {
      axisConfiguration.setAxisType(axisType);
    }
  }

  private double[] createTempArr(final double[] yPoints) {
    double[] arr = new double[yPoints.length];
    for (int i = 0; i < yPoints.length; i++) {
      arr[i] = i;
    }
    return arr;
  }

  private void setAxisParameters(double[] xPoints, double[] yPoints) {
    setXData(xPoints);
    setYData(yPoints);
  }

  private void setAxisParameters(String[] labels, double[] data, boolean isX) {
    if (isX) {
      setXData(data);
    } else {
      setYData(data);
    }

    for (String label : labels) {
      if (!GraphData.getMap().containsKey(label)) {
        GraphData.getMap().put(label, GraphData.getIndx());
        GraphData.setIndx(GraphData.getIndx() + 1);
      }
    }

    GraphData.setX(isX);
    axisConfiguration.setBarLabelLen(GraphData.getMap().size());
  }

  private void setYData(double[] data) {
    double max = axisConfiguration.getyUpperBound();
    double min = axisConfiguration.getyLowerBound();
    for (double i : data) {
      max = max > i ? max : i;
      min = min < i ? min : i;
    }
    axisConfiguration.setyUpperBound((int) max);
    axisConfiguration.setyLowerBound((int) min);
    axisConfiguration.setMaxYLength(
        axisConfiguration.getMaxYLength() > data.length ? axisConfiguration.getMaxYLength() : data.length);
    axisConfiguration.setTotalYLength(axisConfiguration.getTotalYLength() + data.length);
  }

  private void setXData(double[] data) {
    double max = axisConfiguration.getxUpperBound();
    double min = axisConfiguration.getxLowerBound();
    for (double i : data) {
      max = max > i ? max : i;
      min = min < i ? min : i;
    }
    axisConfiguration.setxUpperBound((int) max);
    axisConfiguration.setxLowerBound((int) min);
    axisConfiguration.setMaxXLength(
        axisConfiguration.getMaxXLength() > data.length ? axisConfiguration.getMaxXLength() : data.length);
    axisConfiguration.setTotalXLength(axisConfiguration.getTotalXLength() + data.length);
  }

  // Line Chart

  @Override
  public LineChart plot(double[] yPoints) {
    if (yPoints == null) {
      throw new JplotlibError(ErrorConstants.NULL_DATA_ERROR);
    }
    double[] xPoints = createTempArr(yPoints);
    setAxisType(AxisType.PLOT);
    setAxisParameters(xPoints, yPoints);
    LineChart lineChart = new LineChart(new CartesianData(xPoints, yPoints));
    graphs.add(lineChart);
    isPlotable = true;
    return lineChart;
  }

  @Override
  public LineChart plot(double[] xPoints, double[] yPoints) {
    if (xPoints == null || yPoints == null) {
      throw new JplotlibError(ErrorConstants.NULL_DATA_ERROR);
    }
    if (xPoints.length != yPoints.length) {
      throw new JplotlibError(ErrorConstants.UNMATCH_DIMENSION_LENGTH_ERROR);
    }
    setAxisType(AxisType.PLOT);
    setAxisParameters(xPoints, yPoints);
    LineChart lineChart = new LineChart(new CartesianData(xPoints, yPoints));
    graphs.add(lineChart);
    isPlotable = true;
    return lineChart;
  }

  // Scatter Chart

  @Override
  public ScatterChart scatter(double[] xPoints, double[] yPoints) {
    if (xPoints == null || yPoints == null) {
      throw new JplotlibError(ErrorConstants.NULL_DATA_ERROR);
    }
    if (xPoints.length != yPoints.length) {
      throw new JplotlibError(ErrorConstants.UNMATCH_DIMENSION_LENGTH_ERROR);
    }
    setAxisType(AxisType.PLOT);
    setAxisParameters(xPoints, yPoints);
    ScatterChart scatterChart = new ScatterChart(new CartesianData(xPoints, yPoints));
    graphs.add(scatterChart);
    isPlotable = true;
    return scatterChart;
  }

  // Bar Graph

  @Override
  public BarGraph bar(String[] labels, double[] points) {
    if (labels == null || points == null) {
      throw new JplotlibError(ErrorConstants.NULL_DATA_ERROR);
    }
    if (labels.length != points.length) {
      throw new JplotlibError(ErrorConstants.MISSMATCH_LABELDATA_LENGTH_ERROR);
    }
    setAxisType(AxisType.BAR);
    setAxisParameters(labels, points, false);
    BarGraph barGraph = new BarGraph(new GraphData(labels, points));
    graphs.add(barGraph);
    isPlotable = true;
    return barGraph;
  }

  @Override
  public BarGraph barh(String[] labels, double[] points) {
    if (labels == null || points == null) {
      throw new JplotlibError(ErrorConstants.NULL_DATA_ERROR);
    }
    if (labels.length != points.length) {
      throw new JplotlibError(ErrorConstants.MISSMATCH_LABELDATA_LENGTH_ERROR);
    }
    setAxisType(AxisType.BAR);
    setAxisParameters(labels, points, true);
    BarGraph barGraph = new BarGraph(new GraphData(labels, points));
    graphs.add(barGraph);
    isPlotable = true;
    return barGraph;
  }

  // Pie Chart

  @Override
  public PieChart pie(double[] dataPoints) {
    if (dataPoints == null) {
      throw new JplotlibError(ErrorConstants.NULL_DATA_ERROR);
    }
    setAxisType(AxisType.PIE);
    PieChart pieChart = new PieChart(new GraphData(null, dataPoints));
    graphs.add(pieChart);
    isPlotable = true;
    return pieChart;
  }

  @Override
  public PieChart pie(double[] dataPoints, String[] labels) {
    if (dataPoints == null || labels == null) {
      throw new JplotlibError(ErrorConstants.NULL_DATA_ERROR);
    }
    if (labels.length != dataPoints.length) {
      throw new JplotlibError(ErrorConstants.MISSMATCH_LABELDATA_LENGTH_ERROR);
    }
    setAxisType(AxisType.PIE);
    PieChart pieChart = new PieChart(new GraphData(labels, dataPoints));
    graphs.add(pieChart);
    isPlotable = true;
    return pieChart;
  }
}

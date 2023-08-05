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

package io.github.manishdait.jplotlib.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.data.StyleData;
import io.github.manishdait.jplotlib.internal.component.axis.AxisBuilder;
import io.github.manishdait.jplotlib.internal.component.label.AxisLabel;
import io.github.manishdait.jplotlib.internal.component.label.TitleLabel;
import io.github.manishdait.jplotlib.internal.component.label.VerticalAxisLabel;
import io.github.manishdait.jplotlib.internal.util.Constants;
import io.github.manishdait.jplotlib.plotter.SeriesPlotter;


/**
 * The ChartPanel class represents a custom JPanel used for rendering Jplotlib 
 * charts and data visualizations.
 * 
 * This class extends the standard JPanel and provides functionality to display 
 * a Jplotlib chart within a JPanel container. It dynamically renders the chart 
 * based on the provided SeriesData and StyleData, ensuring that the chart is 
 * properly displayed with the appropriate title, axis labels, and data points.
 * 
 * The ChartPanel handles the rendering of the chart by using the provided 
 * Graphics object. It sets the title, x-axis label, and y-axis label, and then 
 * plots the data points using the SeriesPlotter class.
 * 
 * 
 */

public class ChartPanel extends JPanel {

  private SeriesData seriesData;

  private List<StyleData> styleData;
    
  private TitleLabel title = new TitleLabel();
  private AxisLabel xLabel = new AxisLabel();
  private VerticalAxisLabel yLabel = new VerticalAxisLabel();

  private JPanel graph = new JPanel();

  /**
   * Constructs a new ChartPanel with the specified SeriesData and List of 
   * StyleData.
   *
   * @param seriesData the SeriesData containing the data points for the chart.
   * @param styleData the List of StyleData containing style information for the
   * chart.
   */

  public ChartPanel(SeriesData seriesData, List<StyleData> styleData) {
    super.setBackground(new Color(255, 255, 255, 255));
    this.seriesData = seriesData;
    this.styleData = styleData;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    // Set title label
    this.title.setBounds(
      0, 
      60, 
      this.getWidth(), 
      20
    );
    this.title.setText(this.seriesData.getTitle());
    this.add(title);

    // Set xLabel label
    this.xLabel.setBounds(
      0, 
      this.getHeight() - 60, 
      this.getWidth(), 
      20
    );
    this.xLabel.setText(this.seriesData.getxLabel());
    this.add(xLabel);

    // Set yLabel label
    this.yLabel.setBounds(
      0, 
      0, 
      40, 
      this.getHeight()
    );
    this.yLabel.setText(this.seriesData.getyLabel());
    this.add(yLabel);

    // Build and draw axes
    new AxisBuilder(g, this, seriesData).buildAxis();

    // Plot and draw graph
    setGraph(this.graph);
    plotGraph();
  }

  private void setGraph(JPanel graph) {
    this.remove(this.graph);
    this.graph = graph;
    this.graph.setBounds(
      Constants.MARGIN, 
      Constants.MARGIN, 
      this.getWidth() - (Constants.MARGIN * 2), 
      this.getHeight() - (Constants.MARGIN * 2)
    );
    this.add(graph);
  }

  private void plotGraph() {
    JPanel graph = new SeriesPlotter(seriesData, styleData);
    setGraph(graph);
  }

}

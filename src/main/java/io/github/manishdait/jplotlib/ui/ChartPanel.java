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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import io.github.manishdait.jplotlib.charts.helper.Graph;
import io.github.manishdait.jplotlib.charts.helper.GraphPlotter;
import io.github.manishdait.jplotlib.internals.components.axis.Axis;
import io.github.manishdait.jplotlib.internals.components.axis.Config;
import io.github.manishdait.jplotlib.internals.components.label.AxisLabel;
import io.github.manishdait.jplotlib.internals.components.label.TitleLabel;
import io.github.manishdait.jplotlib.internals.components.label.VerticalAxisLabel;
import io.github.manishdait.jplotlib.internals.util.Constants;

/**
 * The ChartPanel class represents a custom JPanel used for rendering Jplotlib
 * charts and data visualizations.
 * 
 * This class extends the standard JPanel and provides functionality to display
 * a Jplotlib chart within a JPanel container. It dynamically renders the chart
 * based on the provided AxisConfiguration and Graphs, ensuring that the chart
 * is properly displayed with the appropriate title, axis labels, and data points.
 * 
 * The ChartPanel handles the rendering of the chart by using the provided
 * Graphics object. It sets the title, x-axis label, and y-axis label, and then
 * plots the data points using the GraphPlotter class.
 * 
 * 
 */
public class ChartPanel extends JPanel {

    private transient Config axisConfiguration;
    private transient List<Graph> graphs;

    private TitleLabel title = new TitleLabel();
    private AxisLabel xLabel = new AxisLabel();
    private VerticalAxisLabel yLabel = new VerticalAxisLabel();

    private JPanel graph = new JPanel();
    private BorderLayout borderlayout = new BorderLayout();

    /**
     * Constructs a new ChartPanel with the specified AxisConfiguration and List of
     * Graphs.
     * 
     * @param axisConfiguration
     *            the AxisConfiguration defining rendering properties for the axis.
     * @param graphs
     *            the List of Graphs containing style and data
     *            information
     *            for the charts.
     *
     */
    public ChartPanel(Config axisConfiguration, List<Graph> graphs) {
        super.setBackground(new Color(255, 255, 255, 255));
        this.axisConfiguration = axisConfiguration;
        this.graphs = graphs;
        this.setLayout(borderlayout);
        this.setBorder(BorderFactory.createEmptyBorder(40, 10, 40, 10));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set title label
        this.title.setText(this.axisConfiguration.getTitle());
        this.add(title, BorderLayout.NORTH);

        // Set xLabel label
        this.xLabel.setText(this.axisConfiguration.getxLabel());
        this.add(xLabel, BorderLayout.SOUTH);

        // Set yLabel label
        this.yLabel.setText(this.axisConfiguration.getyLabel());
        this.add(yLabel, BorderLayout.LINE_START);
        
        // Build and draw axis
        new Axis(g, this, axisConfiguration).drawAxis();
        setGraph(this.graph);
        
        // Plot and draw graph
        plotGraph();
        
    }

    private void setGraph(JPanel graph) {
        this.remove(this.graph);
        this.graph = graph;
        this.graph.setBounds(
                Constants.MARGIN,
                Constants.MARGIN,
                this.getWidth() - (Constants.MARGIN * 2),
                this.getHeight() - (Constants.MARGIN * 2));
        this.add(graph, BorderLayout.CENTER);
    }

    private void plotGraph() {
        JPanel plot = new GraphPlotter(axisConfiguration, graphs);
        setGraph(plot);
        this.repaint();
    }

}

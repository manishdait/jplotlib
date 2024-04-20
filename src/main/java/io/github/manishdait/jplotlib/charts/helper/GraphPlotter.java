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

package io.github.manishdait.jplotlib.charts.helper;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.charts.area.AreaChart;
import io.github.manishdait.jplotlib.charts.area.AreaChartPotter;
import io.github.manishdait.jplotlib.charts.bar.BarGraph;
import io.github.manishdait.jplotlib.charts.bar.BarGraphPlotter;
import io.github.manishdait.jplotlib.charts.line.LineChart;
import io.github.manishdait.jplotlib.charts.line.LineChartPlotter;
import io.github.manishdait.jplotlib.charts.pie.PieChart;
import io.github.manishdait.jplotlib.charts.pie.PieChartPlotter;
import io.github.manishdait.jplotlib.charts.scatter.ScatterChart;
import io.github.manishdait.jplotlib.charts.scatter.ScatterChartPlotter;
import io.github.manishdait.jplotlib.internals.components.axis.Config;
import io.github.manishdait.jplotlib.internals.util.AxisType;

/**
 * The GraphPlotter class is responsible for drawing plots based on the
 * provided AxisConfiguration and List of Graphs.
 *
 */
public class GraphPlotter extends JPanel {

    private transient Config axisConfiguration;
    private transient List<Graph> graphs;

    /**
     * Creates a new GraphPlotter with the given AxisConfiguration and List of
     * Graphs.
     *
     * @param axisConfiguration
     *            the Configuration for rendering axis.
     * @param graphs
     *            The style data of the graphs.
     */
    public GraphPlotter(Config axisConfiguration, List<Graph> graphs) {
        this.axisConfiguration = axisConfiguration;
        this.graphs = graphs;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < graphs.size(); i++) {
            if (axisConfiguration.getAxisType() == AxisType.PIE && graphs.get(i) instanceof PieChart) {
                new PieChartPlotter(g, this, (PieChart) graphs.get(i)).draw();
            } else if (axisConfiguration.getAxisType() != AxisType.PIE) {
                if (graphs.get(i) instanceof LineChart) {
                    new LineChartPlotter(g, this, axisConfiguration, (LineChart) graphs.get(i), i).draw();
                }

                else if (graphs.get(i) instanceof ScatterChart) {
                    new ScatterChartPlotter(g, this, axisConfiguration, (ScatterChart) graphs.get(i), i).draw();
                }

                else if (graphs.get(i) instanceof BarGraph) {
                    new BarGraphPlotter(g, this, axisConfiguration, (BarGraph) graphs.get(i), i).draw();
                }

                else if (graphs.get(i) instanceof AreaChart) {
                    new AreaChartPotter(g, this, axisConfiguration, (AreaChart) graphs.get(i), i).draw();
                }
            }
        }
    }

}

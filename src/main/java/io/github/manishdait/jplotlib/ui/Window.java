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
import java.util.List;

import javax.swing.JFrame;

import io.github.manishdait.jplotlib.charts.helper.Graph;
import io.github.manishdait.jplotlib.internals.components.axis.Config;
import io.github.manishdait.jplotlib.internals.util.Constants;

/**
 * The Window class represents a custom JFrame that serves as the base window
 * for displaying Jplotlib charts.
 * 
 * This class extends the standard JFrame class and is used to create a window
 * that contains a ChartPanel for rendering the Jplotlib charts. It provides an
 * interface for displaying various types of plots and data visualizations.
 * 
 * The Window is created with a specific AxisConfiguration and a List of Graphs,
 * which define the data and styles for the charts/graph to be displayed in the
 * frame.
 * 
 */
public class Window extends JFrame {

    private ChartPanel chartPanel;
    private BorderLayout borderLayout = new BorderLayout();

    /**
     * Constructs a new Window with the specified AxisConfiguration and List of
     * Graphs.
     * 
     * @param axisConfiguration
     *            the AxisConfiguration defining rendering properties
     *            for the axis.
     * @param graphs
     *            the List of Graph containing style and data
     *            information for the charts.
     *
     */
    public Window(Config axisConfiguration, List<Graph> graphs) {
        this.setTitle(Constants.PROVIDER);
        this.setSize(Constants.WIDTH, Constants.HEIGTH);
        this.setLayout(borderLayout);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.chartPanel = new ChartPanel(axisConfiguration, graphs);
        this.add(this.chartPanel, BorderLayout.CENTER);
    }

}

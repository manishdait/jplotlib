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

package io.github.manishdait.jplotlib.charts.bar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.charts.helper.Plotter;
import io.github.manishdait.jplotlib.data.GraphData;
import io.github.manishdait.jplotlib.defaults.color.PlotColor;
import io.github.manishdait.jplotlib.internals.components.axis.Config;

/**
 * The BarGraphPlotter class implements the Plotter interface and is responsible
 * for rendering
 * BarGraph objects by drawing bars on a JPanel based on the provided axis
 * configuration and data.
 * It handles the visualization of vertical and horizontal bar graphs within the
 * JPlotLib library.
 * 
 */
public class BarGraphPlotter implements Plotter {

    private Graphics2D g;
    private JPanel context;
    private Config axisConfiguration;
    private BarGraph barGraph;
    private int indx;

    /**
     * Constructs a BarGraphPlotter with necessary rendering context, axis
     * configuration,
     * BarGraph data, and an index for styling.
     *
     * @param g
     *            The Graphics object used for rendering.
     * @param context
     *            The JPanel where the bars will be drawn.
     * @param axisConfiguration
     *            The configuration for rendering the axis.
     * @param barGraph
     *            The BarGraph object containing data and style settings.
     * @param indx
     *            The index used for styling multiple bars.
     */
    public BarGraphPlotter(
            Graphics g,
            JPanel context,
            Config axisConfiguration,
            BarGraph barGraph,
            int indx) {
        this.g = (Graphics2D) g;
        this.context = context;
        this.axisConfiguration = axisConfiguration;
        this.barGraph = barGraph;
        this.indx = indx;
    }

    @Override
    public void draw() {
        double[] datas = ((GraphData) this.barGraph.getValues()).getData();
        String[] labels = ((GraphData) this.barGraph.getValues()).getLabels();

        this.g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Color color = barGraph.getStyle().getColor();
        if (color == null) {
            color = PlotColor.getColor(indx);
        }

        this.g.setColor(color);

        if (!GraphData.isX()) {
            int yLowerBound = axisConfiguration.getyLowerBound();

            int xIncrement = axisConfiguration.getxIncrement();
            int xValDiff = context.getWidth() / (axisConfiguration.getBarLabelLen() * 2);

            int yIncrement = axisConfiguration.getyIncrement();
            int yValDiff = axisConfiguration.getyValDiff();

            int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

            for (int i = 0; i < datas.length; i++) {
                int x = ((xIncrement * (GraphData.getMap().get(labels[i]) * 2 + 1)) - (xValDiff / 2));
                int y = context.getHeight() - ((int) (yIncrement * (datas[i] - yLowerBound)) / yValDiff);
                int h = (int) (yIncrement * (datas[i] - yLowerBound)) / yValDiff;

                this.g.fillRect(
                        x,
                        y - extraSpace,
                        xValDiff,
                        h + extraSpace);
            }
        } else {
            int xLowerBound = axisConfiguration.getxLowerBound();

            int yIncrement = axisConfiguration.getyIncrement();
            int yValDiff = context.getHeight() / (axisConfiguration.getBarLabelLen() * 2);

            int xIncrement = axisConfiguration.getxIncrement();
            int xValDiff = axisConfiguration.getxValDiff();

            int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

            for (int i = 0; i < datas.length; i++) {
                int y = context.getHeight() - (yIncrement * (GraphData.getMap().get(labels[i]) * 2 + 1))
                        - (yValDiff / 2);
                int x = 1;
                int w = (int) (xIncrement * (datas[i] - xLowerBound)) / xValDiff;
                this.g.fillRect(
                        x,
                        y,
                        w + extraSpace,
                        yValDiff);
            }
        }

    }

}

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

package io.github.manishdait.jplotlib.charts.pie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.charts.helper.Plotter;
import io.github.manishdait.jplotlib.data.GraphData;
import io.github.manishdait.jplotlib.defaults.color.PlotColor;

/**
 * The PieChartPlotter class implements the Plotter interface and is responsible
 * for rendering PieChart objects by drawing slices on a JPanel based on the
 * provided data and context.
 * It handles the visualization of pie charts within the JPlotLib library.
 * 
 */
public class PieChartPlotter implements Plotter {

    private Graphics2D g;
    private JPanel context;
    private PieChart pieChart;

    /**
     * Constructs a PieChartPlotter with the necessary rendering context and
     * PieChart object.
     *
     * @param g
     *            The Graphics object used for rendering.
     * @param context
     *            The JPanel where the pie chart slices will be drawn.
     * @param pieChart
     *            The PieChart object containing data and style settings.
     */
    public PieChartPlotter(
            Graphics g,
            JPanel context,
            PieChart pieChart) {
        this.g = (Graphics2D) g;
        this.context = context;
        this.pieChart = pieChart;
    }

    @Override
    public void draw() {
        double[] data = ((GraphData) pieChart.getValues()).getData();

        this.g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int width = (context.getWidth()) / 2;
        int height = (context.getHeight()) / 2;

        double sum = 0;
        for (double i : data) {
            sum += i;
        }

        sum = sum == 0 ? 1 : sum;
        double diff = 360 / sum;
        int radius = Math.min(context.getHeight(), context.getWidth()) / 2 - 40;

        int prevAng = 0;
        Color[] color = pieChart.getStyle().getColor();

        for (int i = 0; i < data.length; i++) {
            if (color == null) {
                this.g.setColor(PlotColor.getColor(i));
            } else {
                this.g.setColor(color[i]);
            }

            this.g.fillArc(
                    width - radius,
                    height - radius,
                    radius * 2,
                    radius * 2,
                    prevAng,
                    (int) (data[i] * diff));

            prevAng += (int) (data[i] * diff);

            if (i == data.length - 1 && prevAng != 360) {
                this.g.fillArc(
                        width - radius,
                        height - radius,
                        radius * 2,
                        radius * 2,
                        prevAng,
                        360 - prevAng);
            }
        }
    }

}

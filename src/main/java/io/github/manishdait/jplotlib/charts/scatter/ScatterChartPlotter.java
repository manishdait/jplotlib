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

package io.github.manishdait.jplotlib.charts.scatter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.charts.helper.PlotLogger;
import io.github.manishdait.jplotlib.charts.helper.Plotter;
import io.github.manishdait.jplotlib.data.CartesianData;
import io.github.manishdait.jplotlib.defaults.color.PlotColor;
import io.github.manishdait.jplotlib.internals.components.axis.Config;

/**
 * The ScatterChartPlotter class is responsible for rendering ScatterChart
 * objects on a JPanel by drawing
 * individual data points based on the provided axis configuration and style
 * information.
 * 
 */
public class ScatterChartPlotter implements Plotter {

    private Graphics2D g;
    private Config axisConfiguration;
    private ScatterChart scatterChart;
    private int indx;
    private int heigth;

    /**
     * Constructs a ScatterChartPlotter with the necessary rendering context and
     * chart data.
     *
     * @param g
     *            The Graphics object used for rendering.
     * @param context
     *            The JPanel where the scatter chart will be drawn.
     * @param axisConfiguration
     *            The configuration for rendering the axis.
     * @param scatterChart
     *            The ScatterChart object containing data to be plotted.
     * @param indx
     *            The index used for styling multiple charts.
     */
    public ScatterChartPlotter(
            Graphics g,
            JPanel context,
            Config axisConfiguration,
            ScatterChart scatterChart,
            int indx) {
        this.g = (Graphics2D) g;
        this.axisConfiguration = axisConfiguration;
        this.scatterChart = scatterChart;
        this.indx = indx;
        this.heigth = context.getHeight();
    }

    @Override
    public void draw() {
        double[] xPoints = ((CartesianData) this.scatterChart.getCoordinates()).getxPoints();
        double[] yPoints = ((CartesianData) this.scatterChart.getCoordinates()).getyPoints();

        this.g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int yValDiff = axisConfiguration.getyValDiff();
        int xValDiff = axisConfiguration.getxValDiff();

        int xIncrement = axisConfiguration.getxIncrement();
        int yIncrement = axisConfiguration.getyIncrement();

        int xLowerBound = axisConfiguration.getxLowerBound();
        int yLowerBound = axisConfiguration.getyLowerBound();

        int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

        Color color = scatterChart.getStyle().getColor();

        if (color == null) {
            color = PlotColor.getColor(indx);
        }

        color = setAlpa(color);

        this.g.setColor(color);

        for (int i = 0; i < yPoints.length; i++) {
            int scale = scatterChart.getStyle().getScale() == null
                    ? 8
                    : scatterChart.getStyle().getScale()[i] * 5;

            if (scale < 5 || scale > 50) {
                scale = 8;
            }

            int x = (int) (xIncrement * (xPoints[i] - xLowerBound)) / xValDiff - scale / 2;
            int y = heigth- (int) (yIncrement * (yPoints[i] - yLowerBound)) / yValDiff - scale / 2;
            switch (scatterChart.getStyle().getMarker()) {
                case NONE:
                case CIRCLE:
                    this.g.fillOval(
                            x + extraSpace,
                            y - extraSpace,
                            scale,
                            scale);
                    break;

                case SQUARE:
                    this.g.fillRect(
                            x + extraSpace,
                            y - extraSpace,
                            scale,
                            scale);
                    break;

                default:
                    PlotLogger.getLogger().error("Error Unknown Marker type {}", scatterChart.getStyle().getMarker());
            }

        }
    }

    /**
     * Adjusts the alpha (transparency) level of the provided color based on style
     * information
     * to ensure proper rendering of the scatter chart.
     *
     * @param color
     *            The input color for which alpha will be adjusted.
     * @return Color The adjusted color with alpha transparency applied.
     */
    private Color setAlpa(Color color) {
        Color currColor = color;
        float alpha = scatterChart.getStyle().getAlpha();
        if (alpha < 0 || alpha > 1) {
            alpha = 1;
        }
        return new Color(currColor.getRed(), currColor.getGreen(), currColor.getBlue(), (int) (alpha * 255));
    }

}

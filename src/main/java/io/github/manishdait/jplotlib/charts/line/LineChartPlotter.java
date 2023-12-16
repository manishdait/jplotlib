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

package io.github.manishdait.jplotlib.charts.line;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.charts.helper.Plotter;
import io.github.manishdait.jplotlib.data.CartesianData;
import io.github.manishdait.jplotlib.defaults.color.PlotColor;
import io.github.manishdait.jplotlib.defaults.marker.Marker;
import io.github.manishdait.jplotlib.internals.components.axis.Config;
import io.github.manishdait.jplotlib.internals.util.Constants;

/**
 * The LineChartPlotter class implements the Plotter interface and is
 * responsible for drawing a line chart.
 * It uses provided data coordinates and style settings to render a line chart
 * on the specified context.
 * 
 */
public class LineChartPlotter implements Plotter {
    private Graphics2D g;
    private LineChart lineChart;
    private int indx;

    private int yValDiff;
    private int xValDiff;

    private int xIncrement;
    private int yIncrement;

    private int xLowerBound;
    private int yLowerBound;
    private double[] xPoints;
    private double[] yPoints;

    private int heigth;

    /**
     * Constructs a LineChartPlotter with the necessary information to draw a line
     * chart.
     *
     * @param g2
     *            The Graphics object to draw on.
     * @param context
     *            The JPanel context where the chart is drawn.
     * @param axisConfiguration
     *            The axis configuration for the chart.
     * @param lineChart
     *            The LineChart object containing data and style
     *            settings.
     * @param indx
     *            The index used for styling or identifying the chart.
     */
    public LineChartPlotter(
            Graphics g2,
            JPanel context,
            Config axisConfiguration,
            LineChart lineChart,
            int indx) {
        this.g = (Graphics2D) g2;
        this.lineChart = lineChart;
        this.indx = indx;

        this.heigth = context.getHeight();

        this.yValDiff = axisConfiguration.getyValDiff();
        this.xValDiff = axisConfiguration.getxValDiff();

        this.xIncrement = axisConfiguration.getxIncrement();
        this.yIncrement = axisConfiguration.getyIncrement();

        this.xLowerBound = axisConfiguration.getxLowerBound();
        this.yLowerBound = axisConfiguration.getyLowerBound();
    }

    @Override
    public void draw() {
        xPoints = ((CartesianData) this.lineChart.getCoordinates()).getxPoints();
        yPoints = ((CartesianData) this.lineChart.getCoordinates()).getyPoints();

        this.g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

        for (int i = 0; i < yPoints.length - 1; i++) {
            float lineWidth = this.lineChart.getStyle().getLineWidth();

            Color color = this.lineChart.getStyle().getColor();

            if (color == null) {
                color = PlotColor.getColor(indx);
            }

            if (this.lineChart.getStyle().getMarkerColor() == null) {
                this.lineChart.getStyle().setMarkerColor(color);
            }

            this.g.setColor(color);

            switch (this.lineChart.getStyle().getLineStyle()) {
                case NONE:
                    this.g.setStroke(new BasicStroke(lineWidth));
                    break;

                case DASHED:
                    float[] dashPattern = { 6F * (int) lineWidth, 6F * (int) lineWidth };
                    BasicStroke dashedStroke = new BasicStroke(
                            lineWidth, BasicStroke.CAP_BUTT,
                            BasicStroke.JOIN_ROUND,
                            0F,
                            dashPattern,
                            0F);
                    g.setStroke(dashedStroke);
                    break;

                default:
                    this.g.setStroke(new BasicStroke(lineWidth));
            }

            double x1 = (xIncrement * (xPoints[i] - xLowerBound)) / xValDiff;
            double x2 = (xIncrement * (xPoints[i + 1] - xLowerBound)) / xValDiff;

            double y1 = heigth - (yIncrement * (yPoints[i] - yLowerBound)) / yValDiff;
            double y2 = heigth - (yIncrement * (yPoints[i + 1] - yLowerBound)) / yValDiff;

            Shape l = new Line2D.Double(
                    x1 + extraSpace,
                    y1 - extraSpace,
                    x2 + extraSpace,
                    y2 - extraSpace);

            g.draw(l);
        }

        if (this.lineChart.getStyle().getMarker() != Marker.NONE) {
            drawMarker(extraSpace);
        }
    }

    private void drawMarker(int extraSpace) {
        int scale = this.lineChart.getStyle().getMarkerSize() * Constants.MIN_MARKER_SCALE;

        if (scale < Constants.MIN_MARKER_SCALE || scale > Constants.MAX_MARKER_SCALE) {
            scale = Constants.DEFAULT_MARKER_SCALE;
        }

        for (int j = 0; j < yPoints.length; j++) {
            g.setColor(this.lineChart.getStyle().getMarkerColor());
            int x = (int) (xIncrement * (xPoints[j] - xLowerBound)) / xValDiff - (scale / 2);
            int y = heigth - (int) (yIncrement * (yPoints[j] - yLowerBound)) / yValDiff - (scale / 2);
            switch (this.lineChart.getStyle().getMarker()) {
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
                    throw new IllegalArgumentException("Unknown marker type: " + this.lineChart.getStyle().getMarker());
            }
        }
    }
}

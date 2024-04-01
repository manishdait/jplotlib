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

package io.github.manishdait.jplotlib.charts.area;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import io.github.manishdait.jplotlib.charts.helper.Plotter;
import io.github.manishdait.jplotlib.data.CartesianData;
import io.github.manishdait.jplotlib.defaults.color.PlotColor;
import io.github.manishdait.jplotlib.internals.components.axis.Config;

/**
 * The AreaChartPlotter class is responsible for rendering AreaChart
 * objects on a JPanel by drawing
 * individual data polygon based on the provided axis configuration, coordinates
 * and style information.
 * 
 */
public class AreaChartPotter implements Plotter {

    private Graphics2D g;
    private AreaChart areaGraph;
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
     * Constructs a AreaChartPlotter with the necessary rendering context and
     * chart data.
     *
     * @param g
     *            The Graphics object used for rendering.
     * @param context
     *            The JPanel where the area chart will be drawn.
     * @param axisConfiguration
     *            The configuration for rendering the axis.
     * @param areaGraph
     *            The AreaChart object containing data to be plotted.
     * @param indx
     *            The index used for styling multiple charts.
     */
    public AreaChartPotter(Graphics g,
            JPanel context,
            Config axisConfiguration,
            AreaChart areaGraph,
            int indx) {
        this.g = (Graphics2D) g;
        this.areaGraph = areaGraph;
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
        xPoints = ((CartesianData) areaGraph.getData()).getxPoints();
        yPoints = ((CartesianData) areaGraph.getData()).getyPoints();

        int[] xTemp = new  int[xPoints.length + 2];
        int[] yTemp = new int[yPoints.length + 2];

        this.g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

        for (int i = 0; i < xPoints.length; i++) {
            xTemp[i+1] = ((int)(xIncrement * (xPoints[i] - xLowerBound)) / xValDiff) + extraSpace;
        }

        for (int i = 0; i < xPoints.length; i++) {
            yTemp[i+1] = (heigth - (int)(yIncrement * (yPoints[i] - yLowerBound)) / yValDiff) - extraSpace;
        }

        xTemp[0] = ((int)(xIncrement * (xPoints[0] - xLowerBound)) / xValDiff) + extraSpace;
        yTemp[0] = (heigth - (yIncrement * (0 - yLowerBound)) / yValDiff) - extraSpace;

        xTemp[xTemp.length - 1] = ((int)(xIncrement * (xPoints[xPoints.length - 1] - xLowerBound)) / xValDiff) + extraSpace;
        yTemp[yTemp.length - 1] = (heigth - (yIncrement * (0 - yLowerBound)) / yValDiff) - extraSpace;
        Color color = areaGraph.getStyle().getColor();
        if (color == null) {
         color = PlotColor.getColor(indx);   
        }

        g.setColor(color);
        g.drawPolygon(xTemp, yTemp, xTemp.length);

        color = setAlpa(color);
        g.setColor(color);
        g.fillPolygon(xTemp, yTemp, xTemp.length);

    }

    /**
     * Adjusts the alpha (transparency) level of the provided color based on style
     * information
     * to ensure proper rendering of the area chart.
     *
     * @param color
     *            The input color for which alpha will be adjusted.
     * @return Color The adjusted color with alpha transparency applied.
     */
    private Color setAlpa(Color color) {
        Color currColor = color;
        float alpha = areaGraph.getStyle().getAlpha();
        if (alpha < 0 || alpha > 1) {
            alpha = 1;
        }
        return new Color(currColor.getRed(), currColor.getGreen(), currColor.getBlue(), (int) (alpha * 255));
    }

}

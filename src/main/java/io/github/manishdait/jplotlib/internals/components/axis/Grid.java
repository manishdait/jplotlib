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

package io.github.manishdait.jplotlib.internals.components.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.GraphData;
import io.github.manishdait.jplotlib.internals.util.AxisType;
import io.github.manishdait.jplotlib.internals.util.Constants;

/**
 * The Grid class is responsible for drawing the grid lines on the chart.
 * 
 * This class provides methods to build the grid lines for different chart
 * types, including regular plot charts and bar charts. The grid lines are drawn
 * based on the data points and axis bounds provided in the AixsConfiguration
 * object.
 * 
 * The Grid class is used internally by the Jplotlib library and is not intended
 * to be used directly by users.
 * 
 */
class Grid {

    private Graphics2D g;
    private Config axisConfiguration;
    private JPanel context;

    int xTotalPoints;
    int yTotalPoints;

    int xBounds;
    int yBounds;

    int xValDiff;
    int yValDiff;

    /**
     * Constructs a Grid object with the specified graphics, JPanel context,
     * and axisConfiguration.
     * 
     * @param g
     *            the graphics context for drawing the grid lines.
     * @param context
     *            the chart context (JPanel) where the grid lines will
     *            be
     *            drawn.
     * @param axisConfiguration
     *            the Configuration for rendering axis.
     */
    public Grid(Graphics g, JPanel context, Config axisConfiguration) {
        this.g = (Graphics2D) g;
        this.axisConfiguration = axisConfiguration;
        this.context = context;
    }

    /**
     * Builds the grid lines for the chart based on the chart type (plot or bar).
     */
    public void buildGrid() {

        this.g.setColor(new Color(231, 231, 231));
        this.g.setStroke(new BasicStroke(1.4F));

        xBounds = axisConfiguration.getxUpperBound() - axisConfiguration.getxLowerBound();
        yBounds = axisConfiguration.getyUpperBound() - axisConfiguration.getyLowerBound();

        xValDiff = axisConfiguration.getxValDiff();
        yValDiff = axisConfiguration.getyValDiff();

        xTotalPoints = xBounds / xValDiff;
        yTotalPoints = yBounds / yValDiff;

        xTotalPoints = (xBounds % xValDiff) == 0 ? xTotalPoints : xTotalPoints + 1;
        yTotalPoints = (yBounds % yValDiff) == 0 ? yTotalPoints : yTotalPoints + 1;

        if (axisConfiguration.getAxisType() != AxisType.BAR) {
            baseGrid();
        } else {
            barGrid();
        }

    }

    /**
     * Draws the grid lines for regular plot charts.
     */
    private void baseGrid() {
        int xIncrement = this.axisConfiguration.getxIncrement();
        int yIncrement = this.axisConfiguration.getyIncrement();

        int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

        if (this.axisConfiguration.isxGrid()) {
            for (int i = 0; i <= xTotalPoints; i++) {
                int x = Constants.MARGIN + (xIncrement * i) + extraSpace;
                this.g.drawLine(
                        x,
                        Constants.MARGIN + 1,
                        x,
                        this.context.getHeight() - Constants.MARGIN - 1);
            }
        }

        if (this.axisConfiguration.isyGrid()) {
            for (int i = 0; i <= yTotalPoints; i++) {
                int y = this.context.getHeight() - Constants.MARGIN - (yIncrement * i);
                this.g.drawLine(
                        Constants.MARGIN + 1,
                        y - extraSpace,
                        this.context.getWidth() - Constants.MARGIN - 1,
                        y - extraSpace);
            }
        }
    }

    /**
     * Draws the grid lines for bar charts.
     */
    private void barGrid() {
        if (!GraphData.isX()) {
            plotBarGridForX();
        } else {
            int xIncrement = this.axisConfiguration.getxIncrement();
            int yIncrement = this.axisConfiguration.getyIncrement();

            int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

            if (this.axisConfiguration.isxGrid()) {
                for (int i = 0; i <= xTotalPoints; i++) {
                    int x = Constants.MARGIN + xIncrement * i;
                    this.g.drawLine(
                            x + extraSpace,
                            Constants.MARGIN,
                            x + extraSpace,
                            this.context.getHeight() - Constants.MARGIN);
                }
            }

            if (this.axisConfiguration.isyGrid()) {
                for (int i = 0; i < axisConfiguration.getBarLabelLen(); i++) {
                    int y = this.context.getHeight() - Constants.MARGIN - yIncrement * (i * 2 + 1);
                    this.g.drawLine(
                            Constants.MARGIN,
                            y,
                            this.context.getWidth() - Constants.MARGIN,
                            y);
                }
            }
        }
    }

    private void plotBarGridForX() {
        int xIncrement = this.axisConfiguration.getxIncrement();
        int yIncrement = this.axisConfiguration.getyIncrement();

        int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

        if (this.axisConfiguration.isxGrid()) {
            for (int i = 0; i < axisConfiguration.getBarLabelLen(); i++) {
                int x = Constants.MARGIN + (xIncrement * (i * 2 + 1));
                this.g.drawLine(
                        x,
                        Constants.MARGIN,
                        x,
                        this.context.getHeight() - Constants.MARGIN);
            }
        }

        if (this.axisConfiguration.isyGrid()) {
            for (int i = 0; i <= yTotalPoints; i++) {
                int y = this.context.getHeight() - Constants.MARGIN - (yIncrement * i);
                this.g.drawLine(
                        Constants.MARGIN,
                        y - extraSpace,
                        this.context.getWidth() - Constants.MARGIN,
                        y - extraSpace);
            }
        }
    }

}

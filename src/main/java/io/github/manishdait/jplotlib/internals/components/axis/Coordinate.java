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

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Map;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.data.GraphData;
import io.github.manishdait.jplotlib.data.util.DataDiffer;
import io.github.manishdait.jplotlib.internals.util.AxisType;
import io.github.manishdait.jplotlib.internals.util.Constants;

/**
 * The Coordinate class represents an axis layout and labeling component for
 * Jplotlib charts.
 * 
 * This class is responsible for labeling coordinates of the X-axis and Y-axis
 * of Jplotlib charts. It calculates the axis tange, increments, and ticks based
 * on the provided Graphics, JPanel context, and AxisConfiguration data.
 * The coordinates are rendered dynamically based on the data points and chart
 * type.
 * 
 * The Coordinate class is not intended for direct instantiation, as it is
 * internally used by Jplotlib.
 * 
 */
class Coordinate {

    private Graphics2D g;
    private Config axisConfiguration;
    private int heigth;
    private int width;

    protected Coordinate() {
    }

    /**
     * Constructs a new Coordinate object with the specified Graphics, JPanel
     * context, and AxisConfiguration.
     *
     * @param g
     *            the Graphics object used for drawing the axes.
     * @param context
     *            the JPanel context within which the axes will be
     *            drawn.
     * @param axisConfiguration
     *            the Configuration for rendering axis.
     */
    public Coordinate(Graphics g, JPanel context, Config axisConfiguration) {
        this.g = (Graphics2D) g;
        this.axisConfiguration = axisConfiguration;
        this.g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.g.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        this.heigth = context.getHeight();
        this.width = context.getWidth();
    }

    /**
     * Draws the X-axis and Y-axis coordinates,and ticks based on the
     * AxisConfiguration.
     */
    public void drawCoordinates() {
        if (axisConfiguration.getAxisType() != AxisType.BAR) {
            baseLayout();
        } else {
            barLayout();
        }
    }

    private void baseLayout() {
        int xRange = axisConfiguration.getxUpperBound() - axisConfiguration.getxLowerBound();
        int xValDiff = DataDiffer.getValDiff(xRange, axisConfiguration.getTotalXLength());

        int totalX = getTotalTicks(xRange, xValDiff);
        int xIncrement = getIncrement(width, totalX);

        axisConfiguration.setxValDiff(xValDiff);
        axisConfiguration.setxIncrement(xIncrement);

        int yRange = axisConfiguration.getyUpperBound() - axisConfiguration.getyLowerBound();
        int yValDiff = DataDiffer.getValDiff(yRange, axisConfiguration.getTotalYLength());

        int totalY = getTotalTicks(yRange, yValDiff);
        int yIncrement = getIncrement(heigth, totalY);

        axisConfiguration.setyValDiff(yValDiff);
        axisConfiguration.setyIncrement(yIncrement);

        int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5) - 2;
        g.setFont(new Font("Arial", Font.PLAIN, 11));

        for (int i = 0; i <= totalX; i++) {
            int x = Constants.MARGIN + xIncrement * i;
            int y = heigth - Constants.MARGIN + 14;
            int val = xValDiff * i + axisConfiguration.getxLowerBound();
            this.g.drawString(Integer.toString(val), x + extraSpace, y);
        }

        for (int i = 0; i <= (totalY); i++) {
            int y = heigth - Constants.MARGIN - yIncrement * i;
            int val = yValDiff * i + axisConfiguration.getyLowerBound();
            int x = Constants.MARGIN - (String.valueOf(val).length() * 8);
            this.g.drawString(Integer.toString(val), x, y - extraSpace);
        }
    }

    private void barLayout() {
        g.setFont(new Font("Arial", Font.PLAIN, 11));
        if (!GraphData.isX()) {
            int totalX = axisConfiguration.getBarLabelLen();
            int xIncrement = getIncrement(width, totalX * 2);

            int indx = 0;
            for (Map.Entry<String, Integer> set : GraphData.getMap().entrySet()) {
                int x = Constants.MARGIN + (xIncrement * (indx * 2 + 1));
                int y = heigth - Constants.MARGIN + 20;
                this.g.drawString(set.getKey(), x, y);
                indx += 1;
            }

            axisConfiguration.setxIncrement(xIncrement);

            int yRange = axisConfiguration.getyUpperBound() - axisConfiguration.getyLowerBound();
            int yValDiff = DataDiffer.getValDiff(
                    yRange,
                    axisConfiguration.getTotalYLength());
            int totalY = getTotalTicks(yRange, yValDiff);
            int yIncrement = getIncrement(this.heigth, totalY);

            axisConfiguration.setyValDiff(yValDiff);
            axisConfiguration.setxValDiff(yValDiff);
            axisConfiguration.setyIncrement(yIncrement);

            int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

            for (int i = 0; i <= totalY; i++) {
                int y = heigth - Constants.MARGIN - yIncrement * i;
                int val = yValDiff * i + axisConfiguration.getyLowerBound();
                int x = Constants.MARGIN - (String.valueOf(val).length() * 9);
                this.g.drawString(Integer.toString(val), x, y - extraSpace);
            }
        } else {
            int totalY = axisConfiguration.getBarLabelLen();
            int yIncrement = getIncrement(heigth, totalY * 2);

            int indx = 0;
            for (Map.Entry<String, Integer> set : GraphData.getMap().entrySet()) {
                String val = set.getKey();
                int x = Constants.MARGIN - (String.valueOf(val).length() * 9);
                int y = this.heigth - Constants.MARGIN - yIncrement * (indx * 2 + 1);
                this.g.drawString(val, x, y);
                indx += 1;
            }

            axisConfiguration.setyIncrement(yIncrement);

            int xRange = axisConfiguration.getxUpperBound() - axisConfiguration.getxLowerBound();
            int xValDiff = DataDiffer.getValDiff(
                    xRange,
                    axisConfiguration.getTotalXLength());
            int totalX = getTotalTicks(xRange, xValDiff);
            int xIncrement = getIncrement(this.width, totalX);

            axisConfiguration.setyValDiff(xValDiff);
            axisConfiguration.setxValDiff(xValDiff);
            axisConfiguration.setxIncrement(xIncrement);

            int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

            for (int i = 0; i <= totalX; i++) {
                int x = Constants.MARGIN + xIncrement * i;
                int y = heigth - Constants.MARGIN + 14;
                int val = xValDiff * i + axisConfiguration.getxLowerBound();
                this.g.drawString(Integer.toString(val), x + extraSpace, y);
            }
        }
    }

    protected int getIncrement(int width, int total) {
        return (width - Constants.MARGIN * 2) / (total + 1);
    }

    protected int getTotalTicks(int range, int valDiff) {
        return (range % valDiff) == 0 ? (range / valDiff) : (range / valDiff) + 1;
    }

}

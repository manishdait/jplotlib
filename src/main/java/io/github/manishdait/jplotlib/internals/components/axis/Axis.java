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

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import io.github.manishdait.jplotlib.internals.util.AxisType;

/**
 * The Axis class is responsible for building and rendering the axis components
 * for Jplotlib charts.
 * 
 * This class calls the functions of Border and Coordinate class, which provides
 * the functionality for drawing and labeling the X-axis and Y-axis. The Axis
 * further enhances
 * this functionality by adding a grid for non-pie charts.
 * 
 * The Axis is not intended for direct instantiation, as it is used internally
 * by Jplotlib to render the axis components.
 * 
 *
 */
public class Axis {

    private Graphics2D g;
    private JPanel context;
    private Config axisConfiguration;

    /**
     * Constructs a new Axis object with the specified Graphics, JPanel
     * context, and AxisConfiguration.
     *
     * @param g
     *            the Graphics object used for drawing the axis
     *            components.
     * @param context
     *            the JPanel context within which the axis components
     *            will be
     *            drawn.
     * @param axisConfiguration
     *            the Configuration for rendering axis.
     */
    public Axis(Graphics g, JPanel context, Config axisConfiguration) {
        this.g = (Graphics2D) g;
        this.context = context;
        this.axisConfiguration = axisConfiguration;
    }

    /**
     * Builds and renders the axis components, including the border, coordinate and
     * grid (if applicable) for non-pie charts.
     */
    public void drawAxis() {
        if (axisConfiguration.getAxisType() != AxisType.PIE) {
            new Border(g, context).drawBorder();
            new Coordinate(g, context, axisConfiguration).drawCoordinates();
            new Grid(g, context, axisConfiguration).buildGrid();
        } else {
            axisConfiguration.setyLabel("");
            axisConfiguration.setxLabel("");
        }
    }

}

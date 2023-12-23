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

import io.github.manishdait.jplotlib.internals.util.AxisType;

/**
 * Configuration class for defining axis properties in a chart.
 */
public class Config {

    private AxisType axisType;
    private String title = "";
    private String xLabel = "";
    private String yLabel = "";

    private int xIncrement;
    private int yIncrement;

    private int xUpperBound = 0;
    private int yUpperBound = 0;

    private int xLowerBound = Integer.MAX_VALUE;
    private int yLowerBound = Integer.MAX_VALUE;

    private int xValDiff;
    private int yValDiff;

    private int maxXLength = 0;
    private int maxYLength = 0;

    private int totalXLength = 0;
    private int totalYLength = 0;

    private int barLabelLen = 0;

    private boolean xGrid;
    private boolean yGrid;

    public AxisType getAxisType() {
        return axisType;
    }

    public void setAxisType(AxisType axisType) {
        this.axisType = axisType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getxLabel() {
        return xLabel;
    }

    public void setxLabel(String xLabel) {
        this.xLabel = xLabel;
    }

    public String getyLabel() {
        return yLabel;
    }

    public void setyLabel(String yLabel) {
        this.yLabel = yLabel;
    }

    public int getxIncrement() {
        return xIncrement;
    }

    public void setxIncrement(int xIncrement) {
        this.xIncrement = xIncrement;
    }

    public int getyIncrement() {
        return yIncrement;
    }

    public void setyIncrement(int yIncrement) {
        this.yIncrement = yIncrement;
    }

    public int getxUpperBound() {
        return xUpperBound;

    }

    public void setxUpperBound(int xUpperBound) {
        this.xUpperBound = xUpperBound;
    }

    public int getyUpperBound() {
        return yUpperBound;
    }

    public void setyUpperBound(int yUpperBound) {
        this.yUpperBound = yUpperBound;
    }

    public int getxLowerBound() {
        return xLowerBound;
    }

    public void setxLowerBound(int xLowerBound) {
        this.xLowerBound = xLowerBound;
    }

    public int getyLowerBound() {
        return yLowerBound;
    }

    public void setyLowerBound(int yLowerBound) {
        this.yLowerBound = yLowerBound;
    }

    public int getMaxXLength() {
        return maxXLength;
    }

    public void setMaxXLength(int maxXLength) {
        this.maxXLength = maxXLength;
    }

    public int getMaxYLength() {
        return maxYLength;
    }

    public void setMaxYLength(int maxYLength) {
        this.maxYLength = maxYLength;
    }

    public int getTotalXLength() {
        return totalXLength;
    }

    public void setTotalXLength(int totalXLength) {
        this.totalXLength = totalXLength;
    }

    public int getTotalYLength() {
        return totalYLength;
    }

    public void setTotalYLength(int totalYLength) {
        this.totalYLength = totalYLength;
    }

    public int getxValDiff() {
        return xValDiff;
    }

    public void setxValDiff(int xValDiff) {
        this.xValDiff = xValDiff;
    }

    public int getyValDiff() {
        return yValDiff;
    }

    public void setyValDiff(int yValDiff) {
        this.yValDiff = yValDiff;
    }

    public int getBarLabelLen() {
        return barLabelLen;
    }

    public void setBarLabelLen(int barLabelsLen) {
        this.barLabelLen = barLabelsLen;
    }

    public boolean isxGrid() {
        return xGrid;
    }

    public void setxGrid(boolean xGrid) {
        this.xGrid = xGrid;
    }

    public boolean isyGrid() {
        return yGrid;
    }

    public void setyGrid(boolean yGrid) {
        this.yGrid = yGrid;
    }

}

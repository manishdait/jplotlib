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

import io.github.manishdait.jplotlib.defaults.marker.Marker;

/**
 * The ScatterChartStyle class defines the visual style properties for rendering
 * a scatter chart.
 * 
 */
public class ScatterChartStyle {
    private Color color;
    private int[] scale;
    private Marker marker;
    private float alpha;

    /**
     * Constructs a ScatterChartStyle with default style settings.
     */
    public ScatterChartStyle() {
        this.color = null;
        this.scale = null;
        this.marker = Marker.NONE;
        this.alpha = 1F;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public int[] getScale() {
        return scale;
    }

    public void setScale(int[] scale) {
        this.scale = scale;
    }
}

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

package io.github.manishdait.jplotlib.data;

import java.util.LinkedHashMap;
import java.util.Map;

import io.github.manishdait.jplotlib.data.util.Data;

/**
 * The GraphData class implements the Data interface and represents data for a
 * graph. It contains labels and data points for plotting graphs.
 * 
 */
public class GraphData implements Data {
    private String[] labels;
    private double[] data;
    private static boolean isX;
    private static LinkedHashMap<String, Integer> map;
    private static int indx;

    /**
     * Static block to initialize the LinkedHashMap and index.
     */
    static {
        map = new LinkedHashMap<>();
        indx = 0;
    }

    /**
     * Constructs a GraphData object with the given labels and data points.
     *
     * @param labels
     *            The array containing labels for the data points.
     * @param data
     *            The array containing the data points.
     */
    public GraphData(String[] labels, double[] data) {
        this.labels = labels;
        this.data = data;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public static boolean isX() {
        return isX;
    }

    public static void setX(boolean isX) {
        GraphData.isX = isX;
    }

    public static Map<String, Integer> getMap() {
        return map;
    }

    public static void setMap(Map<String, Integer> map) {
        GraphData.map = (LinkedHashMap<String, Integer>) map;
    }

    public static int getIndx() {
        return indx;
    }

    public static void setIndx(int indx) {
        GraphData.indx = indx;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

}

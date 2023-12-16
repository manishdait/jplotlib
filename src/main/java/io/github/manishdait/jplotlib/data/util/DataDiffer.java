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

package io.github.manishdait.jplotlib.data.util;

/**
 * The DataDiff class provides utility methods to calculate data differences.
 *
 */
public class DataDiffer {

    private DataDiffer() {
    }

    static final int MAX_TICKS = 24;

    /**
     * Calculate the value difference based on the given range and totalLength of
     * data.
     *
     * @param range
     *            the difference between Upper and Lower bound.
     * @param totalLength
     *            The total length of the data.
     * @return The value difference.
     */
    public static int getValDiff(double range, int totalLength) {
        int valDiff = (int) range / totalLength;

        if (totalLength > 24) {
            valDiff = (int) range / MAX_TICKS;
        }

        if (range % totalLength != 0) {
            valDiff = valDiff + 1;
        }
        return valDiff;
    }

}

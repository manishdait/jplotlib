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

package io.github.manishdait.jplotlib.internals.components.label;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * The AxisLabel class represents a label used for axis titles in Jplotlib
 * charts.
 * 
 * This class extends the JLabel class and provides additional functionality
 * specific to axis labels, such as centering the text and setting a default
 * font.
 * 
 * The AxisLabel is not intended for direct instantiation, as it is used
 * internally by Jplotlib to create axis labels.
 *
 */
public class AxisLabel extends JLabel {

    /**
     * Constructs a new AxisLabel with default settings.
     */
    public AxisLabel() {
        super();
        super.setHorizontalAlignment(CENTER);
        super.setFont(new Font("Arial", Font.BOLD, 12));
    }

}

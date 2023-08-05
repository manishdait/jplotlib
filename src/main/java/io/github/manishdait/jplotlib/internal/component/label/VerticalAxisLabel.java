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

package io.github.manishdait.jplotlib.internal.component.label;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * The VerticalAxisLabel class represents a label used for vertical axis titles 
 * in Jplotlib charts.
 * 
 * This class extends the AxisLabel class and provides additional functionality
 * to display the text vertically.The text is rotated by 90 degrees
 * counterclockwise to achieve the vertical orientation.
 * 
 * The VerticalAxisLabel is not intended for direct instantiation, as it is used
 * internally by Jplotlib to create vertical axis labels.
 * 
 * 
 */

public class VerticalAxisLabel extends AxisLabel {

  /**
   * Constructs a new VerticalAxisLabel with default settings.
   */
  public VerticalAxisLabel() {
    super();
    super.setHorizontalAlignment(CENTER);
    super.setVerticalAlignment(TOP);
  }
        
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    int labelWidth = getWidth();
    int labelHeight = getHeight();
    int centerX = labelWidth / 2;
    int centerY = labelHeight / 2;

    g2d.translate(centerX, centerY);

    g2d.rotate(Math.toRadians(-90));

    FontMetrics fm = g2d.getFontMetrics();
    int textWidth = fm.stringWidth(getText());
    int textHeight = fm.getHeight();
    g2d.drawString(getText(), -textWidth / 2, textHeight / 4);

    g2d.dispose();

  }

}

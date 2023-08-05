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

package io.github.manishdait.jplotlib.ui;

import java.util.List;

import javax.swing.JFrame;

import io.github.manishdait.jplotlib.data.SeriesData;
import io.github.manishdait.jplotlib.data.StyleData;
import io.github.manishdait.jplotlib.internal.util.Constants;


/**
 * The BaseFrame class represents a custom JFrame that serves as the base window 
 * for displaying Jplotlib charts.
 * 
 * This class extends the standard JFrame class and is used to create a window 
 * that contains a ChartPanel for rendering the Jplotlib charts. It provides a 
 * customizable interface for displaying various types of plots and data 
 * visualizations.
 * 
 * The BaseFrame is created with a specific SeriesData and a List of StyleData, 
 * which define the data and styles for the charts to be displayed in the frame.
 * 
 * 
 */

public class BaseFrame extends JFrame {

  private ChartPanel chartPanel;

  /**
   * Constructs a new BaseFrame with the specified SeriesData and List of 
   * StyleData.
   *
   * @param seriesData the SeriesData containing the data points for the charts.
   * @param styleData the List of StyleData containing style information for the 
   * charts.
   */

  public BaseFrame(SeriesData seriesData, List<StyleData> styleData) {
    this.setTitle(Constants.PROVIDER);
    this.setSize(Constants.WIDTH, Constants.HEIGTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.chartPanel = new ChartPanel(seriesData, styleData);
    this.chartPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
    this.add(this.chartPanel);
  }

}

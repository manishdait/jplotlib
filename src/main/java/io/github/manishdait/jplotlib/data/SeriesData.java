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

import java.util.List;

import io.github.manishdait.jplotlib.internal.util.AxisType;


/**
 * The SeriesData class represents the data for a series plot in Jplotlib.
 *
 */

public class SeriesData {

  public AxisType axisType;
  private String title = "";
  private String xLabel = "";
  private String yLabel = "";

  private int xIncrement;
  private int yIncrement;

  private int xUpperBound;
  private int yUpperBound;

  private int xLowerBound;
  private int yLowerBound;

  private int xValDiff;
  private int yValDiff;

  private boolean xGrid;
  private boolean yGrid;

  private String[] label;

  private List<Coordinates> coordinates;

  private double[] pieData;

  /**
   * Default constructor for Coordinates.
   */
  public SeriesData() {}


  /**
   * Get the axis type of the series data.
   *
   * @return The axis type.
   */
  public AxisType getAxisType() {
    return axisType;
  }

  /**
   * Set the axis type of the series data.
   *
   * @param axisType The axis type.
   */
  public void setAxisType(AxisType axisType) {
    this.axisType = axisType;
  }

  /**
   * Get the title of the series data.
   *
   * @return The title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the series data.
   *
   * @param title The axis title.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Get the xLabel of the series data.
   *
   * @return The xLabel.
   */
  public String getxLabel() {
    return xLabel;
  }

  /**
   * Set the xLabel of the series data.
   *
   * @param xLabel The axis xLabel.
   */
  public void setxLabel(String xLabel) {
    this.xLabel = xLabel;
  }

  /**
   * Get the yLabel of the series data.
   *
   * @return The yLabel.
   */
  public String getyLabel() {
    return yLabel;
  }

  /**
   * Set the yLabel of the series data.
   *
   * @param yLabel The axis yLabel.
   */
  public void setyLabel(String yLabel) {
    this.yLabel = yLabel;
  }

  /**
   * Get the xIncrement value of the series data.
   *
   * @return The xIncrement.
   */
  public int getxIncrement() {
    return xIncrement;
  }

  /**
   * Set the xIncrement value of the series data.
   *
   * @param xIncrement The axis xIncrement.
   */
  public void setxIncrement(int xIncrement) {
    this.xIncrement = xIncrement;
  }

  /**
   * Get the yIncrement value of the series data.
   *
   * @return The yIncrement.
   */
  public int getyIncrement() {
    return yIncrement;
  }

  /**
   * Set the yIncrement value of the series data.
   *
   * @param yIncrement The axis yIncrement.
   */
  public void setyIncrement(int yIncrement) {
    this.yIncrement = yIncrement;
  }

  /**
   * Get the UpperBound value of xAxis.
   *
   * @return The xUpperBound.
   */
  public int getxUpperBound() {
    return xUpperBound;
  }

  /**
   * Set the UpperBound value of the xAxis.
   *
   * @param xUpperBound The xAxis UpperBound.
   */
  public void setxUpperBound(int xUpperBound) {
    this.xUpperBound = xUpperBound;
  }

  /**
   * Get the UpperBound value of yAxis.
   *
   * @return The yUpperBound.
   */
  public int getyUpperBound() {
    return yUpperBound;
  }

  /**
   * Set the UpperBound value of the yAxis.
   *
   * @param yUpperBound The yAxis UpperBound.
   */
  public void setyUpperBound(int yUpperBound) {
    this.yUpperBound = yUpperBound;
  }

  /**
   * Get the LowerBound value of xAxis.
   *
   * @return The xLowerBound.
   */
  public int getxLowerBound() {
    return xLowerBound;
  }

  /**
   * Set the LowerBound value of the xAxis.
   *
   * @param xLowerBound The xAxis LowerBound.
   */
  public void setxLowerBound(int xLowerBound) {
    this.xLowerBound = xLowerBound;
  }

  /**
   * Get the LowerBound value of yAxis.
   *
   * @return The yLowerBound.
   */
  public int getyLowerBound() {
    return yLowerBound;
  }

  /**
   * Set the LowerBound value of the yAxis.
   *
   * @param yLowerBound The yAxis LowerBound.
   */
  public void setyLowerBound(int yLowerBound) {
    this.yLowerBound = yLowerBound;
  }


  /**
   * Get the ValDiff value of xAxis.
   *
   * @return The xValDiff.
   */
  public int getxValDiff() {
    return xValDiff;
  }

  /**
   * Set the xValDiff of the series data.
   *
   * @param xValDiff The xAxis ValDiff.
   */
  public void setxValDiff(int xValDiff) {
    this.xValDiff = xValDiff;
  }

  /**
   * Get the ValDiff value of yAxis.
   *
   * @return The yValDiff.
   */  
  public int getyValDiff() {
    return yValDiff;
  }

  /**
   * Set the yValDiff of the series data.
   *
   * @param yValDiff The yAxis ValDiff.
   */
  public void setyValDiff(int yValDiff) {
    this.yValDiff = yValDiff;
  }

  /**
   * Get the isGrid value of xAxis.
   *
   * @return The xGrid.
   */
  public boolean isxGrid() {
    return xGrid;
  }

  /**
   * Set the xGrid of the series data.
   *
   * @param xGrid The axis Grid.
   */
  public void setxGrid(boolean xGrid) {
    this.xGrid = xGrid;
  }

  /**
   * Get the isGrid value of yAxis.
   *
   * @return The yGrid.
   */
  public boolean isyGrid() {
    return yGrid;
  }

  /**
   * Set the yGrid of the series data.
   *
   * @param yGrid The axis Grid.
   */
  public void setyGrid(boolean yGrid) {
    this.yGrid = yGrid;
  }
  

  /**
   * Get the list of coordinates for the series plot.
   *
   * @return The list of coordinates.
   */  
  public List<Coordinates> getCoordinates() {
    return this.coordinates;
  }

  /**
   * Set the list of coordinates for the series plot.
   *
   * @param coordinates The list of coordinates.
   */
  public void setCoordinates(List<Coordinates> coordinates) {
    this.coordinates = coordinates;
  }
  
  /**
   * Get the array of labels for the series plot.
   *
   * @return The array of labels.
   */
  public String[] getLabel() {
    return label;
  }

  /**
   * Set the array of labels for the series plot (Bar Graph).
   *
   * @param label The array of labels.
   */
  public void setLabel(String[] label) {
    this.label = label;
  }

  /**
   * Get the data for the pie chart.
   *
   * @return The data for the pie chart.
   */ 
  public double[] getPieData() {
    return pieData;
  }

  /**
   * Set the data for the pie chart.
   *
   * @param pieData The data for the pie chart.
   */
  public void setPieData(double[] pieData) {
    this.pieData = pieData;
  }

}

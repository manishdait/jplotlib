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

import java.util.ArrayList;
import java.util.List;

import io.github.manishdait.jplotlib.data.Coordinates;

/**
 * The PreProcessor class provides utility methods for preprocessing data before
 * plotting.
 *
 */

public class PreProcessor {

  /**
   * Default Constuctor for PreProcessor.
   */
  public PreProcessor () {}

  /**
   * Process the x-coordinates from the given list of coordinates.
   *
   * @param coordinates The list of coordinates.
   * @return The processed x-coordinates as an array of double.
   */
  public double[] processX(List<Coordinates> coordinates) {
    List<Double> xPoints = new ArrayList<Double>();

    for(int i = 0; i < coordinates.size(); i++) {
      for(int j = 0; j < coordinates.get(i).getxPoints().length; j++) {
        xPoints.add(coordinates.get(i).getxPoints()[j]);  
      }
    }

    return transform(xPoints);
  }

  /**
   * Process the y-coordinates from the given list of coordinates.
   *
   * @param coordinates The list of coordinates.
   * @return The processed y-coordinates as an array of double.
   */
  public double[] processY(List<Coordinates> coordinates) {
    List<Double> yPoints = new ArrayList<Double>();

    for(int i = 0; i < coordinates.size(); i++) {
      for(int j = 0; j < coordinates.get(i).getyPoints().length; j++) {
        yPoints.add(coordinates.get(i).getyPoints()[j]);  
      }
    }

    return transform(yPoints);
  }

  /**
   * Convert List<> to double[] array.
   * @param points List of points.
   * @return array
   */
  private double[] transform(List<Double> points) {
    double[] data = new double[points.size()];

    for(int i = 0; i < points.size(); i++) {
      data[i] = points.get(i);
    }

    return data;
  }

  /**
   * Get the maximum length of x-coordinates from the given list of coordinates.
   *
   * @param coordinates The list of coordinates.
   * @return The maximum length of x-coordinates.
   */
  public int getMaxLengthX(List<Coordinates> coordinates) {
    int len  = 0;
    
    for(int i = 0; i < coordinates.size(); i++) {
      if(len < coordinates.get(i).getxPoints().length) {
        len = coordinates.get(i).getxPoints().length;
      }
    }

    return len;
  }

  /**
   * Get the maximum length of y-coordinates from the given list of coordinates.
   *
   * @param coordinates The list of coordinates.
   * @return The maximum length of y-coordinates.
   */
  public int getMaxLengthY(List<Coordinates> coordinates) {
    int len  = 0;
    
    for(int i = 0; i < coordinates.size(); i++) {
      if(len < coordinates.get(i).getyPoints().length) {
        len = coordinates.get(i).getyPoints().length;
      }
    }

    return len;
  }

  /**
   * Get the upper bound of values from the given array of points.
   *
   * @param points The array of points.
   * @return The upper bound value.
   */
  public int getUpperBound(double[] points) {
    int max = 1;
    for(int i = 0; i < points.length; i++) {
      if(points[i] > max) {
        max = (int) points[i];
      }
    }

    return max;
  }

  /**
   * Get the lower bound of values from the given array of points.
   *
   * @param points The array of points.
   * @return The lower bound value.
   */
  public int getLowerBound(double[] points) {
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < points.length; i++) {
      if(min > points[i]) {
        min = (int) points[i];
      }
    }
    return min;
  }

}

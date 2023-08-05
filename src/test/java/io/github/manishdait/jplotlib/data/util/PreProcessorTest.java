package io.github.manishdait.jplotlib.data.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.github.manishdait.jplotlib.data.Coordinates;

public class PreProcessorTest {
    
  private double[] arr1 = {1, 2, 3, 4};
  private double[] arr2 = {10, 20, 30, 40, 50};
  List<Coordinates> list = new ArrayList<Coordinates>();

  @Test
  public void textProcessX() {
    Coordinates coordinates1 = new Coordinates();
    coordinates1.setxPoints(arr1);

    Coordinates coordinates2 = new Coordinates();
    coordinates2.setxPoints(arr2);

    list.add(coordinates1);
    list.add(coordinates2);

    double[] expected = {1, 2, 3, 4, 10, 20, 30, 40, 50};

    assertArrayEquals(expected, new PreProcessor().processX(list), 0);
  }

  @Test
  public void textProcessY() {
    Coordinates coordinates1 = new Coordinates();
    coordinates1.setyPoints(arr2);

    Coordinates coordinates2 = new Coordinates();
    coordinates2.setyPoints(arr1);

    list.add(coordinates1);
    list.add(coordinates2);

    double[] expected = {10, 20, 30, 40, 50, 1, 2, 3, 4};

    assertArrayEquals(expected, new PreProcessor().processY(list), 0);
  }

  @Test
  public void testGetMaxLengthX() {
    Coordinates coordinates1 = new Coordinates();
    coordinates1.setxPoints(arr1);

    Coordinates coordinates2 = new Coordinates();
    coordinates2.setxPoints(arr2);

    list.add(coordinates1);
    list.add(coordinates2);

    int expected = 5;

    assertEquals(expected, new PreProcessor().getMaxLengthX(list));
  }

  @Test
  public void testGetMaxLengthY() {
    Coordinates coordinates1 = new Coordinates();
    coordinates1.setyPoints(arr2);

    Coordinates coordinates2 = new Coordinates();
    coordinates2.setyPoints(arr1);

    list.add(coordinates1);
    list.add(coordinates2);

    int expected = 5;

    assertEquals(expected, new PreProcessor().getMaxLengthY(list));
  }

  @Test
  public void testGetUpperBound() {
    int expected = 50;
    assertEquals(expected, new PreProcessor().getUpperBound(arr2));
  }

  @Test
  public void testGetLowerBound() {
    int expected = 10;
    assertEquals(expected, new PreProcessor().getLowerBound(arr2));
  }

}

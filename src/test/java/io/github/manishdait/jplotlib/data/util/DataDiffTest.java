package io.github.manishdait.jplotlib.data.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataDiffTest {
    
  @Test
  public void testGetValDiff1() {
    double arr[] = {1, 2, 3, 4, 5};
    int expected = 1;
    assertEquals(expected, DataDiff.getValDiff(arr, arr.length));
  }

  @Test
  public void testGetValDiff2() {
    double arr[] = {1, 2, 3, 4, 20};
    int expected = 4;
    assertEquals(expected, DataDiff.getValDiff(arr, arr.length));
  }

  @Test
  public void testGetValDiff3() {
    double arr[] = {0, 0, 0, 0, 0, 0};
    int expected = 1;
    assertEquals(expected, DataDiff.getValDiff(arr, arr.length));
  }

}

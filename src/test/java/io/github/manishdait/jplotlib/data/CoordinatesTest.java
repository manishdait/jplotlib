package io.github.manishdait.jplotlib.data;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CoordinatesTest {

  private double[] testX = {1, 2, 3, 4, 5};
  private double[] testY = {20, 40, 60, 80, 100};

  @Test
  public void testGetXPoints() {
    Coordinates coordinates = new Coordinates();
    coordinates.setxPoints(testX);

    assertArrayEquals(testX, coordinates.getxPoints(), 0);
  }

  @Test
  public void testGetYPoints() {
    Coordinates coordinates = new Coordinates();
    coordinates.setyPoints(testY);

    assertArrayEquals(testY, coordinates.getyPoints(), 0);
  }

}

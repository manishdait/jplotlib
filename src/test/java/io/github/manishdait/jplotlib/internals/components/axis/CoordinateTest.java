package io.github.manishdait.jplotlib.internals.components.axis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.manishdait.jplotlib.data.util.DataDiffer;

public class CoordinateTest {
    @Test
    public void shouldReturnTwentyOne() {
        int range = 10;
        int totalLenght = 10;
        int diff = DataDiffer.getValDiff(range, totalLenght);
        assertEquals(10, new Coordinate().getTotalTicks(range, diff));
    }
    
    @Test
    public void shouldReturnTwentyFive() {
        int range = 100;
        int totalLenght = 100;
        int diff = DataDiffer.getValDiff(range, totalLenght);
        assertEquals(25, new Coordinate().getTotalTicks(range, diff));
    }

    @Test
    public void shouldReturnEleven() {
        int width = 358;
        int total = 25;
        assertEquals(6, new Coordinate().getIncrement(width, total));
    }
}

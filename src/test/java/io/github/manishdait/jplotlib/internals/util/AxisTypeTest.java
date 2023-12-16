package io.github.manishdait.jplotlib.internals.util;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class AxisTypeTest {
    
    @Test
    public void shouldReturnProperPriorites() {
        int[] expeccted = {1, 2, 3};
        int[] priorites = {AxisType.PLOT.getPriority(), AxisType.BAR.getPriority(), AxisType.PIE.getPriority()};
        assertArrayEquals(expeccted, priorites);
    }

}

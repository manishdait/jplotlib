package io.github.manishdait.jplotlib.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.manishdait.jplotlib.data.util.DataDiffer;

public class DiffCalTest {
    @Test
    public void shouldReturnOne() {
        int range = 10;
        int totalLength = 10;
        assertEquals(1, DataDiffer.getValDiff(range, totalLength));
    }   
    
    @Test
    public void shouldReturnTen() {
        int range = 100;
        int totalLength = 10;
        assertEquals(10, DataDiffer.getValDiff(range, totalLength));
    }

    @Test
    public void shouldReturnFive() {
        int range = 100;
        int totalLength = 24;
        assertEquals(5, DataDiffer.getValDiff(range, totalLength));
    }
}

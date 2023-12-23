package io.github.manishdait.jplotlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.manishdait.jplotlib.charts.bar.BarGraph;
import io.github.manishdait.jplotlib.charts.line.LineChart;
import io.github.manishdait.jplotlib.charts.pie.PieChart;
import io.github.manishdait.jplotlib.charts.scatter.ScatterChart;

public class JplotlibTest {
    
    @Test
    public void testTitle() {
        Jplotlib jplot = new Jplotlib();
        jplot.title("Test Title");
        assertEquals("Test Title", jplot.axisConfiguration.getTitle());
    }

    @Test
    public void testXLabel() {
        Jplotlib jplot = new Jplotlib();
        jplot.xLabel("X Label Test");
        assertEquals("X Label Test", jplot.axisConfiguration.getxLabel());
    }

    @Test
    public void testYLabel() {
        Jplotlib jplot = new Jplotlib();
        jplot.yLabel("Y Label Test");
        assertEquals("Y Label Test", jplot.axisConfiguration.getyLabel());
    }

    @Test
    public void testGrid() {
        Jplotlib jplot = new Jplotlib();
        jplot.grid();
        assertTrue(jplot.axisConfiguration.isxGrid());
        assertTrue(jplot.axisConfiguration.isyGrid());
    }

    @Test
    public void testGridX() {
        Jplotlib jplot = new Jplotlib();
        jplot.grid(true, false);
        assertTrue(jplot.axisConfiguration.isxGrid());
        assertTrue(!jplot.axisConfiguration.isyGrid());
    }

    @Test
    public void testGridY() {
        Jplotlib jplot = new Jplotlib();
        jplot.grid(false, true);
        assertTrue(!jplot.axisConfiguration.isxGrid());
        assertTrue(jplot.axisConfiguration.isyGrid());
    }

    @Test
    public void testPlot() {
        Jplotlib jplot = new Jplotlib();
        LineChart lineChart = jplot.plot(new double[]{1, 2, 3}, new double[]{4, 5, 6});
        assertNotNull(lineChart);
    }

    @Test
    public void testScatter() {
        Jplotlib jplot = new Jplotlib();
        ScatterChart scatterChart = jplot.scatter(new double[]{1, 2, 3}, new double[]{4, 5, 6});
        assertNotNull(scatterChart);
    }

    @Test
    public void testBar() {
        Jplotlib jplot = new Jplotlib();
        BarGraph barGraph = jplot.bar(new String[]{"A", "B", "C"}, new double[]{10, 20, 30});
        assertNotNull(barGraph);
    }

    @Test
    public void testPie() {
        Jplotlib jplot = new Jplotlib();
        PieChart pieChart = jplot.pie(new double[]{10, 20, 30});
        assertNotNull(pieChart);
    }
}

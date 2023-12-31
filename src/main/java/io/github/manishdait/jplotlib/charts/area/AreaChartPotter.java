package io.github.manishdait.jplotlib.charts.area;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import io.github.manishdait.jplotlib.charts.helper.Plotter;
import io.github.manishdait.jplotlib.data.CartesianData;
import io.github.manishdait.jplotlib.defaults.color.PlotColor;
import io.github.manishdait.jplotlib.internals.components.axis.Config;

public class AreaChartPotter implements Plotter {

    private Graphics2D g;
    private JPanel context;
    private Config axisConfiguration;
    private AreaChart areaGraph;
    private int indx;
    
    private int yValDiff;
    private int xValDiff;

    private int xIncrement;
    private int yIncrement;

    private int xLowerBound;
    private int yLowerBound;
    private double[] xPoints;
    private double[] yPoints;

    private int heigth;

    public AreaChartPotter(Graphics g,
            JPanel context,
            Config axisConfiguration,
            AreaChart areaGraph,
            int indx) {
        this.g = (Graphics2D) g;
        this.context = context;
        this.axisConfiguration = axisConfiguration;
        this.areaGraph = areaGraph;
        this.indx = indx;
        this.heigth = context.getHeight();

        this.yValDiff = axisConfiguration.getyValDiff();
        this.xValDiff = axisConfiguration.getxValDiff();

        this.xIncrement = axisConfiguration.getxIncrement();
        this.yIncrement = axisConfiguration.getyIncrement();

        this.xLowerBound = axisConfiguration.getxLowerBound();
        this.yLowerBound = axisConfiguration.getyLowerBound();
    }

    @Override
    public void draw() {
        xPoints = ((CartesianData) areaGraph.getData()).getxPoints();
        yPoints = ((CartesianData) areaGraph.getData()).getyPoints();

        int[] xTemp = new  int[xPoints.length + 2];
        int[] yTemp = new int[yPoints.length + 2];

        this.g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int extraSpace = (int) (Math.min(xIncrement, yIncrement) * 0.5);

        for (int i = 0; i < xPoints.length; i++) {
            xTemp[i+1] = ((int)(xIncrement * (xPoints[i] - xLowerBound)) / xValDiff) + extraSpace;
        }

        for (int i = 0; i < xPoints.length; i++) {
            yTemp[i+1] = (heigth - (int)(yIncrement * (yPoints[i] - yLowerBound)) / yValDiff) - extraSpace;
        }

        xTemp[0] = ((int)(xIncrement * (xPoints[0] - xLowerBound)) / xValDiff) + extraSpace;
        yTemp[0] = (heigth - (yIncrement * (0 - yLowerBound)) / yValDiff) - extraSpace;

        xTemp[xTemp.length - 1] = ((int)(xIncrement * (xPoints[xPoints.length - 1] - xLowerBound)) / xValDiff) + extraSpace;
        yTemp[yTemp.length - 1] = (heigth - (yIncrement * (0 - yLowerBound)) / yValDiff) - extraSpace;
        Color color = PlotColor.getColor(indx);
        g.setColor(color);
        g.fillPolygon(xTemp, yTemp, xTemp.length);

    }

}

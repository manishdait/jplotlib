package io.github.manishdait.jplotlib.charts.area;

import io.github.manishdait.jplotlib.charts.helper.Graph;
import io.github.manishdait.jplotlib.data.util.Data;
import io.github.manishdait.jplotlib.internals.util.ChartType;

public class AreaChart implements Graph {
    private Data data;
    private AreaChartStyle style;
    private static final ChartType CHART_TYPE = ChartType.AREA;

    public AreaChart(Data data) {
        this.data = data;
        this.style = new AreaChartStyle();
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public AreaChartStyle getStyle() {
        return style;
    }

    public void setStyle(AreaChartStyle style) {
        this.style = style;
    }

    public static ChartType getChartType() {
        return CHART_TYPE;
    }

}

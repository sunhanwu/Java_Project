package ucas.java.sunhanwu.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class CreateBar {
    private Hashtable<String, Integer> statistic;

    // constructor
    public CreateBar(Hashtable<String, Integer> data)
    {
        this.statistic = data;
    }

    public ChartPanel createBarPanel()
    {
        DefaultCategoryDataset mDataset = (DefaultCategoryDataset) getDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "域名分布柱状图",
                "地区",
                "数量",
                mDataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        BarRenderer barrenderer = new BarRenderer();
//        barrenderer.setMaximumBarWidth(0.1);
        barrenderer.setMinimumBarLength(0.1);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRenderer(barrenderer);
        ChartPanel panel = new ChartPanel(chart);
        return panel;

    }

    public CategoryDataset getDataset()
    {
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        for(String key: this.statistic.keySet())
        {
            mDataset.addValue(this.statistic.get(key), key, key);
        }
        return mDataset;
    }
}

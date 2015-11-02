// Plotter.java - user interface for charting assignment
// Author: Chris Wilcox
// Date:   4/6/2015
// Class:  CS160
// Email:  wilcox@cs.colostate.edu

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

// Pie charts, bar charts, and line graphs
public class Plotter extends ApplicationFrame {

    // Serialization identifier
    private static final long serialVersionUID = 1L;

    // Set a theme using shadow generator
    {
        ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow", true));
    }

    // Chart information
    String chartTitle;
    String[] chartLabels;
    double[] chartData0;
    double[] chartData1;
    double[] chartData2;
 
    // Constructor
    private Plotter(String name) {
            super(name);
            chartTitle = name;
    }

    public static void main(String[] args) {
            
            // Instantiate student code
            P9 student = new P9();
            
            // Student reads file
            student.readFile(args[0]);

            // Draw pie chart
            String pieTitle = student.getTitle(Interface.eType.PIECHART);
            Plotter pieChart = new Plotter(pieTitle);
            pieChart.chartLabels = student.getLabels(Interface.eType.PIECHART);
            pieChart.chartData0 = student.getData(Interface.eType.PIECHART, 0);
            pieChart.drawGraph(Interface.eType.PIECHART);

            // Draw bar chart
            String barTitle = student.getTitle(Interface.eType.BARCHART);
            Plotter barChart = new Plotter(barTitle);
            barChart.chartLabels = student.getLabels(Interface.eType.BARCHART);
            barChart.chartData0 = student.getData(Interface.eType.BARCHART, 0);
            barChart.chartData1 = student.getData(Interface.eType.BARCHART, 1);
            barChart.drawGraph(Interface.eType.BARCHART);

            // Draw line graph
            String lineTitle = student.getTitle(Interface.eType.LINEGRAPH);
            Plotter lineGraph = new Plotter(lineTitle);
            lineGraph.chartLabels = student.getLabels(Interface.eType.LINEGRAPH);
            lineGraph.chartData0 = student.getData(Interface.eType.LINEGRAPH, 0);
            lineGraph.chartData1 = student.getData(Interface.eType.LINEGRAPH, 1);
            lineGraph.chartData2 = student.getData(Interface.eType.LINEGRAPH, 2);
            lineGraph.drawGraph(Interface.eType.LINEGRAPH);
    }
    
    public void drawGraph(Interface.eType type)
    {
        JFreeChart chart;
        
        switch (type)
        {
            case PIECHART:
                chart = createPieChart();
                break;
            case BARCHART:
                chart = createBarChart();
                break;
            case LINEGRAPH:
                default:
                chart = createLineGraph();
        }
        
        // add the chart to a panel...
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        setContentPane(chartPanel);
        pack();
        RefineryUtilities.positionFrameRandomly(this);
        setVisible(true);
    }

    // Create pie chart
    private JFreeChart createPieChart()
    {
        // Fill in data set
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < chartLabels.length; i++)
                dataset.setValue(chartLabels[i], chartData0[i]);

        JFreeChart chart = ChartFactory.createPieChart(chartTitle,
            dataset,            // data
            false,              // no legend
            true,               // tooltips
            false               // url generation
        );

        // Set a custom background
        chart.setBackgroundPaint(new GradientPaint(new Point(0, 0), 
            new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));

        // Customize the title position and font
        TextTitle title = chart.getTitle();
        title.setHorizontalAlignment(HorizontalAlignment.LEFT);
        title.setPaint(new Color(240, 240, 240));
        title.setFont(new Font("Arial", Font.BOLD, 26));

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(null);
        plot.setOutlineVisible(false);
        plot.setBaseSectionOutlinePaint(Color.WHITE);
        plot.setSectionOutlinesVisible(true);
        plot.setBaseSectionOutlineStroke(new BasicStroke(2.0f));

        // Customize the section label appearance
        plot.setLabelFont(new Font("Courier New", Font.BOLD, 20));
        plot.setLabelLinkPaint(Color.WHITE);
        plot.setLabelLinkStroke(new BasicStroke(2.0f));
        plot.setLabelOutlineStroke(null);
        plot.setLabelPaint(Color.WHITE);
        plot.setLabelBackgroundPaint(null);
        
        return chart;
    }
    
    // Create bar chart
    private JFreeChart createBarChart()
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 3; i++) // series
        {
            for (int j = 0; j < chartData0.length; j++) // data
            {
                String series = "Series " + i;
                String type   = "Type " + j;
                if (i == 0)
                        dataset.addValue(chartData0[j], series, type);
                else if (i == 1)
                        dataset.addValue(chartData1[j], series, type);
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(chartTitle,
                "Category",                 // domain axis label
                "Score (%)",                // range axis label
                dataset,                    // data
                PlotOrientation.HORIZONTAL, // orientation
                true,                       // include legend
                true,                       // tooltips
                false                       // url generation
            );

        // Set the background color for the chart...
        chart.setBackgroundPaint(Color.lightGray);

        // Get a reference to the plot
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
            
        // Change the tick unit selection to integer units only
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0.0, 100.0);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            
        return chart;
    }

    // Create line graph
    private JFreeChart createLineGraph()
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 3; i++) // series
        {
            for (int j = 0; j < chartData0.length; j++) // data
            {
                String series = "Series " + i;
                String type   = "Type " + j;
                if (i == 0)
                        dataset.addValue(chartData0[j], series, type);
                else if (i == 1)
                        dataset.addValue(chartData1[j], series, type);
                else if (i == 2)
                        dataset.addValue(chartData2[j], series, type);
      
            }
        }
    
        // create the chart...
        final JFreeChart chart = ChartFactory.createLineChart(chartTitle,
            "Type",                    // domain axis label
            "Value",                   // range axis label
            dataset,                   // data
            PlotOrientation.VERTICAL,  // orientation
            true,                      // include legend
            true,                      // tooltips
            false                      // url generation
        );

        // Chart customization
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);

        // Customize the range axis
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        // Customize the renderer
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesStroke(
            0, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            1, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            2, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {2.0f, 6.0f}, 0.0f
            )
        );
         
        return chart;
    }
}

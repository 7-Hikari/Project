package komponen;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PenjualanChartPanel extends JPanel {

    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private ChartPanel chartPanel;
    private JFreeChart chart;

    private Color chartBackgroundColor = Color.WHITE;
    private Color barColor = new Color(70, 130, 180); // SteelBlue
    private Color gridColor = Color.LIGHT_GRAY;

    public PenjualanChartPanel() {
        setLayout(new BorderLayout());

        chart = createChart();
        chartPanel = new ChartPanel(chart);
        applyChartStyle();

        add(chartPanel, BorderLayout.CENTER);
    }

    public void setData(List<String> xLabels, List<Number> yValues) {
        dataset.clear();
        for (int i = 0; i < xLabels.size() && i < yValues.size(); i++) {
            dataset.addValue(yValues.get(i), "Penjualan", xLabels.get(i));
        }
    }

    private JFreeChart createChart() {
        return ChartFactory.createBarChart(
                "Grafik Penjualan Bulanan",
                "Bulan",
                "Jumlah",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );
    }

    private void applyChartStyle() {
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(chartBackgroundColor);
        plot.setRangeGridlinePaint(gridColor);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, barColor);
        renderer.setBarPainter(new StandardBarPainter()); // Flat look
        renderer.setShadowVisible(false);
    }

    public void setBarColor(Color color) {
        this.barColor = color;
        applyChartStyle();  // update chart
        repaint();
    }

    public void setChartBackgroundColor(Color color) {
        this.chartBackgroundColor = color;
        applyChartStyle();
        repaint();
    }

    public void setGridColor(Color color) {
        this.gridColor = color;
        applyChartStyle();
        repaint();
    }

    public Color getBarColor() {
        return barColor;
    }

    public Color getChartBackgroundColor() {
        return chartBackgroundColor;
    }

    public Color getGridColor() {
        return gridColor;
    }
}

package komponen;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PenjualanChartPanel extends JPanel {

    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private ChartPanel chartPanel;
    private JFreeChart chart;

    private Color chartBackgroundColor = Color.WHITE;
    private Color lineColor = Color.BLUE;
    private Color gridColor = Color.LIGHT_GRAY;

    public PenjualanChartPanel() {
        setLayout(new BorderLayout());

        chart = createChart();
        chartPanel = new ChartPanel(chart);
        applyChartStyle();

        add(chartPanel, BorderLayout.CENTER);
    }

    // Method baru untuk menerima data otomatis
    public void setData(List<String> xLabels, List<Number> yValues) {
        dataset.clear();
        for (int i = 0; i < xLabels.size() && i < yValues.size(); i++) {
            dataset.addValue(yValues.get(i), "Penjualan", xLabels.get(i));
        }
    }

    private JFreeChart createChart() {
        return ChartFactory.createLineChart(
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

        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, lineColor);
    }
}

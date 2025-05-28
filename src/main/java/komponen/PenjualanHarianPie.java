package komponen;

import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class PenjualanHarianPie extends JPanel {

    private DefaultPieDataset dataset = new DefaultPieDataset();
    private ChartPanel chartPanel;
    private JFreeChart chart;

    private Color chartBackgroundColor = Color.WHITE;
    private String title = "Grafik Penjualan Pie";

    public PenjualanHarianPie() {
        setLayout(new BorderLayout());

        chart = createChart();
        chartPanel = new ChartPanel(chart);
        applyChartStyle();

        add(chartPanel, BorderLayout.CENTER);
    }

//    public void setData(List<String> labels, List<Number> values) {
//        dataset.clear();
//        for (int i = 0; i < labels.size() && i < values.size(); i++) {
//            dataset.setValue(labels.get(i), values.get(i));
//        }
//        applyChartStyle();  // supaya warna baru diterapkan sesuai data baru
//        repaint();
//    }
    public void setData(List<String> labels, List<Number> values) {
        dataset.clear();
        for (int i = 0; i < labels.size() && i < values.size(); i++) {
            String jam = labels.get(i);
            Number jumlah = values.get(i);
            String label = "Jam " + jam + " (" + jumlah + ")";
            dataset.setValue(label, jumlah);
        }
        applyChartStyle();
        repaint();
    }

    private JFreeChart createChart() {
        return ChartFactory.createPieChart(
                title,
                dataset,
                true, // legend
                true, // tooltips
                false // urls
        );
    }

    private void applyChartStyle() {
        chart.setBackgroundPaint(chartBackgroundColor);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(chartBackgroundColor);
        plot.setOutlineVisible(false);

        // Berikan warna berbeda untuk tiap data (random atau preset)
        Random rand = new Random();
        for (Object keyObj : dataset.getKeys()) {
            if (keyObj instanceof Comparable) {
                Comparable key = (Comparable) keyObj;

                // Random warna cerah
                Color color = new Color(
                        100 + rand.nextInt(156),
                        100 + rand.nextInt(156),
                        100 + rand.nextInt(156)
                );
                plot.setSectionPaint(key, color);
            }
        }
        plot.setLabelBackgroundPaint(new Color(255, 255, 255, 200));
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
    }

    // Title setter/getter
    public void setTitle(String title) {
        this.title = title;
        chart.setTitle(title);
        repaint();
    }

    public String getTitle() {
        return title;
    }

    // Chart background color setter/getter
    public void setChartBackgroundColor(Color color) {
        this.chartBackgroundColor = color;
        applyChartStyle();
        repaint();
    }

    public Color getChartBackgroundColor() {
        return chartBackgroundColor;
    }

    // Note: tidak ada setter/getter untuk warna data karena sesuai permintaan
}

package komponen;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.util.HashMap;
import java.util.Map;

public class Tabel_c extends JTable {

    private int selectedRow = -1;
    private Color headerBackgroundColor = new Color(0, 102, 0);
    private Font headerFont = new Font("Tw Cen MT", Font.BOLD, 14);
    private Font cellFont = new Font("Tw Cen MT", Font.PLAIN, 12);
    private final Map<Class<?>, Integer> alignmentMap = new HashMap<>();

    public Tabel_c() {
        setRowHeight(20);
        setGridColor(Color.BLACK);
        setShowHorizontalLines(true);
        setShowVerticalLines(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setBorder(new LineBorder(Color.BLACK, 1));

        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setPreferredSize(new Dimension(0, 40));
        getTableHeader().setDefaultRenderer(new HeaderRenderer());

        setDefaultRenderer(Object.class, new CellRenderer());
        setDefaultRenderer(Number.class, new CellRenderer());

        // Default alignment semua di tengah
        alignmentMap.put(Object.class, JLabel.CENTER);
        alignmentMap.put(String.class, JLabel.CENTER);
        alignmentMap.put(Integer.class, JLabel.CENTER);
        alignmentMap.put(Double.class, JLabel.CENTER);
        alignmentMap.put(Float.class, JLabel.CENTER);
        alignmentMap.put(Short.class, JLabel.CENTER);
        alignmentMap.put(Long.class, JLabel.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = getSelectedRow();
                selectedRow = (row == selectedRow) ? -1 : row;
                if (selectedRow == -1) clearSelection();
            }
        });
    }

    public void setHeaderBackgroundColor(Color color) {
        this.headerBackgroundColor = color;
        getTableHeader().repaint();
    }

    public void setHeaderFont(Font font) {
        this.headerFont = font;
        getTableHeader().repaint();
    }

    public void setCellFont(Font font) {
        this.cellFont = font;
        repaint();
    }

    public void setAlignment(Class<?> type, int alignment) {
        alignmentMap.put(type, alignment);
        repaint();
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    private class HeaderRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel label = new JLabel(value.toString(), JLabel.CENTER);
            label.setOpaque(true);
            label.setBackground(headerBackgroundColor);
            label.setForeground(Color.WHITE);
            label.setFont(headerFont);
            label.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

            return label;
        }
    }

    private class CellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel label = new JLabel(value != null ? value.toString() : "");
            label.setOpaque(true);
            label.setBackground(isSelected ? new Color(204, 204, 204) : Color.WHITE);
            label.setForeground(isSelected ? new Color(15, 89, 140) : new Color(60, 60, 60));
            label.setFont(cellFont);
            label.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

            Class<?> columnClass = table.getColumnClass(column);
            int align = alignmentMap.getOrDefault(columnClass, JLabel.CENTER);
            label.setHorizontalAlignment(align);

            return label;
        }
    }
}

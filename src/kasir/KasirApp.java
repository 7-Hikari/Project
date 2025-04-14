package kasir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KasirApp extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JPanel productPanel;
    private JLabel totalLabel;
    private double totalHarga = 0;

    public KasirApp() {
        setTitle("Program Kasir");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel Daftar Pesanan
        model = new DefaultTableModel(new Object[]{"Item", "Qty", "Total"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.WEST);
        
        // Panel Produk
        productPanel = new JPanel(new GridLayout(3, 3));
        add(productPanel, BorderLayout.CENTER);
        
        // Label Total
        totalLabel = new JLabel("Total: Rp 0");
        add(totalLabel, BorderLayout.SOUTH);
        
        // Tambah Produk Dummy
        addProduct("Chicken Wings", 32000);
        addProduct("Chicken Stick", 20000);
        addProduct("Chicken Popcorn", 23000);
        addProduct("Dino Nugget", 12000);
        addProduct("Chocolate Frappuccino", 39000);
    }
    
    private void addProduct(String name, double price) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{name, "1x", price});
                totalHarga += price;
                totalLabel.setText("Total: Rp " + totalHarga);
            }
        });
        productPanel.add(button);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KasirApp().setVisible(true));
    }
}


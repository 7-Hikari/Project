package Login;

import DAO.userData;
import DAO.userObjek;
import DataMaster.Dashboard;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
//@author Muhammad Zaiful
public class Akun extends javax.swing.JFrame {

    private byte [] foto;
    private userData UD;
    private boolean editfoto = false;
    private String val;
    private Dashboard db;
    
    public Akun() {
        initComponents();
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));
    }
    
    public void setAkun(Dashboard db, userData UD){
        this.UD = UD;
        this.db = db;
        Header.setText("Selamat Datang "+UD.getUsername());
        user.setText(UD.getUsername());
        pass.setEnabled(false);
        confirmPass.setEnabled(false);
        foto = UD.getFoto();
        if (foto != null && foto.length > 0) {
            ImageIcon ikon = new ImageIcon(foto);
            Image img = ikon.getImage().getScaledInstance(120, 115, Image.SCALE_SMOOTH);
            jLabelGambar.setIcon(new ImageIcon(img));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new komponen.PanelRound();
        panelBulat1 = new komponen.PanelBulat();
        jLabelGambar = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        Header = new javax.swing.JLabel();
        getPhoto = new javax.swing.JButton();
        Simpan = new javax.swing.JButton();
        labelNama1 = new javax.swing.JLabel();
        labelNama2 = new javax.swing.JLabel();
        confirmPass = new javax.swing.JPasswordField();
        pass = new javax.swing.JPasswordField();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBulat1.setLingkar(110);
        panelBulat1.setLayout(new java.awt.BorderLayout());
        panelBulat1.add(jLabelGambar, java.awt.BorderLayout.CENTER);

        panelRound1.add(panelBulat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 30, 121, 114));

        user.setEditable(false);
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelRound1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 184, 250, -1));

        Header.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        Header.setForeground(new java.awt.Color(0, 0, 0));
        Header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Header.setText("jLabel1");
        panelRound1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, -1));

        getPhoto.setBackground(new java.awt.Color(51, 204, 255));
        getPhoto.setForeground(new java.awt.Color(0, 0, 0));
        getPhoto.setText("Pilih foto");
        getPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getPhotoActionPerformed(evt);
            }
        });
        panelRound1.add(getPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 150, -1, 19));

        Simpan.setBackground(new java.awt.Color(0, 153, 255));
        Simpan.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        Simpan.setForeground(new java.awt.Color(0, 0, 0));
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });
        panelRound1.add(Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 340, -1, -1));

        labelNama1.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        labelNama1.setForeground(new java.awt.Color(0, 0, 0));
        labelNama1.setText("Password");
        panelRound1.add(labelNama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 230, -1, -1));

        labelNama2.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        labelNama2.setForeground(new java.awt.Color(0, 0, 0));
        labelNama2.setText("Konfirmasi Password");
        panelRound1.add(labelNama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 280, -1, -1));

        confirmPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confirmPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmPassMouseClicked(evt);
            }
        });
        panelRound1.add(confirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 300, 250, -1));

        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });
        panelRound1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 245, 250, -1));

        close.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        close.setForeground(new java.awt.Color(0, 0, 0));
        close.setText("X");
        close.setContentAreaFilled(false);
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        panelRound1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 0, 38, 20));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getPhotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Gambar (JPG, PNG, JPEG)", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(this); // ganti null ke this biar modal
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                if (selectedFile.length() > 1_048_576) { // > 1MB
                    JOptionPane.showMessageDialog(this, "Ukuran foto terlalu besar! Maksimal 1MB.");
                    return;
                }
                foto = bacaFileKeByteArray(selectedFile);
                ImageIcon icon = new ImageIcon(foto);
                Image img = icon.getImage().getScaledInstance(120, 115, Image.SCALE_SMOOTH);
                jLabelGambar.setIcon(new ImageIcon(img));
                jLabelGambar.setText(null);
                editfoto = true;
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal membaca file gambar!");
            }
        }
    }//GEN-LAST:event_getPhotoActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        if (foto == null) {
            foto = loadDefaultFoto();
        }
        if (!pass.isEnabled() && editfoto){
            UD.setProfil(foto);
            UD.setAccount(user.getText(), pass.getText());
            userObjek.updateFoto(UD);
        } else if (pass.isEnabled()){
            if(!pass.getText().isEmpty() && pass.getText().equals(confirmPass.getText())){
            UD.setAccount(user.getText(), pass.getText());
            userObjek.updatePengguna(UD);
            } else {
                JOptionPane.showMessageDialog(this, "Isi password dan samakan dengan konfirmasi password");
                return;
            }
        }
        
        db.setData(UD);
        this.dispose();
    }//GEN-LAST:event_SimpanActionPerformed

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        if(!pass.isEnabled())cekValidasi();
    }//GEN-LAST:event_passMouseClicked

    private void confirmPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPassMouseClicked
        if(!confirmPass.isEnabled())cekValidasi();
    }//GEN-LAST:event_confirmPassMouseClicked

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        dispose();
    }//GEN-LAST:event_closeActionPerformed
    
    void cekValidasi(){
        val = JOptionPane.showInputDialog(this, "Masukkan nama sahabat pertamamu");
        if (val != null) {
            UD = userObjek.Forgot(user.getText(), val);
            if (UD != null) {
                pass.setEnabled(true);
                confirmPass.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Tolong jangan ganti password orang lain ya!",
                        "Validasi salah!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private byte[] loadDefaultFoto() {
    try (InputStream in = getClass().getResourceAsStream("/Add User.png");
         ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

        byte[] temp = new byte[4096];
        int len;
        while ((len = in.read(temp)) != -1) {
            buffer.write(temp, 0, len);
        }

        return buffer.toByteArray();
    } catch (IOException | NullPointerException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Foto default gagal dimuat.");
        return null;
    }
}
    
    private byte[] bacaFileKeByteArray(File file) throws IOException {
        try (InputStream is = new FileInputStream(file);
             ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Akun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Header;
    private javax.swing.JButton Simpan;
    private javax.swing.JButton close;
    private javax.swing.JPasswordField confirmPass;
    private javax.swing.JButton getPhoto;
    private javax.swing.JLabel jLabelGambar;
    private javax.swing.JLabel labelNama1;
    private javax.swing.JLabel labelNama2;
    private komponen.PanelBulat panelBulat1;
    private komponen.PanelRound panelRound1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TarifJFrame extends javax.swing.JFrame {

    public TarifJFrame() {
        initComponents();
        loadTarifler();
        loadKategoriler();
    }

    
    // Tarifleri yükleyip JTable'a ekler
    public void loadTarifler() {
        ResultSet rs = DbHelper.getTarifler();  // Veritabanından tarifleri getir
        DefaultTableModel tableModel = (DefaultTableModel) tarifTable.getModel();
        tableModel.setRowCount(0);  // Tabloyu sıfırla

        try {
            while (rs != null && rs.next()) {
                String tarifID = rs.getString("KategoriAdi");
                String tarifAdi = rs.getString("TarifAdi");
                int hazirlamaSuresi = rs.getInt("HazirlamaSuresi");
                double maliyet = rs.getDouble("Maliyet");
                // Maliyeti formatla: noktadan sonra iki basamak göster
                String formattedMaliyet = String.format("%.2f", maliyet);

                tableModel.addRow(new Object[]{tarifID, tarifAdi, hazirlamaSuresi, formattedMaliyet});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // ComboBox'a malzemeleri ekler
    private void loadKategoriler() {
        try {
            ResultSet rs = DbHelper.getKategoriler();
            kategori_comboBox.removeAllItems();  // ComboBox'ı temizle
            while (rs.next()) {
                kategori_comboBox.addItem(rs.getString("KategoriAdi"));  // Kategorileri ekle
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String getTarifAdi() {
        return txt_tarifadi.getText();
    }

    public String getKategori() {
        return (String) kategori_comboBox.getSelectedItem();
    }

    public String getSure() {
        return txt_sure.getText();
    }

    public String getTalimatlar() {
        return txt_talimat.getText();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tarifTable = new javax.swing.JTable();
        buton_ekle = new javax.swing.JButton();
        buton_guncelle = new javax.swing.JButton();
        buton_sil = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_talimat = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_tarifadi = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_sure = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kategori_comboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tarifTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kategori", "Tarif Adı", "Hazırlama Süresi", "Maliyeti"
            }
        ));
        tarifTable.setShowGrid(true);
        jScrollPane1.setViewportView(tarifTable);

        buton_ekle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buton_ekle.setText("Tarif Ekle");
        buton_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_ekleActionPerformed(evt);
            }
        });

        buton_guncelle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buton_guncelle.setText("Tarif Güncelle");
        buton_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_guncelleActionPerformed(evt);
            }
        });

        buton_sil.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buton_sil.setText("Tarif Sil");
        buton_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_silActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txt_talimat);

        jScrollPane4.setViewportView(txt_tarifadi);

        jScrollPane5.setViewportView(txt_sure);

        jLabel1.setText("Tarif Adı");

        jLabel2.setText("Kategori");

        jLabel3.setText("Hazırlama Süresi");

        jLabel4.setText("Talimatları");

        kategori_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buton_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buton_guncelle))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buton_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(kategori_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buton_sil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kategori_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buton_guncelle)
                            .addComponent(buton_ekle))))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buton_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_ekleActionPerformed
        // Gerekli alanlardan bilgileri al
        String tarifAdi = txt_tarifadi.getText();
        String kategoriAdi = (String) kategori_comboBox.getSelectedItem();
        String sureStr = txt_sure.getText();
        String talimatlar = txt_talimat.getText();

        // Boş alanların kontrolü
        if (tarifAdi.isEmpty() || kategoriAdi.isEmpty() || sureStr.isEmpty() || talimatlar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tarif adının zaten mevcut olup olmadığını kontrol et
        if (DbHelper.isTarifAdiMevcut(tarifAdi)) {
            JOptionPane.showMessageDialog(this, "Aynı tarif adıyla tarif mevcut.", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Hazırlama süresini kontrol et (Pozitif sayı mı?)
            int sure = Integer.parseInt(sureStr);
            if (sure <= 0) {
                throw new NumberFormatException();
            }

            // Tüm alanlar doluysa yeni pencereyi aç
            MalzemeJDialog malzemeJDialog = new MalzemeJDialog(this, true, this);  // Dialog modal (odaklı) olarak açılır
            malzemeJDialog.setVisible(true);

            // Alanları temizle
            txt_tarifadi.setText("");
            txt_sure.setText("");
            txt_talimat.setText("");

        } catch (NumberFormatException e) {
            // Geçersiz tarif süresi girdisi
            JOptionPane.showMessageDialog(this, "Geçerli tarif süresi girilmemiştir.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buton_ekleActionPerformed

    private void buton_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_guncelleActionPerformed
        // Gerekli alanlardan bilgileri al
        String tarifAdi = txt_tarifadi.getText();
        String kategoriAdi = (String) kategori_comboBox.getSelectedItem();
        String sureStr = txt_sure.getText();
        String talimatlar = txt_talimat.getText();

        // Boş alanların kontrolü
        if (tarifAdi.isEmpty() || kategoriAdi.isEmpty() || sureStr.isEmpty() || talimatlar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Tarif adının zaten mevcut olup olmadığını kontrol et
        if (!DbHelper.isTarifAdiMevcut(tarifAdi)) {
            JOptionPane.showMessageDialog(this, "Aynı tarif adıyla tarif mevcut değil.", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Hazırlama süresini kontrol et (Pozitif sayı mı?)
            int sure = Integer.parseInt(sureStr);
            if (sure <= 0) {
                throw new NumberFormatException();
            }

            // Tüm alanlar doluysa yeni pencereyi aç
            MalzemeJDialog malzemeJDialog = new MalzemeJDialog(this, true, this);  // Dialog modal (odaklı) olarak açılır
            malzemeJDialog.setVisible(true);

            // Alanları temizle
            txt_tarifadi.setText("");
            txt_sure.setText("");
            txt_talimat.setText("");

        } catch (NumberFormatException e) {
            // Geçersiz tarif süresi girdisi
            JOptionPane.showMessageDialog(this, "Geçerli tarif süresi girilmemiştir.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buton_guncelleActionPerformed

    private void buton_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_silActionPerformed
        // Tarif adı boş mu diye kontrol et
        if (txt_tarifadi.getText().isEmpty()) {
            // Eğer tarif adı boşsa uyarı mesajı göster
            JOptionPane.showMessageDialog(this, "Lütfen silmek için bir tarif adı girin!", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            // Tarif adı girilmişse silme işlemi gerçekleştirilir
            JOptionPane.showMessageDialog(this, "Tarif Silme gerçekleştirilecek.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buton_silActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TarifJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarifJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarifJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarifJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TarifJFrame tarifFrame = new TarifJFrame();
                tarifFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_ekle;
    private javax.swing.JButton buton_guncelle;
    private javax.swing.JButton buton_sil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JComboBox<String> kategori_comboBox;
    private javax.swing.JTable tarifTable;
    private javax.swing.JTextPane txt_sure;
    private javax.swing.JTextPane txt_talimat;
    private javax.swing.JTextPane txt_tarifadi;
    // End of variables declaration//GEN-END:variables

}

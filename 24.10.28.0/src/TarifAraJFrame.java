
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TarifAraJFrame extends javax.swing.JFrame {


    public TarifAraJFrame() {
        initComponents();
        loadMalzemeler();
        loadTarifAdi(); // Yemekleri yükle metodu çağrılıyor
        loadKategoriler();
        filtreleYemekleri("");
    }

    // Veritabanından malzemeleri ComboBox'a yükleme
    private void loadMalzemeler() {
        try {
            ResultSet rs = DbHelper.getMalzemeler();
            malzeme_sec.removeAllItems();  // ComboBox'ı temizle
            malzeme_sec.addItem("");
            while (rs.next()) {
                malzeme_sec.addItem(rs.getString("MalzemeAdi"));  // Malzemeleri ekle
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTarifAdi() {
        try {
            ResultSet rs = DbHelper.getTarifAdi();
            jPanel1.removeAll();  // JPanel'i temizleyip tarifleri yüklemek için yeniden ekleyeceğiz
            malzeme_sec.addItem("");
            jPanel1.setLayout(new GridLayout(11, 5, 10, 10)); // Sütunlar arası 10 px, satırlar arası 10 px boşluk

            while (rs.next()) {
                String yemekAdi = rs.getString("TarifAdi");
                jPanel1.add(createStyledLabel(yemekAdi));
            }
            // Güncellemeleri uygula
            jPanel1.revalidate();
            jPanel1.repaint();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void loadKategoriler() {
        try {
            ResultSet rs = DbHelper.getKategoriler();
            kategori_box.removeAllItems();  // ComboBox'ı temizle
            kategori_box.addItem("");
            while (rs.next()) {
                kategori_box.addItem(rs.getString("KategoriAdi"));  // Kategorileri ekle
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private JLabel createStyledLabel(String text) {
    JLabel label = new JLabel(text);
    // Tasarım özellikleri
    label.setPreferredSize(new Dimension(120, 60)); // Genişlik ve yükseklik ayarları
    label.setHorizontalAlignment(SwingConstants.CENTER); // Ortalayıcı hizalama
    label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Siyah kenarlık
    label.setOpaque(true); // Arka plan renginin görünür olması için gerekli
    label.setBackground(Color.getHSBColor(21, 43, 71)); // Arka plan rengi
    label.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Yazı tipi
    
    return label;
}

    private void filtreleYemekleri(String searchText) {
        // JPanel içerisindeki tüm bileşenleri al
        java.awt.Component[] components = jPanel1.getComponents();

        // Arama kutusu boşsa tüm yemeklerin görünmesini ve orijinal sıralamaya geri dönmesini sağla
        if (searchText.trim().isEmpty()) {
            // Tüm bileşenleri orijinal sıralamada yeniden ekle
            jPanel1.removeAll();
            for (java.awt.Component component : components) {
                if (component instanceof JLabel) {
                    component.setVisible(true); // Tüm JLabel bileşenlerini görünür yap
                    jPanel1.add(component); // Orijinal sırasıyla yeniden ekle
                }
            }
            jPanel1.revalidate(); // Güncellemeleri uygula
            jPanel1.repaint(); // Paneli yeniden boya
            return; // Fonksiyondan çık
        }

        // Arama metni varsa, geçici olarak eşleşenleri en üste taşı
        java.util.List<JLabel> matchingLabels = new java.util.ArrayList<>();
        java.util.List<JLabel> nonMatchingLabels = new java.util.ArrayList<>();

        // Kullanıcının aradığı metni küçük harf yap (case insensitive arama için)
        String lowerCaseSearchText = searchText.toLowerCase();

        // Tüm JLabel'leri kontrol et
        for (java.awt.Component component : components) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                String labelText = label.getText().toLowerCase(); // JLabel'deki metni küçük harfe çevir

                // Arama metninin yemek adının başında olup olmadığını ve eksiksiz bir akışı kontrol et
                if (labelText.startsWith(lowerCaseSearchText) || labelText.contains(" " + lowerCaseSearchText)) {
                    label.setVisible(true); // Eşleşenleri görünür yap
                    matchingLabels.add(label); // Eşleşenleri listeye ekle
                } else {
                    label.setVisible(false); // Eşleşmeyenleri gizle
                    nonMatchingLabels.add(label); // Eşleşmeyenleri listeye ekle
                }
            }
        }

        // JPanel'i yeniden düzenle, eşleşenleri en üste al
        jPanel1.removeAll();
        for (JLabel label : matchingLabels) {
            jPanel1.add(label);
        }
        for (JLabel label : nonMatchingLabels) {
            jPanel1.add(label);
        }

        // Güncellemeleri uygula
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        malzeme_sec = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        buton_ara = new javax.swing.JButton();
        buton_temizle = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        low_malzeme = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        high_malzeme = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        low_maliyet = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        high_maliyet = new javax.swing.JTextPane();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        kategori_box = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        buton_maliyet = new javax.swing.JButton();
        buton_sure = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        tarif_ara = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        malzeme_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malzeme_secActionPerformed(evt);
            }
        });
        getContentPane().add(malzeme_sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 71, 150, -1));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Malzemeler"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 71, 155, 177));

        jPanel1.setBackground(new java.awt.Color(232, 219, 185));
        jPanel1.setLayout(new java.awt.GridLayout(10, 5, 10, 100));

        jLabel1.setText("jLabel1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);

        jLabel2.setText("jLabel2");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2);

        jLabel3.setText("jLabel3");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3);

        jLabel4.setText("jLabel4");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4);

        jLabel5.setText("jLabel5");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel5);

        jLabel6.setText("jLabel6");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel6);

        jLabel7.setText("jLabel7");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel7);

        jLabel8.setText("jLabel8");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel8);

        jLabel9.setText("jLabel9");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel9);

        jLabel10.setText("jLabel10");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10);

        jLabel11.setText("jLabel11");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel11);

        jLabel12.setText("jLabel12");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel12);

        jLabel13.setText("jLabel13");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel13);

        jLabel14.setText("jLabel14");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel14);

        jLabel15.setText("jLabel15");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel15);

        jLabel16.setText("jLabel16");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel16);

        jLabel17.setText("jLabel17");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel17);

        jLabel18.setText("jLabel18");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel18);

        jLabel19.setText("jLabel19");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel19);

        jLabel20.setText("jLabel20");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel20);

        jLabel21.setText("jLabel21");
        jPanel1.add(jLabel21);

        jLabel22.setText("jLabel22");
        jPanel1.add(jLabel22);

        jLabel23.setText("jLabel23");
        jPanel1.add(jLabel23);

        jLabel24.setText("jLabel24");
        jPanel1.add(jLabel24);

        jLabel25.setText("jLabel25");
        jPanel1.add(jLabel25);

        jLabel26.setText("jLabel26");
        jPanel1.add(jLabel26);

        jLabel27.setText("jLabel27");
        jPanel1.add(jLabel27);

        jLabel28.setText("jLabel28");
        jPanel1.add(jLabel28);

        jLabel29.setText("jLabel29");
        jPanel1.add(jLabel29);

        jLabel30.setText("jLabel30");
        jPanel1.add(jLabel30);

        jLabel31.setText("jLabel31");
        jPanel1.add(jLabel31);

        jLabel32.setText("jLabel32");
        jPanel1.add(jLabel32);

        jLabel33.setText("jLabel33");
        jPanel1.add(jLabel33);

        jLabel34.setText("jLabel34");
        jPanel1.add(jLabel34);

        jLabel35.setText("jLabel35");
        jPanel1.add(jLabel35);

        jLabel36.setText("jLabel36");
        jPanel1.add(jLabel36);

        jLabel37.setText("jLabel37");
        jPanel1.add(jLabel37);

        jLabel38.setText("jLabel38");
        jPanel1.add(jLabel38);

        jLabel39.setText("jLabel39");
        jPanel1.add(jLabel39);

        jLabel40.setText("jLabel40");
        jPanel1.add(jLabel40);

        jLabel41.setText("jLabel41");
        jPanel1.add(jLabel41);

        jLabel42.setText("jLabel42");
        jPanel1.add(jLabel42);

        jLabel43.setText("jLabel43");
        jPanel1.add(jLabel43);

        jLabel44.setText("jLabel44");
        jPanel1.add(jLabel44);

        jLabel45.setText("jLabel45");
        jPanel1.add(jLabel45);

        jLabel46.setText("jLabel46");
        jPanel1.add(jLabel46);

        jLabel47.setText("jLabel47");
        jPanel1.add(jLabel47);

        jLabel48.setText("jLabel48");
        jPanel1.add(jLabel48);

        jLabel49.setText("jLabel49");
        jPanel1.add(jLabel49);

        jLabel50.setText("jLabel50");
        jPanel1.add(jLabel50);

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 277, 740, 414));

        buton_ara.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buton_ara.setText("Ara ");
        buton_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_araActionPerformed(evt);
            }
        });
        getContentPane().add(buton_ara, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 184, 155, -1));

        buton_temizle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buton_temizle.setText("Temizle");
        buton_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_temizleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_temizle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 225, 155, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setText("MALZEMELERE GÖRE ARA");
        getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 33, -1, -1));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setText("Sıralama Seçenekleri");
        getContentPane().add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        jLabel54.setText("Malzeme Sayısı:");
        getContentPane().add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        jLabel55.setText("Maliyet Aralığı:");
        getContentPane().add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setViewportView(low_malzeme);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 40, -1));

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane7.setViewportView(high_malzeme);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 40, -1));

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane8.setViewportView(low_maliyet);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 40, -1));

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane9.setViewportView(high_maliyet);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 40, -1));

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("/");
        getContentPane().add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 10, -1));

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("/");
        getContentPane().add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 10, -1));

        jLabel58.setText("Kategori:");
        getContentPane().add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        kategori_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(kategori_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel59.setText("Filtreleme Seçenekleri");
        getContentPane().add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        buton_maliyet.setText("Maliyet");
        buton_maliyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_maliyetActionPerformed(evt);
            }
        });
        getContentPane().add(buton_maliyet, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 120, -1));

        buton_sure.setText("Hazırlama Süresi");
        buton_sure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_sureActionPerformed(evt);
            }
        });
        getContentPane().add(buton_sure, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 120, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setText("TARİFE GÖRE ARA");
        getContentPane().add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 130, -1));

        tarif_ara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tarif_araKeyReleased(evt);
            }
        });
        getContentPane().add(tarif_ara, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 126, -1));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JFrame2top.jpg"))); // NOI18N
        getContentPane().add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 740, 280));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JFrame2.jpg"))); // NOI18N
        getContentPane().add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 900, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void malzeme_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malzeme_secActionPerformed
        // Seçilen malzemeyi kontrol et, boş değilse tabloya ekle
        String selectedMalzeme = (String) malzeme_sec.getSelectedItem();

        if (selectedMalzeme != null && !selectedMalzeme.isEmpty()) {
            // Seçilen malzemeyi tabloya ekle
            Malzeme_ekleTable(selectedMalzeme);
        }

    }//GEN-LAST:event_malzeme_secActionPerformed

    // Seçilen malzemeyi JTable'a ekle
    private void Malzeme_ekleTable(String malzeme) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{malzeme});
    }


    private void tarif_araKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tarif_araKeyReleased
        // Kullanıcının yazdığı metni al
        String searchText = tarif_ara.getText().toLowerCase();
        filtreleYemekleri(searchText);
    }//GEN-LAST:event_tarif_araKeyReleased


    private void buton_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_araActionPerformed
        // Seçilen malzemelerin ID'lerini al
        java.util.List<Integer> selectedMalzemeIDs = getSelectedMalzemeIDs();

        // Eğer boş liste döndüyse matchingTarifler() fonksiyonunu çalıştırma
        if (!selectedMalzemeIDs.isEmpty()) {
            // Eşleşen tarifleri veritabanından getir ve jPanel'de göster
            matchingTarifler(selectedMalzemeIDs);
        }
        
        filtreleMaliyetAraligindaTarifler();
    }//GEN-LAST:event_buton_araActionPerformed

    private java.util.List<Integer> getSelectedMalzemeIDs() {
        java.util.List<Integer> malzemeIDs = new java.util.ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Eğer tabloda hiç satır yoksa boş liste döndür
        if (model.getRowCount() == 0) {
            System.out.println("Tabloda seçili malzeme bulunamadı.");
            return malzemeIDs;  // Boş liste döndürerek fonksiyondan çık
        }
    
        // JTable'daki her bir satır için
        for (int i = 0; i < model.getRowCount(); i++) {
            // JTable'daki malzeme adını al
            String malzemeAdi = model.getValueAt(i, 0).toString();
            int malzemeID = DbHelper.getMalzemeIDByAdi(malzemeAdi);
            malzemeIDs.add(malzemeID);
        }
        return malzemeIDs;
    }
    
    private void matchingTarifler(java.util.List<Integer> selectedMalzemeIDs) {
        try {
            ResultSet rs = DbHelper.getMatchingTarif(selectedMalzemeIDs);

            // Eşleşme yüzdesini ve tarif adlarını saklayacak bir liste oluştur
            java.util.List<TarifEslestirme> eslestirmeler = new java.util.ArrayList<>();

            // Sonuçları işle
            while (rs.next()) {
                String tarifAdi = rs.getString("TarifAdi");
                int toplamMalzeme = rs.getInt("ToplamMalzeme");
                int eslestirilen = rs.getInt("EslestirilenMalzeme");
                int tarifID = rs.getInt("TarifID");

                // Eşleşme yüzdesini hesapla
                double eslesmeYuzdesi = toplamMalzeme == 0 ? 0 : ((double) eslestirilen / toplamMalzeme) * 100;

                // Eksik malzemelerin maliyetini hesapla
                double eksikMalzemeMaliyeti = DbHelper.hesaplaEksikMalzemeMaliyet(tarifID);

                // Yüzdesi sıfır olanları listeye ekleme
                if (eslesmeYuzdesi > 0) {
                    eslestirmeler.add(new TarifEslestirme(tarifAdi, eslesmeYuzdesi, eksikMalzemeMaliyeti));
                }
            }
            
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // JPanel'i temizle ve yeni sıralanmış tarifleri ekle
            jPanel1.removeAll();
            eslestirmeler.sort((a, b) -> Double.compare(b.getEslesmeYuzdesi(), a.getEslesmeYuzdesi())); // Yüzdeye göre sıralama

            for (TarifEslestirme eslestirme : eslestirmeler) {
                String tarifBilgisi = eslestirme.getTarifAdi() + " - %" + String.format("%.2f", eslestirme.getEslesmeYuzdesi());

                // Eksik malzeme maliyeti ekle
                if (eslestirme.getEslesmeYuzdesi() < 100) {
                    tarifBilgisi += " (Eksik malzeme maliyeti: " + String.format("%.2f", eslestirme.getEksikMalzemeMaliyeti()) + " TL)";
                }

                JLabel label = createStyledLabel(tarifBilgisi);

                // Renk belirleme: Yeşil yeterli, kırmızı eksik
                if (eslestirme.getEksikMalzemeMaliyeti() == 0) {
                    label.setBackground(java.awt.Color.GREEN);
                    label.setOpaque(true);
                } else {
                    label.setBackground(java.awt.Color.RED);
                    label.setOpaque(true);
                }

                jPanel1.add(label);
            }

            // Güncellemeleri uygula
            jPanel1.revalidate();
            jPanel1.repaint();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    private void buton_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_temizleActionPerformed

        // JTable'ı temizle
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Tüm satırları kaldır

        // JPanel'i temizle
        jPanel1.removeAll();

        loadTarifAdi();

        // Güncellemeleri uygula
        jPanel1.revalidate();
        //jPanel1.repaint();
    }//GEN-LAST:event_buton_temizleActionPerformed

    private void buton_maliyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_maliyetActionPerformed
        sortByMaliyet();
    }//GEN-LAST:event_buton_maliyetActionPerformed

    private void sortByMaliyet() {
        // JPanel içindeki tüm JLabel bileşenleri listeye ekle
        java.util.List<JLabel> labelList = new java.util.ArrayList<>();
        for (java.awt.Component component : jPanel1.getComponents()) {
            if (component instanceof JLabel) {
                labelList.add((JLabel) component);
            }
        }

        // JLabel bileşenlerini tarif maliyetlerine göre sırala
        labelList.sort((label1, label2) -> {
            String tarifAdi1 = label1.getText().split(" - ")[0].trim();
            String tarifAdi2 = label2.getText().split(" - ")[0].trim();

            double maliyet1 = DbHelper.getTarifMaliyeti(tarifAdi1);
            double maliyet2 = DbHelper.getTarifMaliyeti(tarifAdi2);

            return Double.compare(maliyet1, maliyet2);
        });

        // Sıralanmış JLabel bileşenlerini jPanel1'e yeniden ekle
        jPanel1.removeAll();
        
        for (JLabel label : labelList) {
            if (label.isVisible()) {
                    jPanel1.add(label);
                }
        }

        // Güncellemeleri uygula
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private void buton_sureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_sureActionPerformed
        sortBySure();
    }//GEN-LAST:event_buton_sureActionPerformed

    private void sortBySure() {
        // JPanel içindeki tüm JLabel bileşenleri listeye ekle
        java.util.List<JLabel> labelList = new java.util.ArrayList<>();
        for (java.awt.Component component : jPanel1.getComponents()) {
            if (component instanceof JLabel) {
                labelList.add((JLabel) component);
            }
        }

        // JLabel bileşenlerini hazırlama süresine göre sırala
        labelList.sort((label1, label2) -> {
            String tarifAdi1 = label1.getText().split(" - ")[0].trim();
            String tarifAdi2 = label2.getText().split(" - ")[0].trim();

            int sure1 = DbHelper.getTarifSure(tarifAdi1);
            int sure2 = DbHelper.getTarifSure(tarifAdi2);

            return Integer.compare(sure1, sure2);
        });

        // Sıralanmış JLabel bileşenlerini jPanel1'e yeniden ekle
        jPanel1.removeAll();
        for (JLabel label : labelList) {
            if (label.isVisible()) {
                    jPanel1.add(label);
                }
        }

        // Güncellemeleri uygula
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private void filtreleMaliyetAraligindaTarifler() {
        String lowMaliyet = low_maliyet.getText().trim();
        String highMaliyet = high_maliyet.getText().trim();
        String lowMalzeme = low_malzeme.getText().trim();
        String highMalzeme = high_malzeme.getText().trim();
        
        String kategoriAdi = (String) kategori_box.getSelectedItem();
        int kategoriID = DbHelper.getKategoriIDByAdi(kategoriAdi);

        double lowDouble = lowMaliyet.isEmpty() ? Double.MIN_VALUE : Double.parseDouble(lowMaliyet);
        double highDouble = highMaliyet.isEmpty() ? Double.MAX_VALUE : Double.parseDouble(highMaliyet);
        int lowInt = lowMalzeme.isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(lowMalzeme);
        int highInt = highMalzeme.isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(highMalzeme);

        // Maliyet aralığında ve dışında olanları ayırmak için listeler oluştur
        java.util.List<JLabel> matchingLabels = new java.util.ArrayList<>();
        java.util.List<JLabel> nonMatchingLabels = new java.util.ArrayList<>();

        // jPanel1'deki tüm bileşenleri al
        for (java.awt.Component component : jPanel1.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                String tarifAdi = label.getText().split(" - ")[0].trim();  // Tarif adını almak için böl

                // Tarifin maliyetini veritabanından al
                double tarifMaliyeti = DbHelper.getTarifMaliyeti(tarifAdi);
                int malzemeSayisi = DbHelper.getMalzemeSayisi(tarifAdi);
                int tarifKategoriID = DbHelper.getKategoriIDByTarifAdi(tarifAdi);

                // Maliyet aralığındaysa matchingLabels listesine, değilse nonMatchingLabels listesine ekle
                if ((tarifMaliyeti >= lowDouble && tarifMaliyeti <= highDouble) && (malzemeSayisi >= lowInt && malzemeSayisi <= highInt) && (kategoriID == tarifKategoriID || kategoriID == -1)) {
                    label.setVisible(true);
                    matchingLabels.add(label);
                } else {
                    label.setVisible(false);
                    nonMatchingLabels.add(label);
                }
            }
        }

        // jPanel1'i temizleyip listeleri sırasıyla yeniden ekleyerek düzeni güncelle
        jPanel1.removeAll();
        for (JLabel label : matchingLabels) {
            jPanel1.add(label);
        }
        for (JLabel label : nonMatchingLabels) {
            jPanel1.add(label);
        }

        // Güncellemeleri uygula
        jPanel1.revalidate();
        jPanel1.repaint();
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
            java.util.logging.Logger.getLogger(TarifAraJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarifAraJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarifAraJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarifAraJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarifAraJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_ara;
    private javax.swing.JButton buton_maliyet;
    private javax.swing.JButton buton_sure;
    private javax.swing.JButton buton_temizle;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextPane high_maliyet;
    private javax.swing.JTextPane high_malzeme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> kategori_box;
    private javax.swing.JTextPane low_maliyet;
    private javax.swing.JTextPane low_malzeme;
    private javax.swing.JComboBox<String> malzeme_sec;
    private javax.swing.JTextField tarif_ara;
    // End of variables declaration//GEN-END:variables
}

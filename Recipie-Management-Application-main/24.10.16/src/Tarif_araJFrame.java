import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Tag.SELECT;


public class Tarif_araJFrame extends javax.swing.JFrame {

     private static final String URL = "jdbc:mysql://localhost:3306/tarifdb"; // Veritabanı URL'i
    private static final String USER = "root"; // MySQL kullanıcı adı
    private static final String PASSWORD = "root"; // MySQL şifreniz (eğer varsa)
     private boolean isInitialLoad = true; // İlk yükleme sırasında tabloya veri eklenmemesi için
private boolean isMousePressed = false; // Mouse tıklanıp tıklanmadığını kontrol etmek için

    public Tarif_araJFrame() {
        initComponents();
        isInitialLoad = false; // İlk yükleme tamamlandı
        Malzeme_yukleComboBox();
         yemekleriYukle(); // Yemekleri yükle metodu çağrılıyor
        filtreleYemekleri("");
         
    }

    
    // Veritabanından malzemeleri ComboBox'a yükleme
    private void Malzeme_yukleComboBox() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Malzemeleri alfabetik sıraya göre al
            String query = "SELECT MalzemeAdi FROM malzemeler ORDER BY MalzemeAdi ASC";
            ResultSet resultSet = statement.executeQuery(query);

              // ComboBox'u temizle ve ilk olarak boş bir öğe ekle
        malzeme_sec.removeAllItems();
        malzeme_sec.addItem("");  // Boş bir öğe ekleyerek başlat
        malzeme_sec.setSelectedIndex(0); // İlk öğe (boş) seçili

            // Malzemeleri ComboBox'a ekle
            // Malzemeleri ComboBox'a ekle
            while (resultSet.next()) {
                malzeme_sec.addItem(resultSet.getString("MalzemeAdi"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
   
       

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        malzeme_sec = new javax.swing.JComboBox<>();
        yemek_Ara = new javax.swing.JTextField();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        malzeme_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malzeme_secActionPerformed(evt);
            }
        });

        yemek_Ara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yemek_AraKeyReleased(evt);
            }
        });

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

        jPanel1.setLayout(new java.awt.GridLayout(10, 5, 10, 100));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);

        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);

        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);

        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7);

        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8);

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9);

        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10);

        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11);

        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12);

        jLabel13.setText("jLabel13");
        jPanel1.add(jLabel13);

        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14);

        jLabel15.setText("jLabel15");
        jPanel1.add(jLabel15);

        jLabel16.setText("jLabel16");
        jPanel1.add(jLabel16);

        jLabel17.setText("jLabel17");
        jPanel1.add(jLabel17);

        jLabel18.setText("jLabel18");
        jPanel1.add(jLabel18);

        jLabel19.setText("jLabel19");
        jPanel1.add(jLabel19);

        jLabel20.setText("jLabel20");
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

        jButton1.setText("Ara ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Temizle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(malzeme_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(87, 87, 87)
                        .addComponent(yemek_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1454, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(malzeme_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(yemek_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3571, Short.MAX_VALUE))
        );

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
    
    
    private void yemek_AraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yemek_AraKeyReleased
        // Kullanıcının yazdığı metni al
    String searchText = yemek_Ara.getText().toLowerCase();
    filtreleYemekleri(searchText);
    }//GEN-LAST:event_yemek_AraKeyReleased

    
  
     private java.util.List<Integer> getSelectedMalzemeIDs() {
   java.util.List<Integer> malzemeIDs = new java.util.ArrayList<>();
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         Statement statement = connection.createStatement()) {

        // JTable'daki her bir satır için
        for (int i = 0; i < model.getRowCount(); i++) {
            // JTable'daki malzeme adını al
            String malzemeAdi = model.getValueAt(i, 0).toString();

            // Malzeme ID'sini veritabanından al
            String query = "SELECT MalzemeID FROM malzemeler WHERE MalzemeAdi = '" + malzemeAdi + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                // Bulunan ID'yi listeye ekle
                int malzemeID = resultSet.getInt("MalzemeID");
                malzemeIDs.add(malzemeID);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return malzemeIDs;
}

    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // Seçilen malzemelerin ID'lerini al
    java.util.List<Integer> selectedMalzemeIDs = getSelectedMalzemeIDs();

    // Eşleşen tarifleri veritabanından getir ve jPanel'de göster
    getMatchingTarifler(selectedMalzemeIDs);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        // JTable'ı temizle
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Tüm satırları kaldır

    // JPanel'i temizle
    jPanel1.removeAll();

    yemekleriYukle();

    // Güncellemeleri uygula
    jPanel1.revalidate();
    jPanel1.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
 private void getMatchingTarifler(java.util.List<Integer> selectedMalzemeIDs) {
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         Statement statement = connection.createStatement()) {

        // Malzeme ID'lerini SQL sorgusu için uygun hale getirin (örn. "1, 2, 3" şeklinde)
        String idList = selectedMalzemeIDs.toString().replaceAll("[\\[\\]]", "");

        // SQL Sorgusu: Her tarifin toplam malzemesini, eşleşen malzeme sayısını ve eksik olan malzemeleri alın
        String query = "SELECT t.TarifAdi, " +
                       "(SELECT COUNT(DISTINCT tm1.MalzemeID) FROM tarif_malzeme tm1 WHERE tm1.TarifID = t.TarifID) AS ToplamMalzeme, " +
                       "COUNT(DISTINCT tm2.MalzemeID) AS EslestirilenMalzeme, " +
                       "t.TarifID " +
                       "FROM tarifler t " +
                       "LEFT JOIN tarif_malzeme tm2 ON t.TarifID = tm2.TarifID AND tm2.MalzemeID IN (" + idList + ") " +
                       "GROUP BY t.TarifID";

        ResultSet resultSet = statement.executeQuery(query);

        // Eşleşme yüzdesini ve tarif adlarını saklayacak bir liste oluştur
        java.util.List<TarifEslestirme> eslestirmeler = new java.util.ArrayList<>();

        // Sonuçları işle
        while (resultSet.next()) {
            String tarifAdi = resultSet.getString("TarifAdi");
            int toplamMalzeme = resultSet.getInt("ToplamMalzeme");
            int eslestirilen = resultSet.getInt("EslestirilenMalzeme");
            int tarifID = resultSet.getInt("TarifID");

            // Eşleşme yüzdesini hesapla
            double eslesmeYuzdesi = toplamMalzeme == 0 ? 0 : ((double) eslestirilen / toplamMalzeme) * 100;

            // Eksik malzemelerin maliyetini hesapla
            double eksikMalzemeMaliyeti = hesaplaEksikMalzemeMaliyeti(connection, tarifID, selectedMalzemeIDs);

            // Yüzdesi sıfır olanları listeye ekleme
            if (eslesmeYuzdesi > 0) {
                eslestirmeler.add(new TarifEslestirme(tarifAdi, eslesmeYuzdesi, eksikMalzemeMaliyeti));
            }
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

            JLabel label = new JLabel(tarifBilgisi);

            // Renk belirleme: Yeşil yeterli, kırmızı eksik
            if (eslestirme.getEslesmeYuzdesi() == 100) {
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

private double hesaplaEksikMalzemeMaliyeti(Connection connection, int tarifID, java.util.List<Integer> selectedMalzemeIDs) throws SQLException {
    double toplamMaliyet = 0.0;

    // Eksik malzemeleri ve miktarları bulmak için sorgu
    String eksikMalzemeQuery = "SELECT m.MalzemeAdi, m.BirimFiyat, tm.MalzemeMiktar, m.ToplamMiktar " +
                               "FROM malzemeler m " +
                               "JOIN tarif_malzeme tm ON m.MalzemeID = tm.MalzemeID " +
                               "WHERE tm.TarifID = " + tarifID;

    try (Statement eksikMalzemeStmt = connection.createStatement();
         ResultSet eksikMalzemeRS = eksikMalzemeStmt.executeQuery(eksikMalzemeQuery)) {

        while (eksikMalzemeRS.next()) {
            double birimFiyat = eksikMalzemeRS.getDouble("BirimFiyat");
            double gerekenMiktar = eksikMalzemeRS.getDouble("MalzemeMiktar");
            double mevcutMiktar = eksikMalzemeRS.getDouble("ToplamMiktar");

            // Eksik miktarı hesapla (mevcut miktar yetersizse)
            double eksikMiktar = Math.max(gerekenMiktar - mevcutMiktar, 0);

            // Eksik malzeme varsa, maliyeti hesapla
            if (eksikMiktar > 0) {
                toplamMaliyet += eksikMiktar * birimFiyat;
            }
        }
    }

    return toplamMaliyet;
}

    
    
       
    
   private void yemekleriYukle() {
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         Statement statement = connection.createStatement()) {

        String query = "SELECT TarifAdi FROM tarifler"; // Veritabanındaki yemek isimlerini çekiyoruz
        ResultSet resultSet = statement.executeQuery(query);

        // JPanel'i temizleyip yemekleri yüklemek için yeniden ekleyeceğiz
        jPanel1.removeAll();

        // Veritabanından çekilen verileri dinamik olarak JPanel'e JLabel bileşenleri ekleyerek gösteriyoruz
        while (resultSet.next()) {
            String yemekAdi = resultSet.getString("TarifAdi");
            JLabel label = new JLabel(yemekAdi); // Dinamik olarak JLabel oluşturuyoruz
            jPanel1.add(label); // JLabel'i JPanel'e ekliyoruz
        }

        // Güncellemeleri uygula
        jPanel1.revalidate();
        jPanel1.repaint();

    } catch (SQLException e) {
        e.printStackTrace();
    }
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
            if (labelText.startsWith(lowerCaseSearchText)||labelText.contains(" " + lowerCaseSearchText)) {
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
            java.util.logging.Logger.getLogger(Tarif_araJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tarif_araJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tarif_araJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tarif_araJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tarif_araJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> malzeme_sec;
    private javax.swing.JTextField yemek_Ara;
    // End of variables declaration//GEN-END:variables
}

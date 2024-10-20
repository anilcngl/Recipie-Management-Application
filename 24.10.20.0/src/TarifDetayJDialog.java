
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author anilc
 */
public class TarifDetayJDialog extends javax.swing.JDialog {

    private JLabel lblTarifAdi, lblKategori, lblSure, lblTalimatlar;
    private JTable malzemeTable;
    
    public TarifDetayJDialog(java.awt.Frame parent, String tarifAdi, String kategori, int sure, String talimatlar, Object[][] malzemeler, boolean modal) {
        super(parent, modal);
        //initComponents();
        setTitle("Tarif Detayları");
        setSize(500, 400);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Başlık ve Açıklamalar için Label'lar
        lblTarifAdi = new JLabel("Tarif Adı: " + tarifAdi);
        lblKategori = new JLabel("Kategori: " + kategori);
        lblSure = new JLabel("Hazırlama Süresi: " + sure + " dakika");
        lblTalimatlar = new JLabel("<html><body style='width: 400px'>Talimatlar: " + talimatlar + "</body></html>"); // Uzun metinler için HTML

        // Malzeme Tablosu
        String[] columnNames = {"Malzeme Adı", "Miktar"};
        malzemeTable = new JTable(new DefaultTableModel(malzemeler, columnNames));
        JScrollPane malzemeScrollPane = new JScrollPane(malzemeTable);

        // Layout Ayarları
        setLayout(new BorderLayout());

        // Bilgi Paneli
        JPanel bilgiPanel = new JPanel();
        bilgiPanel.setLayout(new GridLayout(4, 1));
        bilgiPanel.add(lblTarifAdi);
        bilgiPanel.add(lblKategori);
        bilgiPanel.add(lblSure);
        bilgiPanel.add(lblTalimatlar);

        // Panel ve Tabloları Eklemek
        add(bilgiPanel, BorderLayout.NORTH);
        add(malzemeScrollPane, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tarif Detayları");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.table.DefaultTableModel;

public class TarifDetayJDialog extends javax.swing.JDialog {

    private JLabel lblTarifAdi, lblKategori, lblSure, lblTalimatlar, lblFoto;
    private JTable malzemeTable;

    public TarifDetayJDialog(java.awt.Frame parent, String tarifAdi, String kategori, int sure, String talimatlar, Object[][] malzemeler, boolean modal) {
        super(parent, modal);
        setTitle("Tarif Detayları");
        setSize(600, 500);  // Pencere boyutu
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Başlık ve Açıklamalar için Label'lar
        lblTarifAdi = new JLabel("Tarif Adı: " + tarifAdi);
        lblKategori = new JLabel("Kategori: " + kategori);
        lblSure = new JLabel("Hazırlama Süresi: " + sure + " dakika");
        lblTalimatlar = new JLabel("<html><body style='width: 400px'>Talimatlar: " + talimatlar + "</body></html>"); // Uzun metinler için HTML

        // Fotoğraf Label'ı
        lblFoto = new JLabel("Fotoğraf bulunamadı.", JLabel.CENTER);  // Varsayılan mesaj
        lblFoto.setPreferredSize(new Dimension(450, 300));  // Sabit genişlik ve yükseklik ayarı
        loadImage(tarifAdi);  // Fotoğrafı yükle

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

        // Fotoğrafı eklemek için bir panel
        JPanel fotoPanel = new JPanel();
        fotoPanel.add(lblFoto);  // Fotoğrafı panel içine yerleştir

        // Panel ve Tabloları Eklemek
        add(bilgiPanel, BorderLayout.NORTH);
        add(malzemeScrollPane, BorderLayout.CENTER);
        add(fotoPanel, BorderLayout.SOUTH);  // Fotoğraf paneli aşağıda olacak
    }

    private void loadImage(String tarifAdi) {
        // Fotoğraf dosyasını bulma
        String filePath = "src/images/" + tarifAdi + ".jpg";
        File imgFile = new File(filePath);
        if (imgFile.exists()) {
            ImageIcon icon = new ImageIcon(filePath);
            Image img = icon.getImage();
            int newWidth = 450;
            int newHeight = (icon.getIconHeight() * newWidth) / icon.getIconWidth();
            Image resizedImg = img.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            lblFoto.setIcon(resizedIcon);
            lblFoto.setText("");  // Fotoğraf bulunduğunda mesajı kaldır
        } else {
            lblFoto.setText("Fotoğraf bulunamadı.");
        }
    }




    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
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
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

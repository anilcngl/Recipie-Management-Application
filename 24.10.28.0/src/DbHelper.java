
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/tarifdb"; // Veritabanı URL'i
    private static final String USER = "root"; // MySQL kullanıcı adı
    private static final String PASSWORD = "can1234"; // MySQL şifreniz (eğer varsa)

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına başarıyla bağlandı!");
        } catch (SQLException e) {
            System.out.println("Veritabanına bağlanılamadı: " + e.getMessage());
        }
        return connection;
    }

    public static ResultSet getTarifler() {
        ResultSet resultSet = null;
        try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Veritabanına bağlanıldı. Sorgu çalıştırılıyor...");
                Statement statement = connection.createStatement();
                String query = "SELECT Kategoriler.KategoriAdi, Tarifler.TarifAdi, Tarifler.HazirlamaSuresi, "
                        + "(SELECT SUM(Malzemeler.BirimFiyat * Tarif_Malzeme.MalzemeMiktar) "
                        + "FROM Tarif_Malzeme "
                        + "JOIN Malzemeler ON Tarif_Malzeme.MalzemeID = Malzemeler.MalzemeID "
                        + "WHERE Tarif_Malzeme.TarifID = Tarifler.TarifID) AS Maliyet "
                        + "FROM Tarifler "
                        + "JOIN Kategoriler ON Tarifler.KategoriID = Kategoriler.KategoriID";
                resultSet = statement.executeQuery(query);
            } else {
                System.out.println("Veritabanı bağlantısı sağlanamadı.");
            }
        } catch (SQLException e) {
            System.out.println("Tarifleri alırken hata oluştu: " + e.getMessage());
        } 
        return resultSet;
    }

    public static ResultSet getMalzemeler() {
        ResultSet resultSet = null;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT MalzemeAdi FROM Malzemeler ORDER BY MalzemeAdi ASC";  // Alfabetik sıraya göre malzemeleri getirir
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Malzemeler alınırken hata oluştu: " + e.getMessage());
        }
        return resultSet;
    }

    public static ResultSet getAllMalzemeler() {
        ResultSet resultSet = null;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT MalzemeID, MalzemeAdi, ToplamMiktar, MalzemeBirim, BirimFiyat FROM Malzemeler";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Malzemeler alınırken hata oluştu: " + e.getMessage());
        }
        return resultSet;
    }

    public static ResultSet getKategoriler() {
        ResultSet resultSet = null;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT KategoriAdi FROM Kategoriler ORDER BY KategoriAdi ASC";  // Alfabetik sıraya göre kategorileri getirir
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Kategoriler alınırken hata oluştu: " + e.getMessage());
        }
        return resultSet;
    }

    public static ResultSet getMalzemeBirim() {
        ResultSet resultSet = null;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT DISTINCT MalzemeBirim FROM Malzemeler ORDER BY MalzemeBirim ASC";  // Alfabetik sıraya göre birimleri getirir
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Malzemeler alınırken hata oluştu: " + e.getMessage());
        }
        return resultSet;
    }

    public static void insertMalzeme(String malzemeAdi, String toplamMiktar, String malzemeBirim, double birimFiyat) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO Malzemeler (MalzemeAdi, ToplamMiktar, MalzemeBirim, BirimFiyat) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, malzemeAdi);
            preparedStatement.setString(2, toplamMiktar);
            preparedStatement.setString(3, malzemeBirim);
            preparedStatement.setDouble(4, birimFiyat);

            preparedStatement.executeUpdate();  // Veri tabanına yeni malzeme ekle
            System.out.println("Malzeme başarıyla eklendi.");
        } catch (SQLException e) {
            System.out.println("Malzeme eklenirken hata oluştu: " + e.getMessage());
        }
    }

    public static boolean isTarifAdiMevcut(String tarifAdi) {
        try {
            Connection connection = getConnection();
            String query = "SELECT COUNT(*) FROM Tarifler WHERE TarifAdi = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tarifAdi);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true;  // Tarif adı mevcut
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Tarif adı mevcut değil
    }

    public static int insertTarif(String tarifAdi, int kategoriID, int sure, String talimatlar) {
        int tarifID = -1; // Eklenen tarifin ID'sini almak için
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO Tarifler (TarifAdi, KategoriID, HazirlamaSuresi, Talimatlar) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, tarifAdi);
            preparedStatement.setInt(2, kategoriID);
            preparedStatement.setInt(3, sure);
            preparedStatement.setString(4, talimatlar);

            preparedStatement.executeUpdate();

            // Eklenen tarifin ID'sini al
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                tarifID = rs.getInt(1);  // TarifID
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarifID;  // Tarifin ID'sini döndür
    }

    public static void insertTarifMalzeme(int tarifID, int malzemeID, double malzemeMiktar) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO tarif_malzeme (TarifID, MalzemeID, MalzemeMiktar) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tarifID);
            preparedStatement.setInt(2, malzemeID);
            preparedStatement.setDouble(3, malzemeMiktar);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getMalzemeIDByAdi(String malzemeAdi) {
        int malzemeID = -1;
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            String query = "SELECT MalzemeID FROM Malzemeler WHERE MalzemeAdi = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, malzemeAdi);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                malzemeID = rs.getInt("MalzemeID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        // ResultSet, Statement ve Connection nesnelerini kapatma
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        return malzemeID;
    }

    public static int getKategoriIDByAdi(String kategoriAdi) {
        int kategoriID = -1;
        try {
            Connection connection = getConnection();
            String query = "SELECT KategoriID FROM Kategoriler WHERE KategoriAdi = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kategoriAdi);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                kategoriID = rs.getInt("KategoriID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kategoriID;
    }
    
    public static int getKategoriIDByTarifAdi(String tarifAdi) {
        int kategoriID = -1;  // Varsayılan değer (bulunamazsa -1 döndürülür)
        try {
            Connection connection = getConnection();
            String query = "SELECT KategoriID FROM Tarifler WHERE TarifAdi = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tarifAdi);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                kategoriID = rs.getInt("KategoriID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kategoriID;
    }


    public static int updateTarif(String tarifAdi, int kategoriID, int sure, String talimatlar) {
        int tarifID = -1;
        try {
            // Veritabanı bağlantısını al
            Connection connection = getConnection();

            // Tarif güncelleme sorgusu
            String query = "UPDATE Tarifler SET KategoriID = ?, HazirlamaSuresi = ?, Talimatlar = ? WHERE TarifAdi = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Sorguya parametreleri yerleştir
            preparedStatement.setInt(1, kategoriID);
            preparedStatement.setInt(2, sure);
            preparedStatement.setString(3, talimatlar);
            preparedStatement.setString(4, tarifAdi);

            // Güncelleme işlemini gerçekleştir
            int rowsAffected = preparedStatement.executeUpdate();

            // Eğer güncelleme başarılıysa tarif ID'sini almak için yeni bir sorgu çalıştır
            if (rowsAffected > 0) {
                // Güncellenen tarifin ID'sini almak için yeni bir sorgu yap
                String selectQuery = "SELECT TarifID FROM Tarifler WHERE TarifAdi = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, tarifAdi);

                ResultSet resultSet = selectStatement.executeQuery();
                if (resultSet.next()) {
                    tarifID = resultSet.getInt("TarifID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Güncellenen tarifin ID'sini döndür
        return tarifID;
    }

    public static void deleteTarifMalzemeByTarifID(int tarifID) {
        try {
            // Veritabanı bağlantısını al
            Connection connection = getConnection();

            // Tarif-malzeme ilişkilerini silmek için sorgu
            String query = "DELETE FROM tarif_malzeme WHERE TarifID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Sorguya tarifID parametresini yerleştir
            preparedStatement.setInt(1, tarifID);

            // Silme işlemini gerçekleştir
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Tarif-malzeme ilişkileri başarıyla silindi.");
            } else {
                System.out.println("Belirtilen tarifID için ilişkiler bulunamadı.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Tarif-malzeme ilişkileri silinirken hata oluştu.");
        }
    }

    public static void deleteTarifByAdi(String tarifAdi) {
        try {
            // Veritabanı bağlantısını al
            Connection connection = getConnection();

            // Tarif adını kullanarak tarifin ID'sini bul
            String selectQuery = "SELECT TarifID FROM Tarifler WHERE TarifAdi = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, tarifAdi);
            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                int tarifID = rs.getInt("TarifID");

                // Tarif-malzeme ilişkisini sil
                String deleteTarifMalzemeQuery = "DELETE FROM Tarif_Malzeme WHERE TarifID = ?";
                PreparedStatement deleteTarifMalzemeStatement = connection.prepareStatement(deleteTarifMalzemeQuery);
                deleteTarifMalzemeStatement.setInt(1, tarifID);
                deleteTarifMalzemeStatement.executeUpdate();

                // Tarifi sil
                String deleteTarifQuery = "DELETE FROM Tarifler WHERE TarifID = ?";
                PreparedStatement deleteTarifStatement = connection.prepareStatement(deleteTarifQuery);
                deleteTarifStatement.setInt(1, tarifID);
                deleteTarifStatement.executeUpdate();

                System.out.println("Tarif başarıyla silindi.");
            } else {
                System.out.println("Belirtilen isimde bir tarif bulunamadı.");
            }

        } catch (SQLException e) {
            System.out.println("Tarif silinirken bir hata oluştu: " + e.getMessage());
        }
    }

    public static Object[][] getTarifMalzemeleri(String tarifAdi) {
        Object[][] malzemeler = null;
        try {
            Connection connection = getConnection();
            String query = "SELECT m.MalzemeAdi, tm.MalzemeMiktar "
                    + "FROM Tarifler t "
                    + "JOIN Tarif_Malzeme tm ON t.TarifID = tm.TarifID "
                    + "JOIN Malzemeler m ON tm.MalzemeID = m.MalzemeID "
                    + "WHERE t.TarifAdi = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tarifAdi);
            ResultSet rs = statement.executeQuery();

            // Sonuçları tablo formatına çevir
            List<Object[]> list = new ArrayList<>();
            while (rs.next()) {
                String malzemeAdi = rs.getString("MalzemeAdi");
                double miktar = rs.getDouble("MalzemeMiktar");
                list.add(new Object[]{malzemeAdi, miktar});
            }
            malzemeler = list.toArray(new Object[0][0]);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return malzemeler;
    }

    public static String getTarifTalimatlar(String tarifAdi) {
        String talimatlar = "";
        try {
            Connection connection = getConnection();
            String query = "SELECT Talimatlar FROM Tarifler WHERE TarifAdi = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tarifAdi);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                talimatlar = rs.getString("Talimatlar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return talimatlar;
    }

    public static ResultSet getTarifAdi() {
        ResultSet resultSet = null;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT TarifAdi FROM tarifler";  // Alfabetik sıraya göre malzemeleri getirir
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Malzemeler alınırken hata oluştu: " + e.getMessage());
        }
        return resultSet;
    }
    
    public static ResultSet getMatchingTarif(java.util.List<Integer> selectedMalzemeIDs) {
        ResultSet resultSet = null;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            // Malzeme ID'lerini SQL sorgusu için uygun hale getirin (örn. "1, 2, 3" şeklinde)
            String idList = selectedMalzemeIDs.toString().replaceAll("[\\[\\]]", "");
            // SQL Sorgusu: Her tarifin toplam malzemesini, eşleşen malzeme sayısını ve eksik olan malzemeleri alın
            String query = "SELECT t.TarifAdi, "
                    + "(SELECT COUNT(DISTINCT tm1.MalzemeID) FROM tarif_malzeme tm1 WHERE tm1.TarifID = t.TarifID) AS ToplamMalzeme, "
                    + "COUNT(DISTINCT tm2.MalzemeID) AS EslestirilenMalzeme, "
                    + "t.TarifID "
                    + "FROM tarifler t "
                    + "LEFT JOIN tarif_malzeme tm2 ON t.TarifID = tm2.TarifID AND tm2.MalzemeID IN (" + idList + ") "
                    + "GROUP BY t.TarifID";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
        return resultSet;
    }
    
    public static double hesaplaEksikMalzemeMaliyet(int tarifID) {
        double toplamMaliyet = 0.0;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                "SELECT m.MalzemeAdi, m.BirimFiyat, tm.MalzemeMiktar, m.ToplamMiktar "
                + "FROM malzemeler m "
                + "JOIN tarif_malzeme tm ON m.MalzemeID = tm.MalzemeID "
                + "WHERE tm.TarifID = ?");

            statement.setInt(1, tarifID);
            rs = statement.executeQuery();

            while (rs.next()) {
                double birimFiyat = rs.getDouble("BirimFiyat");
                double gerekenMiktar = rs.getDouble("MalzemeMiktar");
                double mevcutMiktar = rs.getDouble("ToplamMiktar");

                // Eksik miktarı hesapla (mevcut miktar yetersizse)
                double eksikMiktar = Math.max(gerekenMiktar - mevcutMiktar, 0);

                // Eksik malzeme varsa, maliyeti hesapla
                if (eksikMiktar > 0) {
                    toplamMaliyet += eksikMiktar * birimFiyat;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ResultSet, Statement ve Connection nesnelerini kapatma
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return toplamMaliyet;
    }

    public static double getTarifMaliyeti(String tarifAdi) {
        double maliyet = 0.0;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT SUM(Malzemeler.BirimFiyat * Tarif_Malzeme.MalzemeMiktar) AS Maliyet "
                + "FROM Tarifler "
                + "JOIN Tarif_Malzeme ON Tarifler.TarifID = Tarif_Malzeme.TarifID "
                + "JOIN Malzemeler ON Tarif_Malzeme.MalzemeID = Malzemeler.MalzemeID "
                + "WHERE Tarifler.TarifAdi = ?")) {
            statement.setString(1, tarifAdi);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                maliyet = rs.getDouble("Maliyet");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maliyet;
    }
    
    public static int getMalzemeSayisi(String tarifAdi) {
        int malzemeSayisi = 0;
        try {
            Connection connection = getConnection();
            String query = "SELECT COUNT(*) AS MalzemeSayisi FROM tarif_malzeme "
                    + "JOIN tarifler ON tarif_malzeme.TarifID = tarifler.TarifID "
                    + "WHERE tarifler.TarifAdi = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tarifAdi);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                malzemeSayisi = rs.getInt("MalzemeSayisi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return malzemeSayisi;
    }

    public static int getTarifSure(String tarifAdi) {
        int sure = 0;
        try {
            Connection connection = getConnection();
            String query = "SELECT HazirlamaSuresi FROM Tarifler WHERE TarifAdi = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tarifAdi);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                sure = rs.getInt("HazirlamaSuresi");
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sure;
    }

    
}

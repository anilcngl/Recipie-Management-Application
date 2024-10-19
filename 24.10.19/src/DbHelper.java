
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

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
                String query = "SELECT Tarifler.TarifID, Tarifler.TarifAdi, Tarifler.HazirlamaSuresi, "
                        + "(SELECT SUM(Malzemeler.BirimFiyat * Tarif_Malzeme.MalzemeMiktar) "
                        + "FROM Tarif_Malzeme "
                        + "JOIN Malzemeler ON Tarif_Malzeme.MalzemeID = Malzemeler.MalzemeID "
                        + "WHERE Tarif_Malzeme.TarifID = Tarifler.TarifID) AS Maliyet "
                        + "FROM Tarifler";
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
        try {
            Connection connection = getConnection();
            String query = "SELECT MalzemeID FROM Malzemeler WHERE MalzemeAdi = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, malzemeAdi);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                malzemeID = rs.getInt("MalzemeID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

}

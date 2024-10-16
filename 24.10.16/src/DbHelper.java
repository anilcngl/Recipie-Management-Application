import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}

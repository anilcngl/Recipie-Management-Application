
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection conn = DbHelper.getConnection();

        // Uygulamanın GUI'yi başlatması için JFrame'i çağırıyoruz
        java.awt.EventQueue.invokeLater(() -> {
            new TarifJFrame().setVisible(true);
        });
    }
}

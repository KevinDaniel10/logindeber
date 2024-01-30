import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class biografia {
    public JPanel pantallapanel;
    private JTextPane bitext;
    private JLabel bio;

    public biografia() {
        String dbURL = "jdbc:mysql://localhost:3306/login";
        String dbuserName = "root";
        String dbpassword = "Elmontes0";
        try (Connection connection = DriverManager.getConnection(dbURL, dbuserName, dbpassword)) {

            String query = "SELECT * FROM biografia";
            try (PreparedStatement statement = connection.prepareStatement(query)) {

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String texto = resultSet.getString("texto");
                    bitext.setText(texto);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
        }
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
    private JLabel titulo;
    private JTextField usuariotexto;
    private JPasswordField contrasenatext;
    private JButton ingresarButton;
    private JLabel usuario;
    private JLabel contrasena;
    public JPanel loginpanel;

    public login() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbURL = "jdbc:mysql://localhost:3306/login";
                String dbuserName = "root";
                String dbpassword = "Elmontes0";

                try (Connection connection = DriverManager.getConnection(dbURL, dbuserName, dbpassword)) {
                    String query = "SELECT * FROM registro WHERE usuario = ? AND contraseña = ?";
                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.setString(1, usuariotexto.getText());
                        statement.setString(2, String.valueOf(contrasenatext.getPassword()));

                        try (ResultSet resultSet = statement.executeQuery()) {
                            if (resultSet.next()) {
                                JFrame frame2 = new JFrame("Pantalla");
                                frame2.setContentPane(new biografia().pantallapanel);
                                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame2.setSize(500, 500);
                                frame2.setVisible(true);

                                JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(ingresarButton);
                                loginFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
                }
            }
        });
    }
}


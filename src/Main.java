
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("LOGIN");
        frame.setContentPane(new login().loginpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
import javax.swing.*;
import java.net.SocketOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Alumnos {
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton crearButton;
    private JButton consultarButton;
    private JList list1;
    Connection con;
    public void conectar() {
        try {
            con= DriverManager.getConnection("localhost/learning", "gabriel", "291194Cg@ñ");
            System.out.println("Conectado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

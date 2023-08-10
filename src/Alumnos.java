import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Alumnos extends JFrame {
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
    public Alumnos() {
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectar();
            }
        });
    }

    public static void main(String[] args) {
        Alumnos f = new Alumnos();
        f.setContentPane(new Alumnos().panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
    }

    public void conectar() {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learning", "gabriel", "291194Cg@ñ");
            System.out.println("Conectado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

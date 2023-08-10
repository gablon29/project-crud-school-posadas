import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketOption;
import java.sql.*;

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
    PreparedStatement ps;
    Statement st;
    ResultSet r;
    DefaultListModel mod = new DefaultListModel();
    public Alumnos() {
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listar();
                }catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ingresar();
                }catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
    }
    public void listar() throws SQLException {
        conectar(); // nos conect a database
        list1.setModel(mod);
        st = con.createStatement();
        r = st.executeQuery("SELECT id, nombre, apellido, FROM alumnos");
        mod.removeAllElements();
        while (r.next()) {
            mod.addElement
                    (r.getString(1)
                            + " " + r.getString(2)
                            + " " + r.getString(3));
        }
    }
    public void ingresar() throws SQLException {
        conectar();
        ps = con.prepareStatement("INSERT INTO alumnos VALUES (?,?,?,?,?,?)");
        ps.setInt(1,Integer.parseInt(textField1.getText()));
        ps.setString(2,textField2.getText());
        ps.setString(3,textField3.getText());
        ps.setInt(4,Integer.parseInt(textField4.getText()));
        ps.setString(5,textField5.getText());
        ps.setString(6,textField6.getText());
        if (ps.executeUpdate()>0) {
            list1.setModel(mod);
            mod.removeAllElements(); // removemos los datos para que no se acumule
            mod.addElement("Incersion exitosa");
            // situamos todos los label en un string vacio
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
        }
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

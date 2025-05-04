package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesionV2 extends javax.swing.JFrame {
    private JPanel pPrincipal;
    private JLabel Titulo;
    private JLabel SubTitulo;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton iniciarSesiónButton;

    public IniciarSesionV2(String tipoUsuario) {
        setTitle("Iniciando sesión como "+ tipoUsuario);
        setContentPane(pPrincipal);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Vista/Fotos/LogoEAnegro.png"));
        setIconImage(imagen.getImage());



        Titulo.setText("Iniciando sesión como "+ tipoUsuario);
        SubTitulo.setText("Por favor introduzca los datos del "+tipoUsuario.toLowerCase()+" para iniciar sesion.");
        iniciarSesiónButton.setEnabled(false);
        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField1.getText().equals("") && !passwordField1.getText().equals("")) {
                    iniciarSesiónButton.setEnabled(true);
                }
            }
        });
    }


    public static void main(String[] args) {
        IniciarSesionV2 ventana = new IniciarSesionV2("Administrador");
        ventana.setVisible(true);
    }
}


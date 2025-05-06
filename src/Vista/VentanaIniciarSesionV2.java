package Vista;

import Controlador.VistaController;
import Excepciones.CampoObligatorioException;

import javax.swing.*;
import java.awt.event.*;

public class VentanaIniciarSesionV2 extends javax.swing.JFrame {
    private JPanel pPrincipal;
    private JLabel Titulo;
    private JLabel SubTitulo;
    private JTextField nombre;
    private JPasswordField contrasena;
    private JButton iniciarSesiónButton;

    public VentanaIniciarSesionV2(String tipoUsuario) {
        setTitle("Iniciando sesión como "+ tipoUsuario);
        setContentPane(pPrincipal);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Vista/Fotos/LogoEA.png"));
        setIconImage(imagen.getImage());



        Titulo.setText("Iniciando sesión como "+ tipoUsuario);
        SubTitulo.setText("Por favor introduzca los datos del "+tipoUsuario.toLowerCase()+" para iniciar sesion.");


        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passw = new String(contrasena.getPassword());
                try {
                    if (nombre.equals("")){
                        throw new CampoObligatorioException("Error: El campo nombre es obligatorio!");
                    }
                    if (contrasena.equals("")) {
                        throw new CampoObligatorioException("Error: El campo contraseña el obligatorio!");
                    }
                    else{
                        if (VistaController.inciarSesionUsuario(nombre.getText(),passw,tipoUsuario)){
                            VistaController.VentanaAdministradorV2(nombre.getText(),VentanaIniciarSesionV2.this);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Error: Contraseña o Usuario incorrectos","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }catch (CampoObligatorioException u){
                    JOptionPane.showMessageDialog(null,u.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}


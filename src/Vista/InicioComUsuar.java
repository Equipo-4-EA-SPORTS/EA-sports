package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class InicioComUsuar extends JFrame {
    private JPanel pPrincipal;
    private JTextField tfUsuario;
    private JPasswordField tfContrase;
    private JButton bIniciar;
    private JCheckBox checkRecord;
    private JLabel textoTitulo;

    public InicioComUsuar(String tipoUsr) {
        setTitle("Inicio Com Usuario normal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pPrincipal);
        setResizable(false);

        textoTitulo.setText("INICIO COMO " + tipoUsr);

        switch (tipoUsr) {
            case "ADMINISTRADOR":
                setSize(375,200);
                break;
            case "USUARIO":
                setSize(300,200);
                break;
        }
        setLocationRelativeTo(null);


        bIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarUsuario(tipoUsr);
            }
        });
        tfContrase.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    verificarUsuario(tipoUsr);
                }
            }
        });


    }
    public void verificarUsuario(String tipoUsr){
        if(tfUsuario.getText().equals("") || tfContrase.getText().equals("")) {
            JOptionPane.showMessageDialog(pPrincipal,"ERROR, todos los campos son obligatorios");
        }
        else {
            if (VistaController.inciarSesionUsuario(tfUsuario.getText(),tfContrase.getText(),tipoUsr)){
                switch (tipoUsr){
                    case "ADMINISTRADOR":
                        VistaController.ventanaAdministrador(InicioComUsuar.this,tfUsuario.getText());
                        break;
                    case "USUARIO":
                        VistaController.ventanaUsuario(InicioComUsuar.this,tfUsuario.getText());
                        break;
                }
            }
            else{
                JOptionPane.showMessageDialog(pPrincipal, "Usuario o Contraseña incorrectas","Error",JOptionPane.ERROR_MESSAGE);
                tfUsuario.setText("");
                tfContrase.setText("");
            }
        }
    }


}

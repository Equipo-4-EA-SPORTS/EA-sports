package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioAdmin extends JFrame {
    private JLabel tituloAB;
    private JButton button1;
    private JButton USUARIObutton;
    private JButton ADMINISTRADORButton;
    private JPanel pPrincipal;

    public UsuarioAdmin() {
        setTitle("INICIO SESIÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pPrincipal);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);

        USUARIObutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.usuario(UsuarioAdmin.this,USUARIObutton.getText());
            }
        });
        ADMINISTRADORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.usuario(UsuarioAdmin.this,ADMINISTRADORButton.getText());
            }
        });
    }
    public static void main(String[] args) {
        UsuarioAdmin ventana = new UsuarioAdmin();
        ventana.setVisible(true);
    }

}


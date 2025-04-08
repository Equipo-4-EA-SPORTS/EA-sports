package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioAdmin extends JFrame {
    private JLabel tituloAB;
    private JButton USUARIOButton;
    private JButton ADMINISTRADORButton;
    private JButton button1;

    public UsuarioAdmin() {
        setTitle("INICIO SESIÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setSize(500,500);

        USUARIOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.usuario();
            }
        });
        ADMINISTRADORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.admin();
            }
        });
    }

}


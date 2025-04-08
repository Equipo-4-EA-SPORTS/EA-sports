package Vista;

import Controlador.VistaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioAdmin extends JFrame {
    private JLabel tituloAB;
    private JButton USUARIOButton;
    private JButton ADMINISTRADORButton;
    private JButton fotoB;

    public UsuarioAdmin() {
        setTitle("INICIO SESIÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setResizable(false);



        add(tituloAB);
        add(USUARIOButton);
        add(ADMINISTRADORButton);
        add(fotoB);


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

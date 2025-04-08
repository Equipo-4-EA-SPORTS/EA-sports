package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VinicioSesion extends JFrame {
    private JButton fotoBoton;
    private JButton bComenzar;
    private JPanel PanelPrincipal;


    private static VistaController vc;

    public VinicioSesion(VistaController vc) {
        setTitle("EA-SPORTS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        add(PanelPrincipal); // Agregar el panel principal a la ventana

        bComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vc.mostrarinicioSesion();
            }
        });


    }
}
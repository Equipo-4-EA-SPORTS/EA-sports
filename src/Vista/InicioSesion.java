package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JFrame {
    private JLabel tituloAB;
    private JButton fotoBoton;
    private JButton COMENZARButton;
    private JPanel PanelPrincipal;
    private static VistaController vc = new VistaController();
    public InicioSesion() {
        setTitle("EA-SPORTS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        add(PanelPrincipal); // Agregar el panel principal a la ventana

        COMENZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vc.mostrarinicioSesion();
            }
        });
    }
    }

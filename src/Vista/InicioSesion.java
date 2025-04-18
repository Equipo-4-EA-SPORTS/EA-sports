package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JFrame {
    private JButton fotoBoton;
    private JButton COMENZARButton;
    private JPanel PanelPrincipal;
    public InicioSesion() {
        setContentPane(PanelPrincipal);
        setTitle("EA-SPORTS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);


        COMENZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int estado = VistaController.verificarCompeticionCreada();
                if (estado>0) {
                    VistaController.mostrarinicioSesion(InicioSesion.this);
                } else {
                    VistaController.crearCompeticion();
                    VistaController.mostrarinicioSesion(InicioSesion.this);
                }
            }
        });
    }
    }

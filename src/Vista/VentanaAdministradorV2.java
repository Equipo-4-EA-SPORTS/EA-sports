package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministradorV2 extends javax.swing.JFrame {
    private JPanel pPincipal;
    private JLabel Titulo;
    private JButton jugadores;
    private JButton equipos;
    private JButton jornadas;
    private JButton retroceder;
    private JButton competicion;
    private JButton enfrentamientos;

    public VentanaAdministradorV2(String nombre) {
        setTitle("Usuario: "+nombre);
        setContentPane(pPincipal);
        setSize(500, 400);
        setLocationRelativeTo(null);
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Vista/Fotos/LogoEAnegro.png"));
        setIconImage(imagen.getImage());

        Titulo.setText("¡Bienvenido " +nombre+"!");

        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.mostrarinicioSesion(VentanaAdministradorV2.this);
            }
        });
        jugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.VentanaGestionJugadoresV2(VentanaAdministradorV2.this,nombre);
            }
        });


    }
    public static void main(String[] args) {
        VentanaAdministradorV2 ventana = new VentanaAdministradorV2("admin1");
        ventana.setVisible(true);
    }

}

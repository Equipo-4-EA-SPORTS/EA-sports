package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        Titulo.setText("¡Bienvenido " +nombre+"!");

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Vista/Fotos/LogoEA.png"));
        setIconImage(imagen.getImage());

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


        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jugadores.setCursor(new Cursor(Cursor.HAND_CURSOR));
                equipos.setCursor(new Cursor(Cursor.HAND_CURSOR));
                enfrentamientos.setCursor(new Cursor(Cursor.HAND_CURSOR));
                jornadas.setCursor(new Cursor(Cursor.HAND_CURSOR));
                competicion.setCursor(new Cursor(Cursor.HAND_CURSOR));
                retroceder.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
        };

        jugadores.addMouseListener(listener);
        equipos.addMouseListener(listener);
        jornadas.addMouseListener(listener);
        enfrentamientos.addMouseListener(listener);
        competicion.addMouseListener(listener);
        retroceder.addMouseListener(listener);
    }
    public static void main(String[] args) {
        VentanaAdministradorV2 ventana = new VentanaAdministradorV2("admin1");
        ventana.setVisible(true);
    }

}

package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaGestionEquiposV2 extends JFrame {
    private JButton inscribirEquipo;
    private JButton eliminarEquipo;
    private JButton modificarEquipo;
    private JButton mostrarEquipo;
    private JButton retroceder;
    private JPanel pPrincipal;

    public VentanaGestionEquiposV2(String nombre) {

        setContentPane(pPrincipal);
        setTitle("Gestion de Equipos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Vista/Fotos/FaviconEA.png"));
        setIconImage(imagen.getImage());

        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.VentanaAdministradorV2(nombre,VentanaGestionEquiposV2.this);
            }
        });
        retroceder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                retroceder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        mostrarEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mostrarEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        inscribirEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                inscribirEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        eliminarEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                eliminarEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        modificarEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                modificarEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        eliminarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.ModalEliminacionEquiposV2();
            }
        });
        mostrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.ModalMostrarEquiposV2();
            }
        });
        inscribirEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.ModalInscripcionEquiposV2();
            }
        });
        modificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.ModalSeleccionarEquipoV2();
            }
        });
    }
}

package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;

public class VentanaGestionJornada extends JFrame {
    private JPanel contentPane;
    private JButton bAceptar;
    private JButton bVolver;
    private JComboBox comboBox1;

    public VentanaGestionJornada(String nombre) {
        setContentPane(contentPane);
        setTitle("Ventana Gestion Jornada");
        setResizable(false);
        setSize(400, 200);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(bAceptar);

        JMenuBar menuBar = new JMenuBar();

        JMenu Jusuario = new JMenu("Usuario");
        JMenu JotrasOpciones = new JMenu("Otras opciones");

        JMenuItem Jnombre = new JMenuItem(nombre);
        JMenuItem JcambiarUsuario = new JMenuItem("Cambiar de Usuario");
        JMenuItem Jsalir = new JMenuItem("Salir");

        Jusuario.add(Jnombre);
        Jusuario.add(JcambiarUsuario);
        JotrasOpciones.add(Jsalir);

        Jnombre.setEnabled(false);

        menuBar.add(Jusuario);
        menuBar.add(JotrasOpciones);

        setJMenuBar(menuBar);

        JcambiarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.mostrarinicioSesion(VentanaGestionJornada.this);
            }
        });

        Jsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        bVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaController.ventanaGestionCompeticion(VentanaGestionJornada.this, nombre);
            }
        });

        bAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (comboBox1.getSelectedIndex()){
                    case 0:
                        JOptionPane.showMessageDialog(contentPane, "ERROR. Debes de seleccionar una opción", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        if (!VistaController.estadoCompeticion()) {
                            VistaController.ventanaCrearJornada(VentanaGestionJornada.this, nombre);
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "No se pueden crear enfrentamientos si la competición está abierta");
                        }
                        break;
                    case 2:
                        if (!VistaController.VentanaMostrarJornada()){
                            JOptionPane.showMessageDialog(contentPane,"No hay jornadas para mostrar", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
            }
        });

    }

}
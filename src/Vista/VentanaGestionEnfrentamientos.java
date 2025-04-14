package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;

public class VentanaGestionEnfrentamientos extends JFrame {
    private JPanel pPrincipal;
    private JButton bAceptar;
    private JButton bVolver;
    private JComboBox comboBox;

    public VentanaGestionEnfrentamientos(String nombre) {
        setContentPane(pPrincipal);
        setTitle("Administrador");
        setResizable(false);
        setSize(400,200);
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
                VistaController.mostrarinicioSesion(VentanaGestionEnfrentamientos.this);
            }
        });

        Jsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        bVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.ventanaAdministrador(VentanaGestionEnfrentamientos.this,nombre);
            }
        });
        /*
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*switch (comboBox.getSelectedIndex()){
                    case 0:
                        JOptionPane.showMessageDialog(pPrincipal, "ERROR. Debes de seleccionar una opción", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        if (!VistaController.estadoCompeticion()) {
                            VistaController.ventanaCrearEnfrentamiento();
                        } else {
                            JOptionPane.showMessageDialog(pPrincipal, "No se pueden crear enfrentamientos si la competición está abierta");
                        }
                        break;
                    case 2:
                        if (!VistaController.estadoCompeticion()) {
                            if (!VistaController.ventanaEliminarEnfrentamiento()) {
                                JOptionPane.showMessageDialog(pPrincipal, "No hay enfrentamientos para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(pPrincipal, "No se pueden eliminar enfrentamientos si la competición está abierta");
                        }
                        break;
                    case 3:
                        if (!VistaController.estadoCompeticion()) {
                            if (!VistaController.ventanaModificarEnfrentamiento()) {
                                JOptionPane.showMessageDialog(pPrincipal, "No hay enfrentamientos para modificar", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(pPrincipal, "No se pueden modificar enfrentamientos si la competición está abierta");
                        }
                        break;
                    case 4:
                        if (!VistaController.ventanaMostrarEnfrentamientos()) {
                            JOptionPane.showMessageDialog(pPrincipal, "No hay enfrentamientos para mostrar", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }*/
            }

        });*/

    }
}
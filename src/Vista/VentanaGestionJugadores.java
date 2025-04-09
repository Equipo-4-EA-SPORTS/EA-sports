package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionJugadores extends JFrame {
    private JButton ACEPTARbutton;
    private JComboBox opcionesMenu;
    private JLabel tituloAB;
    private JPanel pPrincipal;

    public VentanaGestionJugadores(String nombre) {
        setTitle("Administrador");
        setResizable(false);
        setSize(400, 200);
        setLocationRelativeTo(null);

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
                VistaController.mostrarinicioSesion(VentanaGestionJugadores.this);
            }
        });
        Jsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ACEPTARbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (opcionesMenu.getSelectedIndex()) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "ERROR: Debes seleccionar una opcion", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        VistaController.mostrarinscribirJugador(VentanaGestionJugadores.this);
                        break;
                    case 2:
                        if (!VistaController.VentanaEliminarJugador(VentanaGestionJugadores.this)) {
                            JOptionPane.showMessageDialog(pPrincipal, "No hay jugadores para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                }
            }
        });
    }
}


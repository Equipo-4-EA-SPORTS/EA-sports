package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionEquipos extends JFrame {
    private JButton ACEPTARbutton;
    private JComboBox comboBox1;
    private JPanel pPrincipal;

    public VentanaGestionEquipos(String nombre) {
        setContentPane(pPrincipal);
        setTitle("Administrador");
        setResizable(false);
        setSize(800,400);
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
                VistaController.mostrarinicioSesion(VentanaGestionEquipos.this);
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
                switch (comboBox1.getSelectedIndex()) {
                    case 0:
                        JOptionPane.showMessageDialog(pPrincipal,"ERROR. Debes de seleccionar una opcion", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        VistaController.ventanaInscribirEquipo(VentanaGestionEquipos.this);
                        break;
                    case 2:
                        VistaController.VentanaEliminarEquipo(VentanaGestionEquipos.this);
                        break;
                    case 3:
                        VistaController.ventanaModificarEquipo(VentanaGestionEquipos.this);
                        break;
                }
            }
        });

    }
}

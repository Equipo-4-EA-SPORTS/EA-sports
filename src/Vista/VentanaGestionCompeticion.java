package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionCompeticion extends JFrame {
    private JComboBox comboBox1;
    private JButton ACEPTARbutton;
    private JButton VOLVERbutton;
    private JPanel pPrincipal;

    public VentanaGestionCompeticion(String nombre) {

        setContentPane(pPrincipal);
        setTitle("Administrador");
        setResizable(false);
        setSize(400,200);
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
                VistaController.mostrarinicioSesion(VentanaGestionCompeticion.this);
            }
        });

        Jsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        VOLVERbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.ventanaAdministrador(VentanaGestionCompeticion.this,nombre);
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
                        VistaController.VentanaGestionEnfrentamientos(VentanaGestionCompeticion.this,nombre);
                        break;
                    case 2:
                        VistaController.ventanaGestionJornadas(VentanaGestionCompeticion.this,nombre);
                        break;
                    case 3:
                        if (VistaController.abrirCompeticion()){
                            JOptionPane.showMessageDialog(null, "Competición abierta correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo abrir la competición", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }

            }
        });
    }
}

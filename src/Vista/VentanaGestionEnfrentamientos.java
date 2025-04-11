package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;

public class VentanaGestionEnfrentamientos extends JFrame {
    private JPanel pPrincipal;
    private JButton bAceptar;
    private JButton bVolver;
    private JComboBox comboBox1;

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

        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBox1.getSelectedIndex()){
                    case 0:
                        JOptionPane.showMessageDialog(pPrincipal,"ERROR. Debes de seleccionar una opcion", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        //ventana crear enfrentamiento
                        break;
                    case 2:
                        //ventana eliminar enfrentamiento
                        break;
                    case 3:
                        //ventana modificar enfrentamiento
                        break;
                    case 4:
                        //ventana mostrar enfrentamiento
                        break;
                }
            }
        });
    }
}
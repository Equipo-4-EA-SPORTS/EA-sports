package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaUsuario extends javax.swing.JFrame {
    private JPanel Pprincipal;
    private JComboBox comboBox1;
    private JButton ACEPTARButton;

    public VentanaUsuario(String nombre) {
        setContentPane(Pprincipal);
        setTitle("Usuario");
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
                VistaController.mostrarinicioSesion(VentanaUsuario.this);
            }
        });

        Jsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        ACEPTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBox1.getSelectedIndex()) {
                    case 0:
                        JOptionPane.showMessageDialog(Pprincipal,"ERROR. Debes de seleccionar una opcion", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        VistaController.ventanaInformesEquipos(VentanaUsuario.this);//Falta por crear
                        break;
                    case 2:
                        VistaController.ventanaVerResultadosUltimJornada(VentanaUsuario.this);//Falta por crear
                }
            }
        });
    }
}

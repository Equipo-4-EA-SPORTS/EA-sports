package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaInscripcionJugdadorV2 extends JFrame {
    private JPanel pPrincipal;
    private JPanel datosPersonales;
    private JPanel datosJugador;
    private JPanel datosEquipo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox equipos;
    private JComboBox roles;
    private JButton atrásButton;
    private JButton siguienteButton;
    private JButton enviarButton;

    public VentanaInscripcionJugdadorV2()  {

        setTitle("Inscripcion Jugdador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pPrincipal);
        setSize(350, 300);
        setLocationRelativeTo(null);

        datosJugador.setVisible(false);
        datosEquipo.setVisible(false);

        if (datosPersonales.isVisible()) {
            atrásButton.setEnabled(false);
        }
        if (datosEquipo.isVisible()) {
            siguienteButton.setEnabled(false);
        }

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (datosPersonales.isVisible()) {
                    datosPersonales.setVisible(false);
                    datosJugador.setVisible(true);
                    atrásButton.setEnabled(true);
                    setSize(350, 250);
                }
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (datosJugador.isVisible()) {
                    datosJugador.setVisible(false);
                    datosEquipo.setVisible(true);
                    atrásButton.setEnabled(true);
                    siguienteButton.setEnabled(false);
                    setSize(350, 250);
                }
            }
        });
        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (datosJugador.isVisible()) {
                    datosJugador.setVisible(false);
                    datosPersonales.setVisible(true);
                    atrásButton.setEnabled(false);
                    setSize(350, 300);

                }
                if (datosEquipo.isVisible()) {
                    datosEquipo.setVisible(false);
                    datosJugador.setVisible(true);
                    siguienteButton.setEnabled(true);
                    setSize(350, 250);
                }
            }
        });
        /*Llenar las Jcombox de equipos y roles

        */

        List<String> listaEquipos = VistaController.listaEquipos();
        for (String equipo : listaEquipos){
            equipos.addItem(equipo);
        }
        roles.setEnabled(false);

        equipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (equipos.getSelectedIndex() != 0) {
                    roles.setEnabled(true);
                    List<String> listaRoles = actualizarRoles(equipos.getSelectedItem().toString());
                    for (String role : listaRoles) {
                        roles.addItem(role);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        VentanaInscripcionJugdadorV2 ventana = new VentanaInscripcionJugdadorV2();
        ventana.setVisible(true);
    }
    public static List<String> actualizarRoles(String equipo) {
        return VistaController.obtenerRoles(equipo);
    }
}

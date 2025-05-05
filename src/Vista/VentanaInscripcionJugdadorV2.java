package Vista;

import Controlador.VistaController;
import Excepciones.CampoObligatorioException;
import Excepciones.FormatoIncorrectoException;
import Excepciones.NombreDuplicadoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class VentanaInscripcionJugdadorV2 extends JFrame {
    private JPanel pPrincipal;
    private JPanel datosPersonales;
    private JPanel datosJugador;
    private JPanel datosEquipo;
    private JTextField nombreTF;
    private JTextField apellidoTf;
    private JTextField nacionalidadTf;
    private JTextField fechaTF;
    private JTextField nicknameTF;
    private JTextField sueldoTF;
    private JComboBox equipos;
    private JComboBox roles;
    private JButton atrásButton;
    private JButton siguienteButton;
    private JButton enviarButton;
    private JButton cancelar;

    public VentanaInscripcionJugdadorV2()  {

        setTitle("Inscripcion Jugdador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pPrincipal);
        setSize(350, 325);
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


        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void onOK() {
        try {
            String nombre = nombreTF.getText();
            if (nombre.isEmpty()) {
                throw new CampoObligatorioException("El nombre es un campo obligatorio");
            }
            String apellido = apellidoTf.getText();
            if (apellido.isEmpty()) {
                throw new CampoObligatorioException("El apellido es un campo obligatorio");
            }
            String nacionalidad = nacionalidadTf.getText();
            if (nacionalidad.isEmpty()) {
                throw new CampoObligatorioException("La nacionalidad es un campo obligatorio");
            }


            LocalDate fecha;
            if (fechaTF.getText().isEmpty()) {
                throw new CampoObligatorioException("La fecha es un campo obligatorio");
            }

            fecha = LocalDate.parse(fechaTF.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


            int añonacimiento = fecha.getYear();
            int añoactual = LocalDate.now().getYear();
            if (añoactual - añonacimiento < 13) {
                throw new FormatoIncorrectoException("El jugador debe de tener 13 años como mínimo");
            }


            String nickname = nicknameTF.getText();
            if (nickname.isEmpty()) {
                throw new CampoObligatorioException("El nickname es un campo obligatorio");
            }

            if (VistaController.buscarNickname(nickname)) {
                throw new NombreDuplicadoExcepcion("El nickname ya existe");
            }
            String sueldo = sueldoTF.getText();
            if (sueldo.isEmpty()) {
                throw new CampoObligatorioException("El sueldo es un campo obligatorio");
            }

            float sueldoFloat;
            try {
                sueldoFloat = Float.parseFloat(sueldo);
            } catch (NumberFormatException e) {
                throw new FormatoIncorrectoException("El sueldo debe ser un número válido");
            }

            if (sueldoFloat < 1184) {
                throw new FormatoIncorrectoException("El sueldo debe ser igual o superior al SMI (1184€)");
            }

            String equipo = equipos.getSelectedItem().toString();
            if (equipos.getSelectedIndex() == 0) {
                throw new CampoObligatorioException("Debes seleccionar un equipo");
            }
            String rol = (String) roles.getSelectedItem();
            if (roles.getSelectedIndex() == 0) {
                throw new CampoObligatorioException("El rol es un campo obligatorio");
            }

            if (VistaController.inscribirJugador(nombre, apellido, nacionalidad, fecha, nickname, sueldoFloat, rol, equipo)) {
                JOptionPane.showMessageDialog(pPrincipal, "Se ha inscrito correctamente el jugador", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                switch (JOptionPane.showConfirmDialog(pPrincipal, "Desea inscribir otro jugador?", "Pregunta", JOptionPane.YES_NO_OPTION)) {
                    case 0:
                        nombreTF.setText(null);
                        fechaTF.setText(null);
                        nicknameTF.setText(null);
                        sueldoTF.setText(null);
                        roles.setSelectedIndex(0);
                        nacionalidadTf.setText(null);
                        apellidoTf.setText(null);
                        equipos.setSelectedIndex(0);
                        break;
                    default:
                        dispose();
                        break;
                }
            }

            // Aquí podrías continuar con el guardado o lógica del jugador...

        } catch (CampoObligatorioException e) {
            JOptionPane.showMessageDialog(pPrincipal, "ERROR: " + e.getMessage(), "ERROR", -1);
        } catch (NombreDuplicadoExcepcion e) {
            JOptionPane.showMessageDialog(pPrincipal, "ERROR: " + e.getMessage(), "ERROR", -1);
        } catch (FormatoIncorrectoException e) {
            JOptionPane.showMessageDialog(pPrincipal, "ERROR: " + e.getMessage(), "ERROR", -1);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(pPrincipal, "Error: Fecha con formato invalido", "ERROR", -1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(pPrincipal, "ERROR inesperado: " + e.getMessage(), "ERROR", -1);
        }
    }
    public static void main(String[] args) {
        VentanaInscripcionJugdadorV2 ventana = new VentanaInscripcionJugdadorV2();
        ventana.setVisible(true);
    }
    public static List<String> actualizarRoles(String equipo) {
        return VistaController.obtenerRoles(equipo);
    }
}

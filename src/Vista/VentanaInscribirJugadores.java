package Vista;

import Controlador.VistaController;
import Excepciones.CampoObligatorioException;
import Excepciones.FormatoIncorrectoException;
import Excepciones.NombreDuplicadoExcepcion;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class VentanaInscribirJugadores extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nombreTF;
    private JTextField fechaTF;
    private JTextField nicknameTF;
    private JTextField sueldoTF;
    private JComboBox<String> rolCB;
    private JTextField nacionalidadTf;
    private JTextField apellidoTf;
    private JComboBox<String> equiposCB;


    public VentanaInscribirJugadores() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Inscribir Equipo");
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        rolCB.setEnabled(false);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setVisible(true);

        List<String> listaEquipos = VistaController.listaEquipos();
        for (int i = 0; i < listaEquipos.size(); i++) {
            equiposCB.insertItemAt(listaEquipos.get(i), i + 1);
        }

        equiposCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (equiposCB.getSelectedIndex() != 0){
                    actualizarRoles(equiposCB.getSelectedItem().toString());
                }
            }
        });
    }

    private void actualizarRoles(String equipoSeleccionado) {
        if (equiposCB.getSelectedIndex()!=0){
            rolCB.setEnabled(true);
            List<String> rolesDisponibles = VistaController.obtenerRoles(equipoSeleccionado);
            rolCB.removeAllItems();
            rolCB.addItem("Seleccione un rol");
            for (int i = 0; i < rolesDisponibles.size(); i++) {
                rolCB.insertItemAt(rolesDisponibles.get(i), i + 1);
            }
        }
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

            String nickname = nicknameTF.getText();
            if (nickname.isEmpty()) {
                throw new CampoObligatorioException("El nickname es un campo obligatorio");
            }

            if (VistaController.buscarNickname(nickname)) {
                throw new NombreDuplicadoExcepcion("El nickname ya existe");
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

            String rol = (String) rolCB.getSelectedItem();
            if (rol == null || rol.isEmpty()) {
                throw new CampoObligatorioException("El rol es un campo obligatorio");
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

            String equipo = equiposCB.getSelectedItem().toString();
            if (equipo == null || equipo.equals("Selecciona un equipo")) {
                throw new CampoObligatorioException("Debes seleccionar un equipo");
            }
            if (VistaController.inscribirJugador(nombre, apellido, nacionalidad, fecha, nickname, sueldoFloat, rol, equipo)){
                JOptionPane.showMessageDialog(contentPane,"Se ha inscrito correctamente el jugador","Alerta",JOptionPane.INFORMATION_MESSAGE);
                switch (JOptionPane.showConfirmDialog(contentPane,"Desea inscribir otro jugador?","Pregunta",JOptionPane.YES_NO_OPTION)){
                    case 0:
                        nombreTF.setText(null);
                        fechaTF.setText(null);
                        nicknameTF.setText(null);
                        sueldoTF.setText(null);
                        rolCB.setSelectedIndex(0);
                        nacionalidadTf.setText(null);
                        apellidoTf.setText(null);
                        equiposCB.setSelectedIndex(0);
                        break;
                    case 1:
                        dispose();
                        break;
                }
            }

            // Aquí podrías continuar con el guardado o lógica del jugador...

        } catch (CampoObligatorioException e) {
            JOptionPane.showMessageDialog(contentPane, "ERROR: " + e.getMessage());
        } catch (NombreDuplicadoExcepcion e) {
            JOptionPane.showMessageDialog(contentPane, "ERROR: " + e.getMessage());
        } catch (FormatoIncorrectoException e) {
            JOptionPane.showMessageDialog(contentPane, "ERROR: " + e.getMessage());
        }catch (DateTimeParseException e){
            JOptionPane.showMessageDialog(contentPane,"Error: Fecha con formato invalido");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(contentPane, "ERROR inesperado: " + e.getMessage());
        }
    }

}

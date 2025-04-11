package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


    public VentanaInscribirJugadores(JFrame ventana) {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Inscribir Equipo");
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);

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
        equiposCB.addItem("Selecciona un equipo");
        for (int i = 0; i < listaEquipos.size(); i++) {
            equiposCB.insertItemAt(listaEquipos.get(i), i + 1);
        }

        equiposCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRoles();
            }
        });
    }

    private void actualizarRoles() {
        String equipoSeleccionado = (String) equiposCB.getSelectedItem();
        if (equipoSeleccionado != null && !equipoSeleccionado.equals("Selecciona un equipo")) {
            List<String> rolesDisponibles = VistaController.obtenerRoles(equipoSeleccionado);
            rolCB.removeAllItems();
            for (String rol : rolesDisponibles) {
                rolCB.addItem(rol);
            }
        }
    }

    private void onOK() {
        String nombre = nombreTF.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El nombre es un campo obligatorio");
        }

        String apellido = apellidoTf.getText();
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El apellido es un campo obligatorio");

        }

        String nacionalidad = nacionalidadTf.getText();
        if (nacionalidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: La nacionalidad es un campo obligatorio");
        }
        boolean existe = validarNacionalidad(nacionalidad);
        if (existe = false){
            JOptionPane.showMessageDialog(null, "ERROR: La nacionalidad no es correcta");
        }
        String nickname = nicknameTF.getText();
        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El nickname es un campo obligatorio");

        }

        if (VistaController.buscarNickname(nickname)) {
            JOptionPane.showMessageDialog(null, "ERROR: El nickname ya existe");

        }

        LocalDate fecha = null;
        try {
            fecha = LocalDate.parse(fechaTF.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (fechaTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: La fecha es un campo obligatorio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: Formato de fecha incorrecto (dd/MM/yyyy)");
        }

        int añonacimiento = fecha.getYear();
        int añoactual = LocalDate.now().getYear();
        if (añoactual - añonacimiento < 13) {
            JOptionPane.showMessageDialog(null, "ERROR: El jugador debe de tener 13 años como mínimo");
        }

        String rol = (String) rolCB.getSelectedItem();
        if (rol == null || rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El rol es un campo obligatorio");
            return;
        }

        String sueldo = sueldoTF.getText();
        float sueldoFloat = Float.parseFloat(sueldo);
        if (sueldo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El sueldo es un campo obligatorio");
            return;
        }
        try{


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: El sueldo debe ser un número válido");
            return;
        }

        if (sueldoFloat < 1184) {
            JOptionPane.showMessageDialog(null, "ERROR: El sueldo debe ser igual o superior al SMI (1184€)");
            return;
        }

        String equipo = (String) equiposCB.getSelectedItem();
        int equipoSeleccionado = Integer.parseInt(equipo);
        if (equipo == null || equipo.equals("Selecciona un equipo")) {
            JOptionPane.showMessageDialog(null, "ERROR: Debes seleccionar un equipo");
            return;
        }
        VistaController.inscribirJugador(nombre, apellido, nacionalidad, fecha, nickname, sueldoFloat, rol, equipoSeleccionado);
    }
    public static boolean validarNacionalidad(String nacionalidad) {
        String[] paises = Locale.getISOCountries();
        return Arrays.stream(paises)
                .map(codigo -> new Locale("", codigo).getDisplayCountry())
                .anyMatch(nombre -> nombre.equalsIgnoreCase(nacionalidad));
    }
}

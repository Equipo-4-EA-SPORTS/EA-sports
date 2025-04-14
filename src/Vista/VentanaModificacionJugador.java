package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class VentanaModificacionJugador extends JFrame {
    private JRadioButton nuevoNombreRadioButton;
    private JRadioButton nuevoApellidoRadioButton;
    private JTextField nuevoNombre;
    private JTextField nuevoApellido;
    private JComboBox equiposCB;
    private JComboBox rolesCB;
    private JTextField NuevaNacionalidad;
    private JTextField nuevoNickName;
    private JTextField NuevoSueldo;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton nuevaNacionalidadRB;
    private JTextField nuevaFecha;
    private JPanel panel;
    private JRadioButton nuevaFechaRB;
    private JRadioButton nuevoNickNameRB;
    private JRadioButton nuevoSueldoRB;
    private JLabel nuevoEquipoAB;
    private JLabel nuevoRolAB;
    private JComboBox jugadorCB;
    private JPanel JPanel;
    private JLabel jugadorAB;

    public VentanaModificacionJugador() {
        setTitle("Modificar Jugador");
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);

        setResizable(false);
        setSize(500, 450);
        add(panel);

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

        panel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setVisible(true);
        //Obtener la lista de los equipos dispoibles para llenar la Combo Box
        List<String> listaEquipos = VistaController.listaEquipos();
        equiposCB.addItem("Selecciona un equipo");
        for (int i = 0; i < listaEquipos.size(); i++) {
            equiposCB.insertItemAt(listaEquipos.get(i), i + 1);
        }

        //Obtener la lista de los jugadores dispoibles para llenar la Combo Box
        List<String> listajugadores =  VistaController.listaJugadores();
        jugadorCB.addItem("Selecciona un jugador");
        for (int i = 0; i < listajugadores.size(); i++) {
            jugadorCB.insertItemAt(listajugadores.get(i), i + 1);
        }



        equiposCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRoles();
            }
        });

        setVisible(true);
        nuevoNombreRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (nuevoNombreRadioButton.isSelected()){
                    nuevoNombre.setEditable(true);
                }
                else {
                    nuevoNombre.setEditable(false);
                }
            }
        });
        nuevoApellidoRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (nuevoApellidoRadioButton.isSelected()){
                    nuevoApellido.setEditable(true);
                }
                else {
                    nuevoApellido.setEditable(false);
                }
            }
        });
        nuevaFechaRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (nuevaFechaRB.isSelected()){
                    nuevaFecha.setEditable(true);
                }
                else {
                    nuevaFecha.setEditable(false);
                }
            }
        });
        nuevaNacionalidadRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (nuevaNacionalidadRB.isSelected()){
                    NuevaNacionalidad.setEditable(true);
                }
                else {
                    NuevaNacionalidad.setEditable(false);
                }
            }
        });
        nuevoNickNameRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (nuevoNickNameRB.isSelected()){
                    nuevoNickName.setEditable(true);
                }
                else {
                    nuevoNickName.setEditable(false);
                }
            }
        });
        nuevoSueldoRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (nuevoSueldoRB.isSelected()){
                    NuevoSueldo.setEditable(true);
                }
                else {
                    NuevoSueldo.setEditable(false);
                }
            }
        });
    }
    private void actualizarRoles() {
        String equipoSeleccionado = (String) equiposCB.getSelectedItem();
        if (equipoSeleccionado != null && !equipoSeleccionado.equals("Selecciona un equipo")) {
            List<String> rolesDisponibles = VistaController.obtenerRoles(equipoSeleccionado);
            rolesCB.removeAllItems();
            for (String rol : rolesDisponibles) {
                rolesCB.addItem(rol);
            }
        }
    }

    private void onOK() {
        String nombre = nuevoNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El nombre es un campo obligatorio");
        }

        String apellido = nuevoApellido.getText();
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El apellido es un campo obligatorio");

        }

        String nacionalidad = NuevaNacionalidad.getText();
        if (nacionalidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: La nacionalidad es un campo obligatorio");
        }
        boolean existe = validarNacionalidad(nacionalidad);
        if (existe == false){
            JOptionPane.showMessageDialog(null, "ERROR: La nacionalidad no es correcta");
        }
        String nickname = nuevoNickName.getText();
        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El nickname es un campo obligatorio");

        }

        if (VistaController.buscarNickname(nickname)) {
            JOptionPane.showMessageDialog(null, "ERROR: El nickname ya existe");

        }

        LocalDate fecha = null;
        try {
            fecha = LocalDate.parse(nuevaFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (nuevaFecha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: La fecha es un campo obligatorio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: Formato de fecha incorrecto (dd/MM/yyyy)");
        }
        try {
            int añonacimiento = fecha.getYear();
            int añoactual = LocalDate.now().getYear();
            if (añoactual - añonacimiento < 13) {
                JOptionPane.showMessageDialog(null, "ERROR: El jugador debe de tener 13 años como mínimo");
            }
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"ERRO: La fecha es un campo obligatorio");
        }
        String rol = (String) rolesCB.getSelectedItem();
        if (rol == null || rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El rol es un campo obligatorio");
            return;
        }

        String sueldo = NuevoSueldo.getText();
        float sueldoFloat = Float.parseFloat(sueldo);
        if (sueldo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El sueldo es un campo obligatorio");
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
        VistaController.modificarJugador(nombre, apellido, nacionalidad, fecha, nickname, sueldoFloat, rol, equipoSeleccionado);
    }

    public static boolean validarNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.trim().isEmpty()) {
            return false;
        }

        String[] paises = Locale.getISOCountries();
        String input = nacionalidad.trim().toLowerCase();

        return Arrays.stream(paises)
                .anyMatch(codigo -> {
                    Locale locale = new Locale("", codigo);
                    return locale.getDisplayCountry(Locale.ENGLISH).equalsIgnoreCase(input) ||
                            locale.getDisplayCountry(Locale.FRENCH).equalsIgnoreCase(input) ||
                            locale.getDisplayCountry(new Locale("es")).equalsIgnoreCase(input);
                });
    }

    public static void main(String[] args) {
        VentanaModificacionJugador v = new VentanaModificacionJugador();
        v.setVisible(true);
    }
}

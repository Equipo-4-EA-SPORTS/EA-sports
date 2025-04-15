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
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        if (nuevoNombreRadioButton.isSelected()) {
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: El nombre es un campo obligatorio");
                return;
            }
        } else {
            nombre = null;
        }

        String apellido = nuevoApellido.getText();
        if (nuevoApellidoRadioButton.isSelected()) {
            if (apellido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: El apellido es un campo obligatorio");
                return;
            }
        } else {
            apellido = null;
        }

        String nacionalidad = NuevaNacionalidad.getText();
        if (nuevaNacionalidadRB.isSelected()) {
            if (nacionalidad.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: La nacionalidad es un campo obligatorio");
                return;
            }
            if (!validarNacionalidad(nacionalidad)) {
                JOptionPane.showMessageDialog(null, "ERROR: La nacionalidad no es correcta");
                return;
            }
        } else {
            nacionalidad = null;
        }

        String nickname = nuevoNickName.getText();
        if (nuevoNickNameRB.isSelected()) {
            if (nickname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: El nickname es un campo obligatorio");
                return;
            }
            if (VistaController.buscarNickname(nickname)) {
                JOptionPane.showMessageDialog(null, "ERROR: El nickname ya existe");
                return;
            }
        } else {
            nickname = null;
        }

        LocalDate fecha = null;
        if (nuevaFechaRB.isSelected()) {
            String textoFecha = nuevaFecha.getText();
            if (textoFecha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: La fecha es un campo obligatorio");
                return;
            }
            try {
                fecha = LocalDate.parse(textoFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int edad = LocalDate.now().getYear() - fecha.getYear();
                if (edad < 13) {
                    JOptionPane.showMessageDialog(null, "ERROR: El jugador debe de tener 13 años como mínimo");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR: Formato de fecha incorrecto (dd/MM/yyyy)");
                return;
            }
        }

        String sueldoTexto = NuevoSueldo.getText();
        float sueldoFloat = -1;
        if (nuevoSueldoRB.isSelected()) {
            if (sueldoTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: El sueldo es un campo obligatorio");
                return;
            }
            try {
                sueldoFloat = Float.parseFloat(sueldoTexto);
                if (sueldoFloat < 1184) {
                    JOptionPane.showMessageDialog(null, "ERROR: El sueldo debe ser igual o superior al SMI (1184€)");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: El sueldo debe ser un número válido");
                return;
            }
        }

        String equipo = (String) equiposCB.getSelectedItem();
        if (equipo == null || equipo.equals("Selecciona un equipo")) {
            JOptionPane.showMessageDialog(null, "ERROR: Debes seleccionar un equipo");
            return;
        }

        String rol = (String) rolesCB.getSelectedItem();
        if (rol == null || rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El rol es un campo obligatorio");
            return;
        }

        int equipoSeleccionado;
        try {
            equipoSeleccionado = Integer.parseInt(equipo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: El equipo seleccionado no es válido");
            return;
        }

        VistaController.modificarJugador(nombre, apellido, nacionalidad, fecha, nickname, sueldoFloat, rol, equipoSeleccionado);
    }


    public static boolean validarNacionalidad(String nacionalidad) {
        List<String> gentilicios = new ArrayList<>();
        gentilicios.add("francesa");
        gentilicios.add("italiana");
        gentilicios.add("alemana");
        gentilicios.add("china");
        gentilicios.add("marroquí");
        gentilicios.add("rumana");
        gentilicios.add("colombiana");
        gentilicios.add("venezolana");
        gentilicios.add("argentina");
        gentilicios.add("peruana");
        gentilicios.add("ecuatoriana");
        gentilicios.add("boliviana");
        gentilicios.add("paraguaya");
        gentilicios.add("chilena");
        gentilicios.add("ucraniana");
        gentilicios.add("portuguesa");
        gentilicios.add("nigeriana");
        gentilicios.add("brasileña");
        gentilicios.add("hondureña");
        gentilicios.add("dominicana");
        gentilicios.add("cubana");
        gentilicios.add("paquistaní");
        gentilicios.add("nepalí");
        gentilicios.add("bangladesí");
        gentilicios.add("senegalesa");
        gentilicios.add("senegalés");
        gentilicios.add("maliense");
        gentilicios.add("guineana");
        gentilicios.add("argelina");
        gentilicios.add("saharaui");
        gentilicios.add("sahariana");

        if (gentilicios.contains(nacionalidad.toLowerCase())) {
            return true;
        }else {return false;}
    }

    public static void main(String[] args) {
        VentanaModificacionJugador v = new VentanaModificacionJugador();
        v.setVisible(true);
    }
}

package Vista;

import Excepciones.CampoObligatorioException;
import Excepciones.FechaInvalidaException;
import Modelo.Enfrentamiento;
import Modelo.Equipo;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ventanaCrearEnfrentamiento extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JTextField tfFecha;
    private JTextField tfHora;
    private List<Equipo> listaEquipos;


    public ventanaCrearEnfrentamiento() {
        this.listaEquipos = listaEquipos;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws Exception {
        crearEnfrentamiento();
    }

    private void onCancel() {
        dispose();
    }

    private void crearEnfrentamiento() throws Exception {
        try {
            int jornadaSeleccionada = comboBox1.getSelectedIndex();

            // Validar fecha y hora
            String fecha = tfFecha.getText();
            String hora = tfHora.getText();
            if (fecha.isEmpty() || hora.isEmpty()) {
                throw new CampoObligatorioException();
            }

            // Convertir fecha a Localdate
            LocalDate fechaSeleccionada = convertirStringAFecha(fecha);

            // Verificar si la fecha está dentro del rango de la jornada seleccionada
            /*if (fechaSeleccionada.isBefore(jornada.getFechaInicio()) || fechaSeleccionada.isAfter(jornada.getFechaFin())) {
                throw new FechaInvalidaException();
            }*/

            // Asegurarse de que el número de equipos sea par y al menos 2
            if (listaEquipos.size() < 2) {
                JOptionPane.showMessageDialog(this, "Debe haber al menos 2 equipos para crear enfrentamientos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (listaEquipos.size() % 2 != 0) {
                JOptionPane.showMessageDialog(this, "Debe haber un número par de equipos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear enfrentamientos aleatorios
            Collections.shuffle(listaEquipos);
            List<Enfrentamiento> enfrentamientos = new ArrayList<>();
            for (int i = 0; i < listaEquipos.size(); i += 2) {
                Equipo equipo1 = listaEquipos.get(i);
                Equipo equipo2 = listaEquipos.get(i + 1);
                Enfrentamiento enfrentamiento = new Enfrentamiento(
                        generarIdEnfrentamiento(),
                        equipo1,
                        equipo2,
                        fechaSeleccionada.toString() // Usar la fecha en formato de String (ISO)
                );
                enfrentamientos.add(enfrentamiento);
            }

            JOptionPane.showMessageDialog(this, "Enfrentamientos creados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (CampoObligatorioException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una fecha y una hora", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FechaInvalidaException e) {
            JOptionPane.showMessageDialog(this, "La fecha y hora deben estar dentro de la jornada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Convertir la fecha de String a LocalDate usando DateTimeFormatter
    private LocalDate convertirStringAFecha(String fecha) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(fecha, formatter);
        } catch (Exception e) {
            throw new Exception("Fecha inválida");
        }
    }

    private static int generarIdEnfrentamiento() {
        return (int) (Math.random() * 10000);
    }
}
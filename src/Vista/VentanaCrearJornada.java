package Vista;

import Controlador.VistaController;
import Excepciones.FechaInvalidaException;
import Modelo.Jornada;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class VentanaCrearJornada extends JFrame {
    private JPanel contentPane;
    private JButton buttonAceptar;
    private JButton buttonCancelar;
    private JTextField tfFechaInicio;

    public VentanaCrearJornada(JFrame ventana) {
        setContentPane(contentPane);
        setTitle("Crear Jornada");
        setSize(400, 250);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonAceptar);

        buttonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearJornada();
            }
        });

        buttonCancelar.addActionListener(new ActionListener() {
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

    private void onCancel() {
        dispose();
    }

    private void crearJornada() {
        try {
            // Validar la fecha de inicio
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaInicio = LocalDate.parse(tfFechaInicio.getText(), formatter);

            // Validar que la fecha de inicio sea válida
            if (fechaInicio.isBefore(LocalDate.now())) {
                throw new FechaInvalidaException();
            }

            // Calcular la fecha fin (una semana después de la fecha de inicio)
            LocalDate fechaFin = fechaInicio.plus(1, ChronoUnit.WEEKS);

            // Crear la jornada con la fecha de inicio y la fecha de fin generada
            boolean jornadaCreada = VistaController.crearJornada(fechaInicio);
            tfFechaInicio.setText(""); // Vaciar el campo de texto

            if (jornadaCreada) {
                JOptionPane.showMessageDialog(this, "Jornada creada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al crear la jornada.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (FechaInvalidaException ex) {
            JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser anterior a la fecha actual.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Usa dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
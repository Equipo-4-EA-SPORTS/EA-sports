package Modelo;

import javax.swing.*;

public class DatePickerSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Seleccionar Fecha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // Crear un modelo de fechas
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);

        // Personalizar el formato de fecha
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);

        frame.getContentPane().add(spinner);
        frame.setVisible(true);
    }
}

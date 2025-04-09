package Vista;

import Controlador.VistaController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class VentanaMostrarEquipos extends JDialog {
    private JPanel contentPane;
    private JButton bCerrar;
    private JTable tablaEquipos;

    public VentanaMostrarEquipos() {
        setContentPane(contentPane);
        setModal(true);
        setSize(400,250);
        setLocationRelativeTo(null);

        // Configurar columnas
        String[] columnas = {"Nombre", "Fecha de Fundación"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Obtener lista de equipos desde el controlador
        List<String[]> listaEquipos = VistaController.obtenerEquiposConFechas();

        // Rellenar tabla
        for (String[] fila : listaEquipos) {
            modelo.addRow(fila);
        }

        tablaEquipos.setModel(modelo);
        tablaEquipos.setEnabled(false); // Para que no se pueda editar

        bCerrar.addActionListener(new ActionListener() {
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
        // add your code here if necessary
        dispose();
    }

}

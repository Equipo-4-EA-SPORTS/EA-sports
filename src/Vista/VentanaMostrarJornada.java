package Vista;

import Controlador.VistaController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.List;

public class VentanaMostrarJornada extends JDialog {
    private JPanel contentPane;
    private JButton bCerrar;
    private JTable tablaJornadas;

    public VentanaMostrarJornada() {
        setContentPane(contentPane);
        setModal(true);
        setSize(400,250);
        setLocationRelativeTo(null);

        //Config columnas
        String[] columnas = {"Numero de jornada", "Fecha de inicio", "Fecha de fin"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        //obtener lista de jornadas desde el controlador
        List<String[]> listaJornadas = VistaController.obtenerJornadas();

        //rellenar tabla
        for (String[] fila : listaJornadas) {
            modelo.addRow(fila);
        }

        tablaJornadas.setModel(modelo);
        tablaJornadas.setEnabled(false);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tablaJornadas.setRowSorter(sorter);

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
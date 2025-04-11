package Vista;

import Controlador.VistaController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.List;

public class VentanaMostrarJugadores extends JDialog {
    private JPanel pPrincipal;
    private JButton bCerrar;
    private JTable tablaJugadores;

    public VentanaMostrarJugadores() {
        setContentPane(pPrincipal);
        setModal(true);
        setSize(800,400);
        setLocationRelativeTo(null);

        // Configurar columnas
        String[] columnas = {"Nombre", "Apellido","Nacionalidad","FechaNacimiento","Nickname","Sueldo","Rol","IdEquipo"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Obtener lista de equipos desde el controlador
        List<String[]> listaJugadores = VistaController.obtenerJugadores();

        // Rellenar tabla
        for (String[] fila : listaJugadores) {
            modelo.addRow(fila);
        }

        tablaJugadores.setModel(modelo);
        tablaJugadores.setEnabled(false); // Para que no se pueda editar

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tablaJugadores.setRowSorter(sorter);

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
        pPrincipal.registerKeyboardAction(new ActionListener() {
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

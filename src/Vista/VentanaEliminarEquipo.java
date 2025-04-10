package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class VentanaEliminarEquipo extends JDialog {
    private JPanel contentPane;
    private JComboBox cbEquipos;
    private JButton bBorrarEquipo;
    private JButton bCancel;

    public VentanaEliminarEquipo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bBorrarEquipo);
        setSize(575,150);
        setLocationRelativeTo(null);

        List<String> listaEquipos = VistaController.listaEquipos();

        cbEquipos.addItem("Haz click para descubrir las opciones");
        for (int i = 0; i < listaEquipos.size(); i++) {
            cbEquipos.insertItemAt(listaEquipos.get(i),i+1);
        }



        bBorrarEquipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        bCancel.addActionListener(new ActionListener() {
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

    private void onOK() {
        String equipoSeleccionado = (String) cbEquipos.getSelectedItem();

        if (equipoSeleccionado != null && !equipoSeleccionado.equals("Haz click para descubrir las opciones")) {

            if (VistaController.ventanaConfirmacion("equipo")) {
                boolean eliminado = VistaController.eliminarEquipo(equipoSeleccionado);

                if (eliminado) {
                    JOptionPane.showMessageDialog(contentPane, "Equipo eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Cierra la ventana
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Error al eliminar el equipo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(contentPane, "Selecciona un equipo válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
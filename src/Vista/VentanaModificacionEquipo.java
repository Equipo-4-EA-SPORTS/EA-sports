package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaModificacionEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox equipos;
    private JTextField nuevoNombre;
    private JTextField nuevaFecha;
    private JRadioButton nuevoNombreRadioButton;
    private JRadioButton nuevaFechaDeFundacionRadioButton;

    public VentanaModificacionEquipo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        List<String> listaEquipos = VistaController.listaEquipos();
        System.out.println(listaEquipos);
        equipos.addItem("Haz click para descubrir las opciones");
        if (listaEquipos.size()>0) {
            System.out.println("hola");
            for (int i = 0; i < listaEquipos.size(); i++) {
                System.out.println("adios");
                equipos.insertItemAt(listaEquipos.get(i),i+1);
            }
        }
        else {
            JOptionPane.showMessageDialog(contentPane, "Error. No hay equipos para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VentanaModificacionEquipo dialog = new VentanaModificacionEquipo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

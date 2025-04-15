package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ventanaEliminarEnfrentamiento extends JDialog {
    private JPanel contentPane;
    private JButton bOk;
    private JButton bCancel;
    private JComboBox cbEnfrentamientos;
    private JButton bBorrarEnfrent;
    private JTextField fechaTF;
    private JTextField horaTF;
    private JLabel horaAB;
    private JLabel fechaAB;

    public ventanaEliminarEnfrentamiento() {
        setSize(500, 300);
        setLocationRelativeTo(null);
        setTitle("Eliminar Enfrentamiento");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bOk);

        bOk.addActionListener(new ActionListener() {
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
        VistaController vc  = new VistaController();
        ArrayList<Integer> id_enfrentamientos = vc.obtenerEnfrentamientos();
        for (int i = 0; i < id_enfrentamientos.size(); i++) {
            cbEnfrentamientos.addItem(id_enfrentamientos.get(i));
        }

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}

package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;



public class VentanaEliminarJugador extends JDialog{
    private JPanel pPrincipal;
    private JComboBox cbJugadores;
    private JButton bCancel;
    private JButton bBorrarJugador;

    public VentanaEliminarJugador() {
        setContentPane(pPrincipal);
        setModal(true);
        getRootPane().setDefaultButton(bBorrarJugador);
        setSize(575,200);
        setLocationRelativeTo(null);

        List<String> listaJugadores = VistaController.listaJugadores();

        cbJugadores.addItem("Haz click para descubrir las opciones");
        for (int i = 0; i < listaJugadores.size(); i++) {
            cbJugadores.insertItemAt(listaJugadores.get(i),i+1);
        }

        bBorrarJugador.addActionListener(new ActionListener() {
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
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String jugadorSeleccionado = (String) cbJugadores.getSelectedItem();

        if (jugadorSeleccionado != null && !jugadorSeleccionado.equals("Haz click para descubrir las opciones")) {

            if (VistaController.ventanaConfirmacion("jugador")) {
                boolean eliminado = VistaController.eliminarJugador(jugadorSeleccionado);

                if (eliminado) {
                    JOptionPane.showMessageDialog(pPrincipal, "Jugador eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Cierra la ventana
                } else {
                    JOptionPane.showMessageDialog(pPrincipal, "Error al eliminar el jugador.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(pPrincipal, "Selecciona un jugador válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}

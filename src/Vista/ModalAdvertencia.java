package Vista;

import javax.swing.*;
import java.awt.event.*;

public class ModalAdvertencia extends JDialog {
    private JPanel pPrincipal;
    private JButton button1;
    private JButton eliminarButton;
    private JButton cancelarButton;
    private boolean confirmado = false;

    public ModalAdvertencia() {
        setContentPane(pPrincipal);
        setModal(true);
        getRootPane().setDefaultButton(eliminarButton);

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    public boolean isConfirmado() {
        return confirmado;
    }
    public static void main(String[] args) {
        ModalAdvertencia dialog = new ModalAdvertencia();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

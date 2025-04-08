package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InicioComUsuar extends JFrame {
    private JPanel Pprincipal;
    private JTextField tfUsuario;
    private JTextField tfContrase;
    private JButton bIniciar;
    private JCheckBox checkRecord;
    private static VistaController vc = new VistaController();

    public InicioComUsuar() {
        bIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vc.mostrarPanelUsuario(); //nombre de la siguiente vista
            }
        });
    }
}

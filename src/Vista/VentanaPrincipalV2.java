package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipalV2 extends javax.swing.JFrame {
    private JButton button1;
    private JButton comenzarButton;
    private JPanel pPrincipal;

    public VentanaPrincipalV2() {
        setContentPane(pPrincipal);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ventana Principal");
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Vista/Fotos/FaviconEA.png"));
        setIconImage(imagen.getImage());
        comenzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.VentanaSelccionUsuarioV2(VentanaPrincipalV2.this);
            }
        });
    }

    public static void main(String[] args) {
        VentanaPrincipalV2 ventana = new VentanaPrincipalV2();
        ventana.setVisible(true);
    }
}

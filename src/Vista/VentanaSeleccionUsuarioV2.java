package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaSeleccionUsuarioV2 extends JFrame{
    private JButton usuario;
    private JButton administrador;
    private JButton helpUsuario;
    private JButton helpAdministrador;
    private JPanel pPrincipal;

    public VentanaSeleccionUsuarioV2() {

        setContentPane(pPrincipal);
        pack();
        setLocationRelativeTo(null);
        setTitle("¡Bienvenido! Seleccione un tipo de usuario");

        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                usuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
                administrador.setCursor(new Cursor(Cursor.HAND_CURSOR));
                helpUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
                helpAdministrador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        };
    }

    public static void main(String[] args){
        VentanaSeleccionUsuarioV2 vsu2 = new VentanaSeleccionUsuarioV2();
        vsu2.setVisible(true);
    }
}

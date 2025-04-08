package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaUsuario extends JFrame {
    private JPanel pPrincipal;

    public VentanaUsuario(String nombre) {
        setContentPane(pPrincipal);
        setTitle("Usuario");
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(400,200);

        JMenuBar menuBar = new JMenuBar();

        JMenu Jusuario = new JMenu("Usuario");
        JMenu JotrasOpciones = new JMenu("Otras opciones");

        JMenuItem Jnombre = new JMenuItem(nombre);
        JMenuItem JcambiarUsuario = new JMenuItem("Cambiar de Usuario");
        JMenuItem Jsalir = new JMenuItem("Salir");

        Jusuario.add(Jnombre);
        Jusuario.add(JcambiarUsuario);
        JotrasOpciones.add(Jsalir);

        Jnombre.setEnabled(false);

        menuBar.add(Jusuario);
        menuBar.add(JotrasOpciones);

        setJMenuBar(menuBar);

        JcambiarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.mostrarinicioSesion(VentanaUsuario.this);
            }
        });

    }
}

package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaGestionCompeticionV2 extends JFrame{
    private JPanel panel1;
    private JButton abrirCompe;
    private JButton retroceder;
    private JButton cerrarCompe;

    public VentanaGestionCompeticionV2(String nombre) {
        setContentPane(panel1);
        setTitle("Gestion de Competición");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Vista/Fotos/FaviconEA.png"));
        setIconImage(imagen.getImage());

        boolean compeAbierta = VistaController.estadoCompeticion();

        if (VistaController.verificarCompeticionCreada() > 0){
            if (compeAbierta){
                abrirCompe.setEnabled(false);
            }
            else {
                cerrarCompe.setEnabled(false);
            }
            cerrarCompe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (VistaController.ModalConfirmarCerrarCompeV2()){
                        VistaController.cerrarCompeticion();
                    }
                }
            });
        }
        else {
            abrirCompe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VistaController.abrirCompeticion();
                }
            });
        }


        abrirCompe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                abrirCompe.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        cerrarCompe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cerrarCompe.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        retroceder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                retroceder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.VentanaAdministradorV2(nombre,VentanaGestionCompeticionV2.this);
            }
        });
    }
    public static void  main(String[] args){
        VentanaGestionCompeticionV2 va = new VentanaGestionCompeticionV2("admin1");
        va.setVisible(true);
    }
}

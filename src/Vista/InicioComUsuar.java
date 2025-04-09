package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InicioComUsuar extends JFrame {
    private JPanel pPrincipal;
    private JTextField tfUsuario;
    private JPasswordField tfContrase;
    private JButton bIniciar;
    private JCheckBox checkRecord;
    private JLabel textoTitulo;
    private static VistaController vc = new VistaController();

    public InicioComUsuar(String tipoUsr) {
        setTitle("Inicio Com Usuario normal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pPrincipal);
        setResizable(false);

        textoTitulo.setText("INICIO COMO " + tipoUsr);

        switch (tipoUsr) {
            case "ADMINISTRADOR":
                setSize(375,200);
                break;
            case "USUARIO":
                setSize(300,200);
                break;
        }
        setLocationRelativeTo(null);


        bIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfUsuario.getText().equals("") || tfContrase.getText().equals("")) {
                    JOptionPane.showMessageDialog(pPrincipal,"ERROR, todos los campos son obligatorios");
                }
                else {
                    if (VistaController.inciarSesionUsuario(tfUsuario.getText(),tfContrase.getText(),tipoUsr)){
                        switch (tipoUsr){
                            case "ADMINISTRADOR":
                                VistaController.ventanaAdministrador(InicioComUsuar.this,tfUsuario.getText());
                                break;
                            case "USUARIO":
                                break;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(pPrincipal, "Usuario o Contraseña incorrectas","Error",JOptionPane.ERROR_MESSAGE);
                        tfUsuario.setText("");
                        tfContrase.setText("");
                    }
                }
            }
        });
    }
}

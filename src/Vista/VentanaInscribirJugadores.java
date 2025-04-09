package Vista;

import Controlador.VistaController;
import Excepciones.CampoObligatorioException;
import Excepciones.EquipoExistenteException;
import Excepciones.FechaInvalidaException;
import Modelo.Jugador;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VentanaInscribirJugadores extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nombreTF;
    private JPanel panelSpinner;
    private JTextField apellidoTF;
    private JTextField nacionalidadTF;
    private JTextField fechaTF;
    private JTextField nicknameTF;
    private JTextField sueldoTF;

    public VentanaInscribirJugadores(JFrame ventana) {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Inscribir Equipo");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK()  {
        String nombre = nombreTF.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El nombre es un campo obligatorio");
        }
        String apellido = apellidoTF.getText();
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: El apellido es un campo obligatorio");
        }
        //TODO VALIDAR NACIONALIDAD?¿?¿?¿?¿?¿
        String nacionalidad = nacionalidadTF.getText();
        if (nacionalidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: La nacionalidad es un campo obligatorio");
        }
//VALIDACIOND DE LA FECHA
        String nickname = nicknameTF.getText();
        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(null, " ERROR: El nickname es un campo obligatorio");
        }
        String sueldo  = sueldoTF.getText();
        if (sueldo.isEmpty()) {
            JOptionPane.showMessageDialog(null, " ERROR: El sueldo es un campo obligatorio");
        }
         float sueldoFloat = Float.parseFloat(sueldo);
        if (sueldoFloat < 1184){
            JOptionPane.showMessageDialog(null, " ERROR: El sueldo debe de ser igual o superior al SMI (1184€) ");
        }

        /* Si pasa las validaciones se manda a insertar */


        //VistaController.inscribirJugador(nombre, apellido, nacionalidad, fechaParseada, nickname, sueldoFloat);

    }



        private void onCancel() {dispose();}


}




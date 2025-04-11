package Vista;

import Controlador.VistaController;
import Excepciones.CampoObligatorioException;
import Excepciones.EquipoExistenteException;
import Excepciones.FechaInvalidaException;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VentanaInscribirEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nombre;
    private JPanel panelSpinner;
    private JTextField fecha;


    private LocalDate fechaParseada;
    private LocalDate fechaMax = LocalDate.now();
    private LocalDate fechaMin = LocalDate.parse("02/06/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public VentanaInscribirEquipo(JFrame ventana) {
        setContentPane(contentPane);
        setModal(true);
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
    }

    private void onOK() {
        fechaParseada = LocalDate.parse(fecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        try{
            if(VistaController.buscarEquipo(nombre.getText())){
                throw new EquipoExistenteException();
            }
            if (nombre.getText().isEmpty()) {
                throw new CampoObligatorioException();
            }


            if (fechaParseada.isEqual(fechaMin) || fechaParseada.isEqual(fechaMax) || fechaParseada.isBefore(fechaMin) || fechaParseada.isAfter(fechaMax)) {
                throw new FechaInvalidaException();
            }
            VistaController.inscribirEquipo(nombre.getText(), fechaParseada);
            JOptionPane.showMessageDialog(contentPane, "El Equipo se ha ingresado correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            dispose();

        }catch(EquipoExistenteException e){
            JOptionPane.showMessageDialog(contentPane, "Ya existe un Equipo con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(CampoObligatorioException e){
            JOptionPane.showMessageDialog(contentPane, "Este campo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (FechaInvalidaException e){
            JOptionPane.showMessageDialog(contentPane,"Error, la fecha de fundacion no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (DateTimeParseException e){
            JOptionPane.showMessageDialog(contentPane,"Error, formato de fecha incorrecto pruebe con (dd/mm/yyyy)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }


}
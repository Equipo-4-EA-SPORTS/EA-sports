package Vista;

import Controlador.VistaController;
import Excepciones.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VentanaModificacionEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox equipos;
    private JTextField nuevoNombre;
    private JTextField nuevaFecha;
    private JRadioButton nuevoNombreRadioButton;
    private JRadioButton nuevaFechaDeFundacionRadioButton;

    private LocalDate fechaParseada;
    private LocalDate fechaMax = LocalDate.now();
    private LocalDate fechaMin = LocalDate.parse("02/06/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public VentanaModificacionEquipo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setResizable(false);
        setSize(500,250);
        setLocationRelativeTo(null);


        List<String> listaEquipos = VistaController.listaEquipos();
        equipos.addItem("Haz click para descubrir las opciones");
        for (int i = 0; i < listaEquipos.size(); i++) {
            equipos.insertItemAt(listaEquipos.get(i),i+1);
        }

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
        nuevoNombreRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (nuevoNombreRadioButton.isSelected()){
                    nuevoNombre.setEditable(true);
                }
                else {
                    nuevoNombre.setEditable(false);
                }
            }
        });
        nuevaFechaDeFundacionRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (nuevaFechaDeFundacionRadioButton.isSelected()){
                    nuevaFecha.setEditable(true);
                }
                else {
                    nuevaFecha.setEditable(false);
                }
            }
        });
    }

    private void onOK() {


        boolean actualizado = false;
        try{

            switch (equipos.getSelectedIndex()){
                case 0:
                    throw new OpcionIncorrectaException();
                default:
                    if (nuevoNombreRadioButton.isSelected() && nuevaFechaDeFundacionRadioButton.isSelected()){
                        if (nuevoNombre.getText().isEmpty() || nuevaFecha.getText().isEmpty()){
                            throw new CampoObligatorioException("Error: Los campos seleccionados son obligatorios");
                        }
                        fechaParseada = LocalDate.parse(nuevaFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        actualizado =  VistaController.modificarEquipo(nuevoNombre.getText(), fechaParseada,equipos.getItemAt(equipos.getSelectedIndex()).toString());
                    } else if (nuevoNombreRadioButton.isSelected()) {
                        if (nuevoNombre.getText().isEmpty()){
                            throw new CampoObligatorioException("Error: Los campos seleccionados son obligatorios");
                        }
                        actualizado = VistaController.modificarEquipo(nuevoNombre.getText(),equipos.getItemAt(equipos.getSelectedIndex()).toString());
                    } else if (nuevaFechaDeFundacionRadioButton.isSelected()) {
                        if (nuevaFecha.getText().isEmpty()){
                            throw new CampoObligatorioException("Error: Los campos seleccionados son obligatorios");
                        }
                        fechaParseada = LocalDate.parse(nuevaFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        actualizado = VistaController.modificarEquipo(fechaParseada,equipos.getItemAt(equipos.getSelectedIndex()).toString());
                    }else{
                        throw new OpcionSeleccionarObligatorioException();
                    }

                    if (actualizado){
                        JOptionPane.showMessageDialog(contentPane, "El Equipo se ha actualizado correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(contentPane,"No se ha podido actualizar el equipo","Error",-1);
                    }

            }
        }
        catch (CampoObligatorioException e){
            JOptionPane.showMessageDialog(contentPane,e.getMessage(),e.getMessage(),-1);
        }
        catch (OpcionSeleccionarObligatorioException e){
            JOptionPane.showMessageDialog(contentPane,"Error, debe seleccionar al menos un campo de los de abajo","Error",-1);

        }
        catch (OpcionIncorrectaException e){
            JOptionPane.showMessageDialog(contentPane,"Error, debes de seleccionar una opcion","Error",-1);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(contentPane,e.getMessage(),"Error",-1);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}

package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class BotonLimpiarListener implements ActionListener {

    private JLabel pantalla;

    public BotonLimpiarListener(JLabel pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        pantalla.setText("");

    }

}

package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import clases.Calculadora;

public class BotonBorrarListener implements ActionListener {

    private JLabel pantalla;

    public BotonBorrarListener(JLabel pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.pantalla.getText().isEmpty()) {
            return;
        }

        if (!this.pantalla.getText().equals(Calculadora.getMensajeError())) {
            int ultimoCaracter = this.pantalla.getText().length() - 1;

            this.pantalla.setText(this.pantalla.getText().substring(0, ultimoCaracter));
        }

    }

}

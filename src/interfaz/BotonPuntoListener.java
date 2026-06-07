package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import clases.Calculadora;

public class BotonPuntoListener implements ActionListener {

    private JLabel pantalla;

    public BotonPuntoListener(JLabel pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (pantalla.getText().isEmpty()) {
            return;
        } 

        int longitudTextoPantalla = this.pantalla.getText().length();
        boolean flag = false;
        int contador = 0;
        for (int i = longitudTextoPantalla - 1; i > 0 && !flag; i--) {

            String caracter = "" + this.pantalla.getText().charAt(i);

            if (!"+-*/".contains(caracter)) {
                contador++;
            } else {
                flag = true;
            }

        }

        boolean tienePunto = false;
        for (int j = 0; j < contador && !tienePunto; j++) {

            String caracter = "" + this.pantalla.getText().charAt(j);

            if (caracter.equals(".")) {
                tienePunto = true;
            }
        }

        String ultimoCaracter = pantalla.getText().substring(pantalla.getText().length() - 1);

        if (!"+-*/.".contains(ultimoCaracter) && !pantalla.getText().equals(Calculadora.getMensajeError()) && !tienePunto) {
            pantalla.setText(pantalla.getText() + ".");
        }

    }

}

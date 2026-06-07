package interfaz.botonesOperadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public abstract class BotonOperacionesListener implements ActionListener {

    protected JLabel pantalla;
    protected String operador;

    public BotonOperacionesListener(JLabel pantalla, String operador) {
        this.pantalla = pantalla;
        this.operador = operador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (pantalla.getText().isEmpty()) {
            if (permitePantallaVacia()) {
                pantalla.setText(this.operador);
            }
            return;
        }

        if (pantalla.getText().equals("Error")) {
            return;
        }

        String ultimoCaracter = pantalla.getText().substring(pantalla.getText().length() - 1);

        if (!operadoresNoPermitidos().contains(ultimoCaracter)) {
            pantalla.setText(pantalla.getText() + this.operador);
        }

    }

    protected boolean permitePantallaVacia() {
        return false;
    }

    protected String operadoresNoPermitidos() {
        return "+-*/";
    }

}
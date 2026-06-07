package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import clases.Calculadora;

public class BotonNumeroListener implements ActionListener {

    private JLabel pantalla;
    private JButton botonPulsado;

    public BotonNumeroListener(JLabel pantalla, JButton botonPulsado) {
        this.pantalla = pantalla;
        this.botonPulsado = botonPulsado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (pantalla.getText().contains(Calculadora.getMensajeError())) {
            pantalla.setText(botonPulsado.getText());
        } else {
            pantalla.setText(pantalla.getText() + "" + botonPulsado.getText());
        }
        
        

    }

}

package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import clases.Calculadora;
import clases.Pantalla;
import excepciones.DividirEntreCeroException;

public class BotonIgualListener implements ActionListener {

    private Pantalla pantalla;
    private JLabel textoPantalla;
    private Calculadora calculadora;

    public BotonIgualListener(Pantalla pantalla, JLabel textoPantalla, Calculadora calculadora) {
        this.pantalla = pantalla;
        this.textoPantalla = textoPantalla;
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.textoPantalla.getText().equals(Calculadora.getMensajeError())) {
            return;
        }

        pantalla.setOperacion(textoPantalla.getText());

        try {
            double resultadoNum = calculadora.calcularResultado(pantalla.traducir());

            textoPantalla.setText(calculadora.formatearResultado(resultadoNum));
        } catch (DividirEntreCeroException e1) {
            textoPantalla.setText(Calculadora.getMensajeErrorDivisionCero());
        } catch (Exception exception) {
            this.textoPantalla.setText(Calculadora.getMensajeError());
        }

    }

}

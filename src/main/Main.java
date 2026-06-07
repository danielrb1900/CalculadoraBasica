package main;

import clases.Calculadora;
import clases.Pantalla;
import interfaz.VentanaCalculadora;

public class Main {

    public static void main(String[] args) {
        
        Pantalla p = new Pantalla();
        Calculadora c = new Calculadora(p);

        VentanaCalculadora vc = new VentanaCalculadora(c, p);

        vc.setVisible(true);

    }

}

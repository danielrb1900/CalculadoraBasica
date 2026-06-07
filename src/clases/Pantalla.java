package clases;

import java.util.ArrayList;

public class Pantalla {

    private String operacion;

    public Pantalla() {
    }

    public Pantalla(String operacion) {
        this.operacion = operacion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    // Método que convierte la operación introducida en la pantalla en un arrayList.
    // Formato: {12 , +, 1, * 3}
    public ArrayList<String> traducir() {

        ArrayList<String> operaciones = new ArrayList<>();

        String numero = "";

        for (int i = 0; i < this.operacion.length(); i++) {

            if (esNumero(i)) {
                numero += this.operacion.charAt(i);

            } else {
                operaciones.add(numero); // Esto mete huecos vacíos (no siempre).
                numero = "";

                if (this.operacion.charAt(i) == '-') {
                    if (i == 0) {
                        numero += this.operacion.charAt(i);
                    } else if ("*/".contains("" + this.operacion.charAt(i - 1))) {
                        numero += this.operacion.charAt(i);
                    } else {
                        operaciones.add("" + this.operacion.charAt(i));
                    }
                } else {
                    operaciones.add("" + this.operacion.charAt(i));
                }
            }

        }

        operaciones.add(numero);
        operaciones.removeIf(String::isEmpty); // Limpio huecos vacíos

        return operaciones;

    }

    public boolean esNumero(int posicion) {

        String caracter = "" + this.operacion.charAt(posicion);
        String numeros = "0123456789."; // También meto el punto, porque el número puede tener decimales.

        return numeros.contains(caracter);

    }

}

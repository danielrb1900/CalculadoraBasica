package clases;

import java.util.ArrayList;

import excepciones.DividirEntreCeroException;

public class Calculadora {

    private Pantalla pantalla;

    private static final String MENSAJE_ERROR = "Error";
    private static final String MENSAJE_ERROR_DIVISION_CERO = "Indefinido";

    public Calculadora() {
    }

    public Calculadora(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public static String getMensajeError() {
        return MENSAJE_ERROR;
    }

    public static String getMensajeErrorDivisionCero() {
        return MENSAJE_ERROR_DIVISION_CERO;
    }

    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) throws DividirEntreCeroException {

        if (num2 == 0) {
            throw new DividirEntreCeroException(getMensajeErrorDivisionCero());
        }

        return num1 / num2;
    }

    public double calcularOperacion(double n1, String operador, double n2) throws DividirEntreCeroException {

        double resultado = 0;

        if (operador.equals("/")) {
            resultado = dividir(n1, n2);
        } else if (operador.equals("*")) {
            resultado = multiplicar(n1, n2);
        } else if (operador.equals("+")) {
            resultado = sumar(n1, n2);
        } else {
            resultado = restar(n1, n2);
        }

        return resultado;

    }

    public double calcularResultado(ArrayList<String> operaciones) throws DividirEntreCeroException {

        // Primera pasada: Multiplicaciones y Divisiones
        for (int i = 0; i < operaciones.size(); i++) {

            String operador = operaciones.get(i);

            if (operador.equals("*") || operador.equals("/")) {
                double num1 = Double.parseDouble(operaciones.get(i - 1));
                double num2 = Double.parseDouble(operaciones.get(i + 1));
                double res = calcularOperacion(num1, operador, num2);

                // Reemplazamos el primer número con el resultado
                operaciones.set(i - 1, String.valueOf(res));
                // Eliminamos el operador y el segundo número
                operaciones.remove(i);
                operaciones.remove(i); // El elemento i+1 ahora pasa a ser la posición i

                i--; // Retrocedemos el índice para no saltarnos elementos tras borrar

            }
        }

        // Segunda pasada: Sumas y Restas
        for (int i = 0; i < operaciones.size(); i++) {
            String operador = operaciones.get(i);
            if (operador.equals("+") || operador.equals("-")) {
                double num1 = Double.parseDouble(operaciones.get(i - 1));
                double num2 = Double.parseDouble(operaciones.get(i + 1));
                double res = calcularOperacion(num1, operador, num2);

                operaciones.set(i - 1, String.valueOf(res));
                operaciones.remove(i);
                operaciones.remove(i);

                i--;

            }
        }

        // Al final, el único elemento que queda en la lista es el resultado total
        return Double.parseDouble(operaciones.get(0));
    }

    public String formatearResultado(double resultado) {
    double redondeado = Math.round(resultado * 1e10) / 1e10;
    String resultadoStr = "" + redondeado;
    if (resultadoStr.endsWith(".0")) {
        resultadoStr = resultadoStr.substring(0, resultadoStr.length() - 2);
    }
    return resultadoStr;
}

}

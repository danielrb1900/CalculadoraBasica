package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import clases.Calculadora;
import clases.Pantalla;
import interfaz.botonesOperadores.BotonDividirListener;
import interfaz.botonesOperadores.BotonMultiplicarListener;
import interfaz.botonesOperadores.BotonRestarListener;
import interfaz.botonesOperadores.BotonSumarListener;

import java.awt.Color;
import java.awt.Font;

public class VentanaCalculadora extends JFrame {

    // DIMENSIONES
    private static final int ANCHO_VENTANA = 400;
    private static final int ALTO_VENTANA = 540;
    private static final int INICIO_X = 20;
    private static final int INICIO_Y = 120;
    private static final int SEPARACION_X = 90;
    private static final int SEPARACION_Y = 70;
    private static final int ANCHO_BOTON = 80;
    private static final int ALTO_BOTON = 60;
    private static final int ANCHO_BOTON_DOBLE = 170;
    private static final int ANCHO_PANTALLA = 350;
    private static final int ALTO_PANTALLA = 70;
    private static final int INICIO_Y_PANTALLA = 30;
    private static final int TAMANO_FUENTE_PANTALLA = 60;
    private static final int TAMANO_FUENTE_BOTON = 24;

    // COLORES
    private static final Color COLOR_FONDO_OSCURO = new Color(32, 32, 32);
    private static final Color COLOR_BOTONES_GRIS = new Color(59, 59, 59);
    private static final Color COLOR_BOTONES_NARANJA = new Color(255, 149, 0);
    private static final Color COLOR_TEXTO_BLANCO = Color.WHITE;

    private JButton botonSumar;
    private JButton botonRestar;
    private JButton botonMultiplicar;
    private JButton botonDividir;
    private JButton botonIgual;
    private JButton[] botonNumeros;
    private JLabel pantalla;
    private JButton botonLimpiar;
    private JButton botonBorrar;
    private JButton botonPunto;

    public VentanaCalculadora(Calculadora c, Pantalla p) {
        configurarVentana();
        inicializarComponentes();
        registrarListeners(c, p);
    }

    private void configurarVentana() {
        setTitle("Calculadora");
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(COLOR_FONDO_OSCURO);
    }

    private void inicializarComponentes() {
        inicializarPantalla();
        inicializarFila0();
        inicializarFila1();
        inicializarFila2();
        inicializarFila3();
        inicializarFila4();
    }

    private void inicializarPantalla() {
        pantalla = new JLabel("");
        pantalla.setHorizontalAlignment(JLabel.RIGHT);
        pantalla.setBounds(INICIO_X, INICIO_Y_PANTALLA, ANCHO_PANTALLA, ALTO_PANTALLA);
        pantalla.setForeground(COLOR_TEXTO_BLANCO);
        pantalla.setFont(new Font("Arial", Font.BOLD, TAMANO_FUENTE_PANTALLA));
        add(pantalla);
    }

    private void inicializarFila0() {
        botonLimpiar = new JButton("C");
        botonLimpiar.setBounds(INICIO_X, INICIO_Y, ANCHO_BOTON_DOBLE, ALTO_BOTON);
        aplicarEstiloBoton(botonLimpiar, COLOR_BOTONES_GRIS, COLOR_TEXTO_BLANCO);
        add(botonLimpiar);

        botonBorrar = new JButton("<-");
        botonBorrar.setBounds(INICIO_X + (2 * SEPARACION_X), INICIO_Y, ANCHO_BOTON, ALTO_BOTON);
        aplicarEstiloBoton(botonBorrar, COLOR_BOTONES_GRIS, COLOR_TEXTO_BLANCO);
        add(botonBorrar);

        botonDividir = new JButton("/");
        botonDividir.setBounds(INICIO_X + (3 * SEPARACION_X), INICIO_Y, ANCHO_BOTON, ALTO_BOTON);
        aplicarEstiloBoton(botonDividir, COLOR_BOTONES_NARANJA, COLOR_TEXTO_BLANCO);
        add(botonDividir);
    }

    private void inicializarFila1() {
        botonNumeros = new JButton[10];

        configurarBotonNumero(7, INICIO_X, INICIO_Y + SEPARACION_Y, ANCHO_BOTON, ALTO_BOTON);
        configurarBotonNumero(8, INICIO_X + SEPARACION_X, INICIO_Y + SEPARACION_Y, ANCHO_BOTON, ALTO_BOTON);
        configurarBotonNumero(9, INICIO_X + (2 * SEPARACION_X), INICIO_Y + SEPARACION_Y, ANCHO_BOTON, ALTO_BOTON);

        botonMultiplicar = new JButton("*");
        botonMultiplicar.setBounds(INICIO_X + (3 * SEPARACION_X), INICIO_Y + SEPARACION_Y, ANCHO_BOTON, ALTO_BOTON);
        aplicarEstiloBoton(botonMultiplicar, COLOR_BOTONES_NARANJA, COLOR_TEXTO_BLANCO);
        add(botonMultiplicar);
    }

    private void inicializarFila2() {
        configurarBotonNumero(4, INICIO_X, INICIO_Y + (2 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);
        configurarBotonNumero(5, INICIO_X + SEPARACION_X, INICIO_Y + (2 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);
        configurarBotonNumero(6, INICIO_X + (2 * SEPARACION_X), INICIO_Y + (2 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);

        botonRestar = new JButton("-");
        botonRestar.setBounds(INICIO_X + (3 * SEPARACION_X), INICIO_Y + (2 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);
        aplicarEstiloBoton(botonRestar, COLOR_BOTONES_NARANJA, COLOR_TEXTO_BLANCO);
        add(botonRestar);
    }

    private void inicializarFila3() {
        configurarBotonNumero(1, INICIO_X, INICIO_Y + (3 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);
        configurarBotonNumero(2, INICIO_X + SEPARACION_X, INICIO_Y + (3 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);
        configurarBotonNumero(3, INICIO_X + (2 * SEPARACION_X), INICIO_Y + (3 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);

        botonSumar = new JButton("+");
        botonSumar.setBounds(INICIO_X + (3 * SEPARACION_X), INICIO_Y + (3 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);
        aplicarEstiloBoton(botonSumar, COLOR_BOTONES_NARANJA, COLOR_TEXTO_BLANCO);
        add(botonSumar);
    }

    private void inicializarFila4() {
        botonNumeros[0] = new JButton("0");
        botonNumeros[0].setBounds(INICIO_X, INICIO_Y + (4 * SEPARACION_Y), ANCHO_BOTON_DOBLE, ALTO_BOTON);
        aplicarEstiloBoton(botonNumeros[0], COLOR_BOTONES_GRIS, COLOR_TEXTO_BLANCO);
        add(botonNumeros[0]);

        botonPunto = new JButton(".");
        botonPunto.setBounds(INICIO_X + (2 * SEPARACION_X), INICIO_Y + (4 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);
        aplicarEstiloBoton(botonPunto, COLOR_BOTONES_GRIS, COLOR_TEXTO_BLANCO);
        add(botonPunto);

        botonIgual = new JButton("=");
        botonIgual.setBounds(INICIO_X + (3 * SEPARACION_X), INICIO_Y + (4 * SEPARACION_Y), ANCHO_BOTON, ALTO_BOTON);
        aplicarEstiloBoton(botonIgual, COLOR_BOTONES_NARANJA, COLOR_TEXTO_BLANCO);
        add(botonIgual);
    }

    private void registrarListeners(Calculadora c, Pantalla p) {
        botonSumar.addActionListener(new BotonSumarListener(pantalla));
        botonRestar.addActionListener(new BotonRestarListener(pantalla));
        botonDividir.addActionListener(new BotonDividirListener(pantalla));
        botonMultiplicar.addActionListener(new BotonMultiplicarListener(pantalla));
        botonBorrar.addActionListener(new BotonBorrarListener(pantalla));
        botonLimpiar.addActionListener(new BotonLimpiarListener(pantalla));
        botonPunto.addActionListener(new BotonPuntoListener(pantalla));
        botonIgual.addActionListener(new BotonIgualListener(p, pantalla, c));

        for (JButton boton : botonNumeros) {
            boton.addActionListener(new BotonNumeroListener(pantalla, boton));
        }
    }
	
    // Método para instanciar y posicionar los números de forma rápida
    private void configurarBotonNumero(int numero, int x, int y, int ancho, int alto) {
        botonNumeros[numero] = new JButton(String.valueOf(numero));
        botonNumeros[numero].setBounds(x, y, ancho, alto);
        aplicarEstiloBoton(botonNumeros[numero], COLOR_BOTONES_GRIS, COLOR_TEXTO_BLANCO);
        add(botonNumeros[numero]);
    }
    
    // Método para aplicar el estilo visual a cualquier botón
    private void aplicarEstiloBoton(JButton boton, Color colorFondo, Color colorTexto) {
        boton.setBackground(colorFondo);
        boton.setForeground(colorTexto);
        boton.setFont(new Font("Arial", Font.BOLD, TAMANO_FUENTE_BOTON));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
    }

}
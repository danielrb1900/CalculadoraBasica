package interfaz.botonesOperadores;

import javax.swing.JLabel;

public class BotonRestarListener extends BotonOperacionesListener {

    public BotonRestarListener(JLabel pantalla) {
        super(pantalla, "-");
    }

    @Override
    protected boolean permitePantallaVacia() {
        return true;
    }

    @Override
    protected String operadoresNoPermitidos() {
        return "+-";
    }

}
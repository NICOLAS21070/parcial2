package org.uniquindio.edu.co.poo.parcial2.model;

public class SeguridadDecorator extends InmuebleDecorator {
    private double costoExtra = 2000000;

    public SeguridadDecorator(Inmueble inmuebleBase) {
        super(inmuebleBase);
    }

    @Override
    public double getPrecio() {
        return inmuebleBase.getPrecio() + costoExtra;
    }

    @Override
    public String getTipo() {
        return inmuebleBase.getTipo() + " (con Seguridad)";
    }
}

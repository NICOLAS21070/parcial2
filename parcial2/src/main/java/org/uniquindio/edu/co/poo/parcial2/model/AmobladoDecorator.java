package org.uniquindio.edu.co.poo.parcial2.model;

public class AmobladoDecorator extends InmuebleDecorator {
    private double costoExtra = 5000000;

    public AmobladoDecorator(Inmueble inmuebleBase) {
        super(inmuebleBase);
    }

    @Override
    public double getPrecio() {
        return inmuebleBase.getPrecio() + costoExtra;
    }

    @Override
    public String getTipo() {
        return inmuebleBase.getTipo() + " (Amoblado)";
    }
}

package org.uniquindio.edu.co.poo.parcial2.model;

public class PiscinaDecorator extends InmuebleDecorator {
    private double costoExtra = 15000000; // 15 millones

    public PiscinaDecorator(Inmueble inmuebleBase) {
        super(inmuebleBase);
    }

    @Override
    public double getPrecio() {
        return inmuebleBase.getPrecio() + costoExtra;
    }

    @Override
    public String getTipo() {
        return inmuebleBase.getTipo() + " (con Piscina)";
    }
}

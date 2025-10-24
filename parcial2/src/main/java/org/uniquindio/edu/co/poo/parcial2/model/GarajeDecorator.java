package org.uniquindio.edu.co.poo.parcial2.model;

public class GarajeDecorator extends InmuebleDecorator {
    private double costoExtra = 3000000;

    public GarajeDecorator(Inmueble inmuebleBase) {
        super(inmuebleBase);
    }

    @Override
    public double getPrecio() {
        return inmuebleBase.getPrecio() + costoExtra;
    }

    @Override
    public String getTipo() {
        return inmuebleBase.getTipo() + " (con Garaje)";
    }
}

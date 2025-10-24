package org.uniquindio.edu.co.poo.parcial2.model;

public abstract class InmuebleDecorator extends Inmueble {

    protected Inmueble inmuebleBase;

    protected InmuebleDecorator(Inmueble inmuebleBase) {
        super(null);
        this.inmuebleBase = inmuebleBase;
    }

    @Override
    public String getTipo() {
        return inmuebleBase.getTipo();
    }

    @Override
    public String getCiudad() {
        return inmuebleBase.getCiudad();
    }

    @Override
    public int getHabitaciones() {
        return inmuebleBase.getHabitaciones();
    }

    @Override
    public int getPisos() {
        return inmuebleBase.getPisos();
    }

    @Override
    public double getPrecio() {
        return inmuebleBase.getPrecio();
    }

    @Override
    public String toString() {
        return inmuebleBase.toString();
    }
}

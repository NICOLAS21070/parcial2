package org.uniquindio.edu.co.poo.parcial2.model;

// Patrón Decorator
public abstract class InmuebleDecorator extends Inmueble {

    protected Inmueble inmuebleBase;

    public InmuebleDecorator(Inmueble inmuebleBase) {
        super(inmuebleBase); // 👈 Usa el nuevo constructor
        this.inmuebleBase = inmuebleBase;
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

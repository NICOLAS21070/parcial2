package org.uniquindio.edu.co.poo.parcial2.model;

public abstract class Inmueble {

    protected String tipo;
    protected String ciudad;
    protected int numeroHabitaciones;
    protected int numeroPisos;
    protected double precio;

    protected Inmueble(BaseBuilder<?> builder) {
        this.tipo = builder.tipo;
        this.ciudad = builder.ciudad;
        this.numeroHabitaciones = builder.numeroHabitaciones;
        this.numeroPisos = builder.numeroPisos;
        this.precio = builder.precio;
    }


    protected Inmueble(Inmueble otro) {
        this.tipo = otro.tipo;
        this.ciudad = otro.ciudad;
        this.numeroHabitaciones = otro.numeroHabitaciones;
        this.numeroPisos = otro.numeroPisos;
        this.precio = otro.precio;
    }

    public String getTipo() { return tipo; }
    public String getCiudad() { return ciudad; }
    public int getHabitaciones() { return numeroHabitaciones; }
    public int getPisos() { return numeroPisos; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format("%s - %s (%d hab, %d pisos) $%,.2f",
                tipo, ciudad, numeroHabitaciones, numeroPisos, precio);
    }

    public static abstract class BaseBuilder<T extends BaseBuilder<T>> {
        protected String tipo;
        protected String ciudad;
        protected int numeroHabitaciones;
        protected int numeroPisos;
        protected double precio;

        public T ciudad(String ciudad) {
            this.ciudad = ciudad;
            return self();
        }

        public T numeroHabitaciones(int numeroHabitaciones) {
            this.numeroHabitaciones = numeroHabitaciones;
            return self();
        }

        public T numeroPisos(int numeroPisos) {
            this.numeroPisos = numeroPisos;
            return self();
        }

        public T precio(double precio) {
            this.precio = precio;
            return self();
        }

        protected abstract T self();
        public abstract Inmueble build();
    }
}

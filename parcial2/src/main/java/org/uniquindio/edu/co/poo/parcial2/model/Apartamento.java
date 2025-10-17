package org.uniquindio.edu.co.poo.parcial2.model;

public class Apartamento extends Inmueble {

    private Apartamento(Builder builder) {
        super(builder);
        this.tipo = "Apartamento";
    }

    public static class Builder extends BaseBuilder<Builder> {
        @Override
        protected Builder self() { return this; }

        @Override
        public Apartamento build() { return new Apartamento(this); }
    }
}

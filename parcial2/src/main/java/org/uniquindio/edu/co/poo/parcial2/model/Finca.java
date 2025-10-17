package org.uniquindio.edu.co.poo.parcial2.model;

public class Finca extends Inmueble {

    private Finca(Builder builder) {
        super(builder);
        this.tipo = "Finca";
    }

    public static class Builder extends BaseBuilder<Builder> {
        @Override
        protected Builder self() { return this; }

        @Override
        public Finca build() { return new Finca(this); }
    }
}

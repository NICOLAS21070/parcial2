package org.uniquindio.edu.co.poo.parcial2.model;

public class Casa extends Inmueble {

    private Casa(Builder builder) {
        super(builder);
        this.tipo = "Casa";
    }

    public static class Builder extends BaseBuilder<Builder> {
        @Override
        protected Builder self() { return this; }

        @Override
        public Casa build() { return new Casa(this); }
    }
}

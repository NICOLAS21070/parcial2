package org.uniquindio.edu.co.poo.parcial2.model;

public class Local extends Inmueble {

    private Local(Builder builder) {
        super(builder);
        this.tipo = "Local";
    }

    public static class Builder extends BaseBuilder<Builder> {
        @Override
        protected Builder self() { return this; }

        @Override
        public Local build() { return new Local(this); }
    }
}

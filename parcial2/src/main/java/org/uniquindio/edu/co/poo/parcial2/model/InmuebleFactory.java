package org.uniquindio.edu.co.poo.parcial2.model;

public class InmuebleFactory {

    public static Inmueble crearInmueble(String tipo, String ciudad, int habitaciones, int pisos, double precio) {
        switch (tipo.toLowerCase()) {
            case "casa":
                return new Casa.Builder()
                        .ciudad(ciudad)
                        .numeroHabitaciones(habitaciones)
                        .numeroPisos(pisos)
                        .precio(precio)
                        .build();
            case "apartamento":
                return new Apartamento.Builder()
                        .ciudad(ciudad)
                        .numeroHabitaciones(habitaciones)
                        .numeroPisos(pisos)
                        .precio(precio)
                        .build();
            case "finca":
                return new Finca.Builder()
                        .ciudad(ciudad)
                        .numeroHabitaciones(habitaciones)
                        .numeroPisos(pisos)
                        .precio(precio)
                        .build();
            case "local":
                return new Local.Builder()
                        .ciudad(ciudad)
                        .numeroHabitaciones(habitaciones)
                        .numeroPisos(pisos)
                        .precio(precio)
                        .build();
            default:
                throw new IllegalArgumentException("Tipo de inmueble no válido: " + tipo);
        }
    }
}

package org.uniquindio.edu.co.poo.parcial2.model;

public class InmuebleFactory {

    public static Inmueble crearInmueble(String tipo, String ciudad, int habitaciones, int pisos, double precio) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo de inmueble no puede estar vacío.");
        }

        Inmueble inmuebleBase;

        switch (tipo.trim().toLowerCase()) {
            case "casa":
                inmuebleBase = new Casa.Builder()
                        .ciudad(ciudad)
                        .numeroHabitaciones(habitaciones)
                        .numeroPisos(pisos)
                        .precio(precio)
                        .build();
                break;
            case "apartamento":
                inmuebleBase = new Apartamento.Builder()
                        .ciudad(ciudad)
                        .numeroHabitaciones(habitaciones)
                        .numeroPisos(pisos)
                        .precio(precio)
                        .build();
                break;
            case "finca":
                inmuebleBase = new Finca.Builder()
                        .ciudad(ciudad)
                        .numeroHabitaciones(habitaciones)
                        .numeroPisos(pisos)
                        .precio(precio)
                        .build();
                break;
            case "local":
                inmuebleBase = new Local.Builder()
                        .ciudad(ciudad)
                        .numeroHabitaciones(habitaciones)
                        .numeroPisos(pisos)
                        .precio(precio)
                        .build();
                break;
            default:
                throw new IllegalArgumentException("Tipo de inmueble no válido: " + tipo);
        }

        return inmuebleBase;
    }

    // Uso del patrón de diseño Decorator
    public static Inmueble crearInmuebleDecorado(String tipo, String ciudad,
                                                 int habitaciones, int pisos, double precio,
                                                 boolean amoblado, boolean piscina,
                                                 boolean garaje, boolean seguridad) {

        Inmueble inmueble = crearInmueble(tipo, ciudad, habitaciones, pisos, precio);

        if (amoblado) inmueble = new AmobladoDecorator(inmueble);
        if (piscina) inmueble = new PiscinaDecorator(inmueble);
        if (garaje) inmueble = new GarajeDecorator(inmueble);
        if (seguridad) inmueble = new SeguridadDecorator(inmueble);

        return inmueble;
    }
}

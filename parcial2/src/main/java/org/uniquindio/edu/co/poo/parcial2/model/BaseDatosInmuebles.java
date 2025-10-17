package org.uniquindio.edu.co.poo.parcial2.model;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosInmuebles {

    private static BaseDatosInmuebles instancia;
    private final List<Inmueble> listaInmuebles;

    private BaseDatosInmuebles() {
        listaInmuebles = new ArrayList<>();
        cargarDatosEjemplo();
    }

    public static BaseDatosInmuebles getInstancia() {
        if (instancia == null) {
            instancia = new BaseDatosInmuebles();
        }
        return instancia;
    }

    private void cargarDatosEjemplo() {
        listaInmuebles.add(new Casa.Builder()
                .ciudad("Armenia")
                .numeroHabitaciones(3)
                .numeroPisos(2)
                .precio(250_000_000)
                .build());

        listaInmuebles.add(new Apartamento.Builder()
                .ciudad("Pereira")
                .numeroHabitaciones(2)
                .numeroPisos(1)
                .precio(180_000_000)
                .build());

        listaInmuebles.add(new Finca.Builder()
                .ciudad("Salento")
                .numeroHabitaciones(5)
                .numeroPisos(2)
                .precio(950_000_000)
                .build());

        listaInmuebles.add(new Local.Builder()
                .ciudad("Calarcá")
                .numeroHabitaciones(1)
                .numeroPisos(1)
                .precio(120_000_000)
                .build());
    }

    public List<Inmueble> getListaInmuebles() {
        return listaInmuebles;
    }

    public void agregarInmueble(Inmueble inmueble) {
        listaInmuebles.add(inmueble);
    }

    public boolean eliminarInmueble(Inmueble inmueble) {
        return listaInmuebles.remove(inmueble);
    }

    public Inmueble buscarInmueble(String tipo, String ciudad) {
        return listaInmuebles.stream()
                .filter(i -> i.getTipo().equalsIgnoreCase(tipo)
                        && i.getCiudad().equalsIgnoreCase(ciudad))
                .findFirst()
                .orElse(null);
    }

    public int getCantidadInmuebles() {
        return listaInmuebles.size();
    }
}

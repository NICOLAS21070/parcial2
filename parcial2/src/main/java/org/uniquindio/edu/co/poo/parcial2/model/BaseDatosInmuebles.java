package org.uniquindio.edu.co.poo.parcial2.model;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosInmuebles {

    // Instancia única (patrón Singleton)
    private static BaseDatosInmuebles instancia;

    // Lista interna de inmuebles
    private final List<Inmueble> listaInmuebles;

    // Constructor privado
    private BaseDatosInmuebles() {
        listaInmuebles = new ArrayList<>();
        cargarDatosEjemplo();
    }

    /**
     * Devuelve la única instancia de BaseDatosInmuebles.
     */
    public static BaseDatosInmuebles getInstancia() {
        if (instancia == null) {
            instancia = new BaseDatosInmuebles();
        }
        return instancia;
    }

    /**
     * Carga datos de ejemplo iniciales.
     */
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

    // ==============================
    // MÉTODOS PÚBLICOS DE ACCESO
    // ==============================

    /**
     * Devuelve la lista de inmuebles.
     * (Alias para compatibilidad con el DashboardController)
     */
    public static List<Inmueble> getListaInmuebles() {
        return getInstancia().listaInmuebles;
    }

    /**
     * También se deja este método por compatibilidad con otros controladores.
     */
    public static List<Inmueble> obtenerInmuebles() {
        return getListaInmuebles();
    }

    /**
     * Agrega un inmueble a la lista.
     */
    public static void agregarInmueble(Inmueble inmueble) {
        getInstancia().listaInmuebles.add(inmueble);
    }

    /**
     * Elimina un inmueble de la lista.
     */
    public static boolean eliminarInmueble(Inmueble inmueble) {
        return getInstancia().listaInmuebles.remove(inmueble);
    }

    /**
     * Busca un inmueble según tipo y ciudad.
     */
    public static Inmueble buscarInmueble(String tipo, String ciudad) {
        return getInstancia().listaInmuebles.stream()
                .filter(i -> i.getTipo().equalsIgnoreCase(tipo)
                        && i.getCiudad().equalsIgnoreCase(ciudad))
                .findFirst()
                .orElse(null);
    }

    /**
     * Devuelve la cantidad de inmuebles en la base.
     */
    public static int getCantidadInmuebles() {
        return getInstancia().listaInmuebles.size();
    }
}

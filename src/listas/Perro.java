package listas;

import java.io.Serializable;

public class Perro implements Comparable<Perro>, Serializable {
    public Perro(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    @Override
    public int compareTo(Perro o) {
        return 0;
    }
}

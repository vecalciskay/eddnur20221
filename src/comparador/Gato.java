package src.comparador;

public class Gato {
    private int edad;
    private int peso;
    private String nombre;

    public Gato(int edad, int peso, String nombre) {
        this.edad = edad;
        this.peso = peso;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "edad=" + edad +
                ", peso=" + peso +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

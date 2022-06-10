package arbol.arbolaritmetico;

public class Operador extends ElementoAritmetico {

    private String simbolo;
    private String nombre;

    public Operador(String simbolo) {
        this.simbolo = simbolo;
        if (simbolo.equals("+")) {
            nombre = "Suma";
        } else if (simbolo.equals("-")) {
            nombre = "Resta";
        } else if (simbolo.equals("/")) {
            nombre = "División";
        } else if (simbolo.equals("*")) {
            nombre = "Multiplicación";
        }
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return simbolo;
    }
}

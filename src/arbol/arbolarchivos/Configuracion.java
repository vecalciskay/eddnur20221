package arbol.arbolarchivos;

/**
 * Singleton class
 */
public final class Configuracion {
    private static Configuracion instance = null;
    private String rutaArchivos;

    private Configuracion() {
        this.rutaArchivos = "";
    }

    public static Configuracion getInstance() {
        if (instance == null) {
            instance = new Configuracion();
        }
        return instance;
    }

    public String getRutaArchivos() {
        return rutaArchivos;
    }

    public void setRutaArchivos(String rutaArchivos) {
        this.rutaArchivos = rutaArchivos;
    }
}

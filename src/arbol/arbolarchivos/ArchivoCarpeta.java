package arbol.arbolarchivos;

public class ArchivoCarpeta {
    private String nombre;
    private int tamanio;
    private String ubicacionFisica;
    private ArchivoCarpeta padre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(String ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public ArchivoCarpeta getPadre() {
        return padre;
    }

    public void setPadre(ArchivoCarpeta padre) {
        this.padre = padre;
    }

    public String generateRandomFileName() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append((char) (Math.random() * 26 + 'a'));
        }
        return sb.toString();
    }
}

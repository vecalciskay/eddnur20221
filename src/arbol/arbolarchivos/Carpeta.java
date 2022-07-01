package arbol.arbolarchivos;

public class Carpeta extends ArchivoCarpeta {
    @Override
    public String toString() {
        return this.getUbicacionFisica();
    }
}

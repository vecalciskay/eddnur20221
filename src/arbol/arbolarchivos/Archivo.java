package arbol.arbolarchivos;

public class Archivo extends ArchivoCarpeta{
    @Override
    public String toString() {
        return this.getNombre();
    }
}

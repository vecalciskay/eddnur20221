package src.observer;

public class EjemploObserver {
    public static void main(String[] args) {
        AccionEmpresa accion = new AccionEmpresa("Google", 1000);
        IInversor inversor = new EstudianteUniversidad();

        accion.addInversor(inversor);

        // Simular lo que pasa con la accion
        accion.baja(10);
        accion.sube(23);
        accion.baja(8);
        accion.sube(12);
        accion.baja(5);
    }
}

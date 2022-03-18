package src.observer;

import java.beans.PropertyChangeSupport;

public class AccionEmpresa {


    private int valor;
    private String nombre;
    private PropertyChangeSupport cambios;

    public AccionEmpresa(String nombre, int valorInicial) {
        this.nombre = nombre;
        this.valor = valorInicial;
        this.cambios = new PropertyChangeSupport(this);
    }

    public void addInversor(IInversor inversor) {
        cambios.addPropertyChangeListener(inversor);
    }

    public void baja(int i) {
        int valorAnterior = valor;
        this.valor -= i;
        System.out.println("[Accion] Baja " + i + " Valor actual: " + valor);
        this.notificar(valorAnterior, valor);
    }

    private void notificar(int valorAnterior, int valor) {
        cambios.firePropertyChange("VALOR", valorAnterior, valor);
    }

    public void sube(int i) {
        int valorAnterior = valor;
        this.valor += i;
        System.out.println("[Accion] Sube " + i + " Valor actual: " + valor);
        this.notificar(valorAnterior, valor);
    }
}

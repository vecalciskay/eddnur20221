package src.mandelbrot.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Mandelbrot extends Imagen {

    private PropertyChangeSupport cambios;

    public Mandelbrot() {
        super.initImagen(600,600);

        cambios = new PropertyChangeSupport(this);

        testImagen();
    }

    public void addObserver(PropertyChangeListener listener) {
        cambios.addPropertyChangeListener(listener);
    }
}

package src.mandelbrot.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Mandelbrot extends Imagen {

    private PropertyChangeSupport cambios;

    private double minReal;
    private double minImg;
    private double maxReal;
    private double maxImg;

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;


    public Mandelbrot() {
        super.initImagen(600,600);

        minX = 0;
        minY = 0;
        maxX = 600;
        maxY = 600;

        // -1,-1 - +1.5, +1
        minReal = -1.5;
        minImg = -1;
        maxReal = 1;
        maxImg = 1;

        cambios = new PropertyChangeSupport(this);

        testImagen();
        cambios.firePropertyChange("IMAGEN",1,0);
    }
    
    public void hacerMandelbrot() {
        System.out.println("Comienza Mandelbrot");
        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                NumeroComplejo z0 = calcularPuntoInicial(i,j);
                int n = calcularMandelbrot(z0);
                pixeles[i][j] = n + n*256 + n*256*256;
            }
            System.out.println( "Calculada linea " + i);
        }
        cambios.firePropertyChange("IMAGEN",1,0);
    }

    private NumeroComplejo calcularPuntoInicial(int i, int j) {
        double x2menosX1 = maxX - minX;
        double r2MenosR1 = maxReal - minReal;
        double ratioX = r2MenosR1 / x2menosX1;
        double realX = (double)i * ratioX + minReal;

        double y2menosY1 = maxY - minY;
        double i2MenosI1 = maxImg - minImg;
        double ratioY = i2MenosI1 / y2menosY1;
        double realY = (double)j * ratioY + minImg;

        return new NumeroComplejo(realX, realY);
    }

    private int calcularMandelbrot(NumeroComplejo z0) {
        int c = 0;
        NumeroComplejo zn = z0;
        while(zn.absAlCuadrado() < 4 &&
         c < 256) {
            NumeroComplejo zn1 = zn.multiplicar(zn).sumar(z0);
            zn = zn1;
            c++;
        }

        return c;
    }


    public void addObserver(PropertyChangeListener listener) {
        cambios.addPropertyChangeListener(listener);
    }
}

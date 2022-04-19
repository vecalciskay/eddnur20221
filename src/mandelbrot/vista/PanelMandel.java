package src.mandelbrot.vista;

import src.mandelbrot.modelo.Mandelbrot;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelMandel extends JPanel
        implements PropertyChangeListener {

    private Mandelbrot modelo;

    public PanelMandel(Mandelbrot m) {
        modelo = m;
        modelo.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(600,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo == null) {
            return;
        }

        BufferedImage rsm = new BufferedImage(
                modelo.getAncho(), modelo.getAlto(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();

        modelo.dibujar(g2d);
        g.drawImage(rsm, 0, 0, null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "IMAGEN") {
            return;
        }
        repaint();
    }
}


package src.mvc.vista;

import src.mvc.modelo.Automovil;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelAutomovil extends JPanel
 implements PropertyChangeListener {

    private Automovil modelo;

    public PanelAutomovil(Automovil m) {
        modelo = m;
        modelo.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo != null) {
            modelo.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "POSICION") {
            return;
        }
        repaint();
    }
}

package arbol.gui;

import arbol.Arbol;
import arbol.arbolaritmetico.ElementoAritmetico;

import javax.swing.*;
import java.awt.*;

public class PanelArbol extends JPanel {
    private Arbol<ElementoAritmetico> modelo;

    public PanelArbol(Arbol<ElementoAritmetico> modelo) {
        this.modelo = modelo;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modelo != null)
            modelo.dibujar(g, getWidth(), getHeight());
    }

    public Arbol<ElementoAritmetico> getModelo() {
        return modelo;
    }

    public void setModelo(Arbol<ElementoAritmetico> modelo) {
        this.modelo = modelo;
    }
}

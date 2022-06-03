package arbol.gui;

import arbol.Arbol;

import javax.swing.*;
import java.awt.*;

public class PanelArbol extends JPanel {
    private Arbol<String> modelo;

    public PanelArbol(Arbol<String> modelo) {
        this.modelo = modelo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modelo != null)
            modelo.dibujar(g, getWidth(), getHeight());
    }
}

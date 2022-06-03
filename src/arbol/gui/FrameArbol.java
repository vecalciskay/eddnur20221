package arbol.gui;

import arbol.Arbol;

import javax.swing.*;
import java.awt.*;

public class FrameArbol extends JFrame {
    private Arbol<String> modelo;

    public FrameArbol() {
        this.crearModelo();
        this.init();
    }

    private void crearModelo() {
        this.modelo = new Arbol<String>();
        modelo.insertar("10", "1", null);

        modelo.insertar("4", "2", "1");
        modelo.insertar("5", "3", "1");
        modelo.insertar("7", "4", "1");

        modelo.insertar("2", "5", "2");
        modelo.insertar("99", "6", "2");
        modelo.insertar("3", "7", "2");

        modelo.insertar("100", "11", "7");

        modelo.insertar("3", "8", "4");

        modelo.insertar("2", "9", "8");
        modelo.insertar("7", "10", "8");

    }

    private void init() {
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        PanelArbol panelArbol = new PanelArbol(modelo);
        this.setLayout(new BorderLayout());
        this.add(panelArbol, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new FrameArbol();
    }
}

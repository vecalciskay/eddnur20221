package src.mandelbrot.vista;


import src.mandelbrot.modelo.Mandelbrot;

import javax.swing.*;
import java.awt.*;

public class VentanaMandel extends JFrame {

    private Mandelbrot modelo;
    private PanelMandel panel;

    public VentanaMandel() {
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Mandelbrot();
        panel = new PanelMandel(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
    }

}


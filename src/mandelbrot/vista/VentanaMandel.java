package src.mandelbrot.vista;


import src.mandelbrot.modelo.Mandelbrot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JButton btnHacer = new JButton("Hacer");
        btnHacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnHacer_clicked();
            }
        });

        this.getContentPane().add(btnHacer, BorderLayout.SOUTH);

        this.pack();
    }

    private void btnHacer_clicked() {
        modelo.hacerMandelbrot();
    }

}


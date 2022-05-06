package src.paint.vista;

import paint.modelo.BordesKernel;
import paint.modelo.Suavizado;
import src.paint.modelo.Imagen;
import src.paint.modelo.Transformacion;
import src.paint.modelo.TransformarTonosDeGris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintFrame extends JFrame {
    private Imagen modelo;
    private PaintPanel panel;

    public PaintFrame() {
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(400,400);
        panel = new PaintPanel(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton btnHacer = new JButton("Hacer");
        btnHacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnHacer_clicked();
            }
        });

        this.getContentPane().add(btnHacer, BorderLayout.SOUTH);

        JButton btnGris = new JButton("Suavizar");
        btnGris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGris_clicked();
            }
        });

        this.getContentPane().add(btnGris, BorderLayout.EAST);

        this.pack();
    }

    private void btnGris_clicked() {
        Transformacion tonosDeGris = new BordesKernel(modelo);
        tonosDeGris.transformar();
    }

    private void btnHacer_clicked() {
        modelo.leerDeArchivo("c:/temp/edd1.jpg");
    }
}

package arbol.gui;

import arbol.Arbol;
import arbol.arbolaritmetico.ArbolAritmetico;
import arbol.arbolaritmetico.ElementoAritmetico;

import javax.swing.*;
import java.awt.*;

public class FrameArbol extends JFrame {
    private ArbolAritmetico modelo;
    private PanelArbol panelArbol;
    private JLabel lblResultado;

    public FrameArbol() {
        this.init();
    }

    private void crearModelo(String expresion) {
        try {
            this.modelo = new ArbolAritmetico(expresion);
            this.panelArbol.setModelo(this.modelo);
            this.panelArbol.repaint();
            lblResultado.setText(String.valueOf(modelo.evaluar()));
        } catch (Exception e) {
            e.printStackTrace();
        }


//                new Arbol<String>();
//        modelo.insertar("10", "1", null);
//
//        modelo.insertar("4", "2", "1");
//        modelo.insertar("5", "3", "1");
//        modelo.insertar("7", "4", "1");
//
//        modelo.insertar("2", "5", "2");
//        modelo.insertar("99", "6", "2");
//        modelo.insertar("3", "7", "2");
//
//        modelo.insertar("100", "11", "7");
//
//        modelo.insertar("3", "8", "4");
//
//        modelo.insertar("2", "9", "8");
//        modelo.insertar("7", "10", "8");

    }

    private void init() {
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        panelArbol = new PanelArbol(modelo);
        this.add(panelArbol, BorderLayout.CENTER);

        JPanel panelTop = new JPanel();

        JTextField txtExpresion = new JTextField();
        txtExpresion.setPreferredSize(new Dimension(200, 30));
        panelTop.add(txtExpresion, BorderLayout.WEST);
        JButton btnEvaluar = new JButton("Evaluar");
        panelTop.add(btnEvaluar, BorderLayout.EAST);
        lblResultado = new JLabel();
        lblResultado.setPreferredSize(new Dimension(200, 30));
        panelTop.add(lblResultado, BorderLayout.SOUTH);

        btnEvaluar.addActionListener(e -> {
            crearModelo(txtExpresion.getText());
        });

        this.add(panelTop, BorderLayout.NORTH);
        this.pack();
    }

    public static void main(String[] args) {
        new FrameArbol();
    }
}

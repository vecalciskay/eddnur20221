package src.mvc.vista;

import src.mvc.modelo.Automovil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAutomovil extends JFrame {

    private Automovil modelo;
    private PanelAutomovil panel;

    public VentanaAutomovil() {
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Automovil("toyota", Color.red, 50);
        panel = new PanelAutomovil(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER);
        
        // Menu
        JMenuBar bar = new JMenuBar();
        
        JMenu mnu = new JMenu("Automovil");
        bar.add(mnu);
        
        JMenuItem item = new JMenuItem("Derecha");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAutomovilDerecha();
            }
        });

        mnu.add(item);

        this.setJMenuBar(bar);

        this.pack();
    }

    private void menuAutomovilDerecha() {
        modelo.moverDerecha();
    }
}

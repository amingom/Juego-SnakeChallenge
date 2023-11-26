package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraDeCarga extends BarraCarga {
    private JProgressBar progressBar;
    private Timer timer;
    private int progreso;
    private JFrame frame;

    public BarraDeCarga() {
        frame = new JFrame("SNAKE CHALLENGE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        
        // Panel con imagen de fondo
        JPanel panel = new JPanel() {
            Image imagenFondo = new ImageIcon("img//fondo_barra.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, 500, 300, this);
            }
        };

     // Barra de progreso
        progressBar = new JProgressBar(0, 40);
        progressBar.setStringPainted(true);
        progressBar.setForeground( Color.MAGENTA); // Color morado

        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progreso += 1;
                progressBar.setValue(progreso);

                if (progreso == 100) {
                    timer.stop();
                    frame.dispose();
                    cargaCompleta();
                }
            }
        });

        // Establecer el diseño nulo para poder posicionar componentes manualmente
        panel.setLayout(null);

        // Posiciona la barra de progreso abajo y más ancha
        progressBar.setBounds(0, 300, 500, 61);

        // Agrega la barra de progreso al panel
        panel.add(progressBar);

        // Agrega el panel al frame
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void cargar() {
        frame.setVisible(true);
        timer.start();
    }
    
    public void cargaCompleta() {
    	frame.dispose();
    	new Interfaz_Usuario().setVisible(true);
    }
}
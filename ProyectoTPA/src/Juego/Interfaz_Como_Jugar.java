package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the interface of "How to Play" in the game Snake
 * Challenge. Provides information about the rules and controls of the game.
 */
public class Interfaz_Como_Jugar extends JFrame {

	/**
	 * Constructor of the class that configures the interface "How to Play". Sets
	 * the size, title, position and other aspects of the window.
	 */
	public Interfaz_Como_Jugar() {

		setSize(600, 600);
		setTitle("Snake Challenge");
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.green);
		iniciarComponentes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Initializes the visual components of the interface "How to Play". Creates a
	 * panel, text labels and a "Back" button.
	 */
	void iniciarComponentes() {

		JPanel ComoJugar = new JPanel(); // creates a panel
		ComoJugar.setBackground(Color.LIGHT_GRAY);
		ComoJugar.setLayout(null);
		getContentPane().add(ComoJugar);

		JLabel Comojugar = new JLabel();
		Comojugar.setText("How to play");
		Comojugar.setBounds(-60, 20, 700, 100);
		Comojugar.setHorizontalAlignment(SwingConstants.CENTER);
		Comojugar.setForeground(Color.BLACK);
		Comojugar.setOpaque(true);
		Comojugar.setBackground(Color.LIGHT_GRAY);
		Comojugar.setFont(new Font("arial", Font.BOLD, 50));
		ComoJugar.add(Comojugar);

		JLabel Instrucciones = new JLabel();
		Instrucciones.setText("The Snake Challenge is a game that consists of getting the most points\n"
				+ " before the game ends.\n"
				+ " \nThe player must direct the snake towards the food, avoiding all obstacles and\n"
				+ " the edges of the map so that the game does not end.\n"
				+ " \nThe controls are the w, a, s, d keys, which are used to go up, right, down and left\n"
				+ " respectively.\n" + " \nThe points will be obtained by feeding the snake and it will grow in turn.\n"
				+ " \nThere are different types of food that will make the snake grow differently and\n"
				+ " will have different point values.\n"
				+ " \nThe player can see the score in real time through the scoreboard in the upper\n"
				+ " part of the screen.\n");
		Instrucciones.setText("<html>" + Instrucciones.getText().replaceAll("\n", "<br/>") + "</html>");
		Instrucciones.setBounds(-50, 40, 700, 500);
		Instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		Instrucciones.setForeground(Color.BLACK);
		Instrucciones.setOpaque(true);
		Instrucciones.setBackground(Color.LIGHT_GRAY);
		Instrucciones.setFont(new Font("arial", Font.BOLD, 13));
		ComoJugar.add(Instrucciones);

		JButton Atras = new JButton();
		Atras.setText("Back");
		Atras.setBounds(10, 510, 150, 40);
		Atras.setEnabled(true);
		Atras.setForeground(Color.BLACK);
		Atras.setBackground(Color.WHITE);
		Atras.setFont(new Font("algerian", Font.BOLD, 20));
		Atras.setFocusPainted(false);
		Atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Usuario ventanaInicial = new Interfaz_Usuario();
				ventanaInicial.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Atras)).dispose();
			}
		});
		ComoJugar.add(Atras);
	}
}
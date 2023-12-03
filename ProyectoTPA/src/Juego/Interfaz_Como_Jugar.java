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
		components();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Initializes the visual components of the interface "How to Play". Creates a
	 * panel, text labels and a "Back" button.
	 */
	void components() {

		JPanel _howToPlay = new JPanel(); // creates a panel
		_howToPlay.setBackground(Color.LIGHT_GRAY);
		_howToPlay.setLayout(null);
		getContentPane().add(_howToPlay);

		JLabel howToPlay = new JLabel();
		howToPlay.setText("How to play");
		howToPlay.setBounds(-60, 20, 700, 100);
		howToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		howToPlay.setForeground(Color.BLACK);
		howToPlay.setOpaque(true);
		howToPlay.setBackground(Color.LIGHT_GRAY);
		howToPlay.setFont(new Font("arial", Font.BOLD, 50));
		_howToPlay.add(howToPlay);

		JLabel instructions = new JLabel();
		instructions.setText("The Snake Challenge is a game that consists of getting the most points\n"
				+ " before the game ends.\n"
				+ " \nThe player must direct the snake towards the food, avoiding all obstacles and\n"
				+ " the edges of the map so that the game does not end.\n"
				+ " \nThe controls are the w, a, s, d keys, which are used to go up, right, down and left\n"
				+ " respectively.\n" + " \nThe points will be obtained by feeding the snake and it will grow in turn.\n"
				+ " \nThere are different types of food that will make the snake grow differently and\n"
				+ " will have different point values.\n"
				+ " \nThe player can see the score in real time through the scoreboard in the upper\n"
				+ " part of the screen.\n");
		instructions.setText("<html>" + instructions.getText().replaceAll("\n", "<br/>") + "</html>");
		instructions.setBounds(-50, 40, 700, 500);
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		instructions.setForeground(Color.BLACK);
		instructions.setOpaque(true);
		instructions.setBackground(Color.LIGHT_GRAY);
		instructions.setFont(new Font("arial", Font.BOLD, 13));
		instructions.add(instructions);

		JButton back = new JButton();
		back.setText("Back");
		back.setBounds(10, 510, 150, 40);
		back.setEnabled(true);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("algerian", Font.BOLD, 20));
		back.setFocusPainted(false);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Usuario initialWindow = new Interfaz_Usuario();
				initialWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(back)).dispose();
			}
		});
		instructions.add(back);
	}
}
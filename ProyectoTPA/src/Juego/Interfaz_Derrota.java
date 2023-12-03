package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the interface of the Game Over Screen. It allows
 * players to exit the game, play again, or select the level.
 */
public class Interfaz_Derrota extends JFrame {
	private Interfaz_Juego points; // Used to obtain the game score through getScore()

	/**
	 * Constructor of the class that configures the final screen interface. Set the
	 * size, title, position and other aspects of the window.
	 * 
	 * @param points Set the final score
	 */
	public Interfaz_Derrota(Interfaz_Juego points) {
		this.points = points;
		setSize(400, 300); // width height
		setTitle("Snake Challenge"); // set the window title
		setLocationRelativeTo(null); // set the window in the center of the screen
		this.getContentPane().setBackground(Color.green); // set the window color
		components(); // Initialize buttons, images, etc.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the Game Over Screen interface. Creates
	 * a panel, text labels, and buttons for Exit, Play Again, and Select Level.
	 */
	void components() {

		JPanel panel = new JPanel(); // create a panel
		panel.setBackground(Color.MAGENTA); // set the panel color
		panel.setLayout(null); // disable its layout
		this.getContentPane().add(panel); // add the panel to the window

		JLabel message = new JLabel(); // create a text label
		message.setText("GAME OVER");
		message.setBounds(80, 10, 200, 40);
		message.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		message.setForeground(Color.BLACK); // set the text color
		message.setOpaque(false); // set the ability to paint the label
		message.setFont(new Font("arial", 0, 30)); // set the text font
		panel.add(message); // add the label to the panel

		JLabel scoreLabel = new JLabel(); // create a text label
		scoreLabel.setText("SCORE : " + points.getScore());
		scoreLabel.setBounds(30, 60, 300, 30);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		scoreLabel.setForeground(Color.BLACK); // set the text color
		scoreLabel.setOpaque(false); // set the ability to paint the label
		scoreLabel.setFont(new Font("arial", 0, 30)); // set the text font
		panel.add(scoreLabel); // add the label to the panel

		JButton exitButton = new JButton(); // create the button
		exitButton.setText("EXIT"); // set text to the button
		exitButton.setBounds(2, 218, 100, 30); // size and position of the button
		exitButton.setEnabled(true); // enable or disable the click
		exitButton.setForeground(Color.BLACK); // button text color
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		exitButton.setFocusPainted(false);

		// close the main window
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(exitButton);

		JButton restartButton = new JButton(); // create the button
		restartButton.setText("PLAY AGAIN"); // set text to the button
		restartButton.setBounds(108, 218, 130, 30); // size and position of the button
		restartButton.setEnabled(true); // enable or disable the click
		restartButton.setForeground(Color.BLACK); // button text color
		restartButton.setBackground(Color.WHITE);
		restartButton.setFont(new Font("algerian", Font.BOLD, 15)); // button text font
		restartButton.setFocusPainted(false);

		restartButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Juego GameWindow = new Interfaz_Juego();
				GameWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(restartButton)).dispose(); // close the window

			}
		});

		panel.add(restartButton);

		JButton playAgainButton = new JButton(); // create the button
		playAgainButton.setText("SELECT LEVEL"); // set text to the button
		playAgainButton.setBounds(245, 218, 140, 30); // size and position of the button
		playAgainButton.setEnabled(true); // enable or disable the click
		playAgainButton.setForeground(Color.BLACK); // button text color
		playAgainButton.setBackground(Color.WHITE);
		playAgainButton.setFont(new Font("algerian", Font.BOLD, 12)); // button text font
		playAgainButton.setFocusPainted(false);

		playAgainButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Niveles levelSelectionWindow = new Interfaz_Niveles();
				levelSelectionWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(playAgainButton)).dispose(); // close the window

			}
		});

		panel.add(playAgainButton);

	}
}
package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the interface of the Final Screen. Allows players to
 * exit the game, play again, or select the level.
 */

public class Interfaz_Victoria extends JFrame {
	private Interfaz_Juego points; // Used to obtain the score of the game through getScore()

	/**
	 * Constructor of the class that configures the Final Screen interface. Sets the
	 * size, title, position, and other aspects of the window.
	 * 
	 * @param points Set the final score
	 */

	public Interfaz_Victoria(Interfaz_Juego points) {
		this.points = points;
		setSize(400, 300); // width height
		setTitle("Snake Challenge"); // set the window title
		setLocationRelativeTo(null); // set the window in the center of the screen
		this.getContentPane().setBackground(Color.green); // set the window color
		iniciarComponentes(); // Initialize buttons, images...
		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the Final Screen interface. Creates a
	 * panel, text labels, and buttons for Exit, Play Again, and Select Level.
	 */

	void iniciarComponentes() {

		JPanel panel = new JPanel(); // create a panel
		panel.setBackground(Color.MAGENTA); // set the color of the panel
		panel.setLayout(null); // deactivate its design
		this.getContentPane().add(panel); // add the panel to the window

		JLabel messageLabel = new JLabel(); // create a text label
		messageLabel.setText("GG WELL PLAY");
		messageLabel.setBounds(60, 10, 240, 40);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		messageLabel.setForeground(Color.BLACK); // set the text color
		messageLabel.setOpaque(false); // set the ability to paint the label
		messageLabel.setFont(new Font("arial", 0, 30)); // set the text font
		panel.add(messageLabel); // add the label to the panel

		JLabel scoreLabel = new JLabel(); // create a text label
		scoreLabel.setText("SCORE: " + points.getScore());
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
		exitButton.setForeground(Color.BLACK); // color of the letters of the button
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("algerian", Font.BOLD, 20)); // font of the button's letter
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
		restartButton.setForeground(Color.BLACK); // color of the letters of the button
		restartButton.setBackground(Color.WHITE);
		restartButton.setFont(new Font("algerian", Font.BOLD, 15)); // font of the button's letter
		restartButton.setFocusPainted(false);

		restartButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Juego newGameInterface = new Interfaz_Juego();
				newGameInterface.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(restartButton)).dispose(); // close the window

			}
		});

		panel.add(restartButton);

		JButton selectLevelButton = new JButton(); // create the button
		selectLevelButton.setText("SELECT LEVEL"); // set text to the button
		selectLevelButton.setBounds(245, 218, 140, 30); // size and position of the button
		selectLevelButton.setEnabled(true); // enable or disable the click
		selectLevelButton.setForeground(Color.BLACK); // color of the letters of the button
		selectLevelButton.setBackground(Color.WHITE);
		selectLevelButton.setFont(new Font("algerian", Font.BOLD, 12)); // font of the button's letter
		selectLevelButton.setFocusPainted(false);

		selectLevelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Niveles levelInterface = new Interfaz_Niveles();
				levelInterface.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(selectLevelButton)).dispose(); // close the window

			}
		});

		panel.add(selectLevelButton);

	}
}
package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the Defeat_Interface. It allows
 * players to exit the game, play again, or select the level.
 */
public class Defeat_Interface extends JFrame {
	private Game_Interfece points; // Used to obtain the game score through getScore()

	/**
	 * Constructor of the class that configures the final screen interface. Set the
	 * size, title, position and other aspects of the window.
	 * 
	 * @param points Set the final score
	 */
	public Defeat_Interface(Game_Interfece points) {
		this.points = points;
		setSize(400, 300); // width height
		setTitle("Snake Challenge"); // set the window title
		setLocationRelativeTo(null); // set the window in the center of the screen
		this.getContentPane().setBackground(Color.green); // set the window color
		components(); // Initialize buttons, images, etc.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the Defeat_Interface. Creates
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

		JButton exit = new JButton(); // create the button
		exit.setText("EXIT"); // set text to the button
		exit.setBounds(2, 218, 100, 30); // size and position of the button
		exit.setEnabled(true); // enable or disable the click
		exit.setForeground(Color.BLACK); // button text color
		exit.setBackground(Color.WHITE);
		exit.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		exit.setFocusPainted(false);

		// close the main window
		exit.addActionListener(new ActionListener() { // after pressing the exit Button you will close the game
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(exit);

		JButton restart = new JButton(); // create the button
		restart.setText("PLAY AGAIN"); // set text to the button
		restart.setBounds(108, 218, 130, 30); // size and position of the button
		restart.setEnabled(true); // enable or disable the click
		restart.setForeground(Color.BLACK); // button text color
		restart.setBackground(Color.WHITE);
		restart.setFont(new Font("algerian", Font.BOLD, 15)); // button text font
		restart.setFocusPainted(false);

		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // after pressing the restart Button you will go to the level game window
				Game_Interfece GameWindow = new Game_Interfece();
				GameWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(restart)).dispose(); // close the window

			}
		});

		panel.add(restart);

		JButton selectLevel = new JButton(); // create the button
		selectLevel.setText("SELECT LEVEL"); // set text to the button
		selectLevel.setBounds(245, 218, 140, 30); // size and position of the button
		selectLevel.setEnabled(true); // enable or disable the click
		selectLevel.setForeground(Color.BLACK); // button text color
		selectLevel.setBackground(Color.WHITE);
		selectLevel.setFont(new Font("algerian", Font.BOLD, 12)); // button text font
		selectLevel.setFocusPainted(false);

		selectLevel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // after pressing the select Level Button you will go to the level selection Window
				Level_Interface levelSelectionWindow = new Level_Interface();
				levelSelectionWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(selectLevel)).dispose(); // close the window

			}
		});

		panel.add(selectLevel);

	}
}
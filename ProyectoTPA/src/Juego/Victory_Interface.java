package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the Victory_Interface. Allows players to
 * exit the game, play again, or select the level.
 */
public class Victory_Interface extends JFrame {
	private Game_Interfece points; // Used to obtain the score of the game through getScore()

	/**
	 * Constructor of the class that configures the Victory_Interface. Sets the
	 * size, title, position, and other aspects of the window.
	 * 
	 * @param points Set the final score
	 */
	public Victory_Interface(Game_Interfece points) {
		this.points = points;
		setSize(400, 300); // width height
		setTitle("Snake Challenge"); // set the window title
		setLocationRelativeTo(null); // set the window in the center of the screen
		setResizable(false);
		this.getContentPane().setBackground(Color.green); // set the window color
		components(); // Initialize buttons, images...
		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the Victory_Interface. Creates a
	 * panel, text labels, and buttons for Exit, Play Again, and Select Level.
	 */
	void components() {

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

		JButton exit = new JButton(); // create the button
		exit.setText("EXIT"); // set text to the button
		exit.setBounds(2, 218, 100, 30); // size and position of the button
		exit.setEnabled(true); // enable or disable the click
		exit.setForeground(Color.BLACK); // color of the letters of the button
		exit.setBackground(Color.WHITE);
		exit.setFont(new Font("algerian", Font.BOLD, 20)); // font of the button's letter
		exit.setFocusPainted(false);

		// close the main window
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(exit);

		JButton restart = new JButton(); // create the button
		restart.setText("PLAY AGAIN"); // set text to the button
		restart.setBounds(108, 218, 130, 30); // size and position of the button
		restart.setEnabled(true); // enable or disable the click
		restart.setForeground(Color.BLACK); // color of the letters of the button
		restart.setBackground(Color.WHITE);
		restart.setFont(new Font("algerian", Font.BOLD, 15)); // font of the button's letter
		restart.setFocusPainted(false);

		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game_Interfece newGameInterface = new Game_Interfece();
				newGameInterface.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(restart)).dispose(); // close the window

			}
		});

		panel.add(restart);

		JButton selectLevel = new JButton(); // create the button
		selectLevel.setText("SELECT LEVEL"); // set text to the button
		selectLevel.setBounds(245, 218, 140, 30); // size and position of the button
		selectLevel.setEnabled(true); // enable or disable the click
		selectLevel.setForeground(Color.BLACK); // color of the letters of the button
		selectLevel.setBackground(Color.WHITE);
		selectLevel.setFont(new Font("algerian", Font.BOLD, 12)); // font of the button's letter
		selectLevel.setFocusPainted(false);

		selectLevel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Level_Interface levelInterface = new Level_Interface();
				levelInterface.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(selectLevel)).dispose(); // close the window

			}
		});

		panel.add(selectLevel);

	}
}
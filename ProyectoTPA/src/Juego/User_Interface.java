package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the User_Interface of the Snake Challenge game. It
 * allows players to access different options such as play, learn how to play,
 * customize, and exit.
 */
public class User_Interface extends JFrame {

	/**
	 * Constructor of the class that configures the User_Interface. Sets the
	 * size, title, position, and other aspects of the window.
	 */
	public User_Interface() {

		setSize(600, 600); // width height

		setTitle("Snake Challenge"); // set the window title

		setLocationRelativeTo(null); // set the window in the center of the screen
		
		setResizable(false);

		this.getContentPane().setBackground(Color.orange);// set the window color

		components(); // Initialize buttons, images...

		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the User_Interface. Creates a
	 * panel, text labels, and buttons for different options.
	 */
	void components() {

		JPanel panel = new JPanel(); // create a panel
		panel.setBackground(Color.orange); // set the color of the panel
		panel.setLayout(null); // deactivate its design
		this.getContentPane().add(panel); // add the panel to the window

		// Text label (game title)

		JLabel gameTitle = new JLabel(); // create a text label
		gameTitle.setText("SNAKE CHALLENGE"); // set the text of the label
		gameTitle.setBounds(-115, 20, 800, 100);
		gameTitle.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		gameTitle.setForeground(Color.BLACK); // set the text color
		gameTitle.setOpaque(true); // set the ability to paint the label
		gameTitle.setBackground(Color.orange); // change the background color of the label
		gameTitle.setFont(new Font("arial", Font.BOLD, 50)); // set the text font
		panel.add(gameTitle); // add the label to the panel

		// Buttons of the initial screen

		// Play Button

		JButton play = new JButton(); // create the button
		play.setText("Play"); // set text to the button
		play.setBounds(135, 130, 300, 70); // size and position of the button
		play.setEnabled(true); // enable or disable the click
		play.setForeground(Color.BLACK); // button text color
		play.setBackground(Color.WHITE);
		play.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		play.setFocusPainted(false);

		// open the window related to the game levels and close the initial window
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Level_Interface levelsWindow = new Level_Interface();
				levelsWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(play)).dispose(); // close the window
			}
		});
		panel.add(play);

		// How to Play Button

		JButton howToPlay = new JButton(); // create the button
		howToPlay.setText("How to Play"); // set text to the button
		howToPlay.setBounds(135, 295, 300, 70); // size and position of the button
		howToPlay.setEnabled(true); // enable or disable the click
		howToPlay.setForeground(Color.BLACK); // button text color
		howToPlay.setBackground(Color.WHITE);
		howToPlay.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		howToPlay.setFocusPainted(false);

		// open the window related to the game instructions and close the initial window
		howToPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				How_To_Play_Interface howToPlayWindow = new How_To_Play_Interface();
				howToPlayWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(howToPlay)).dispose(); // close the window
			}
		});
		panel.add(howToPlay);

		// Exit Button

		JButton exit = new JButton(); // create the button
		exit.setText("Exit"); // set text to the button
		exit.setBounds(135, 470, 300, 70); // size and position of the button
		exit.setEnabled(true); // enable or disable the click
		exit.setForeground(Color.BLACK); // button text color
		exit.setBackground(Color.WHITE);
		exit.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		exit.setFocusPainted(false);

		// close the main window
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(exit);
	}
}
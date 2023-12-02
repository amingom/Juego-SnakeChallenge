package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the main user interface of the Snake Challenge game. It
 * allows players to access different options such as play, learn how to play,
 * customize, and exit.
 */
public class Interfaz_Usuario extends JFrame {

	/**
	 * Constructor of the class that configures the main user interface. Sets the
	 * size, title, position, and other aspects of the window.
	 */
	public Interfaz_Usuario() {

		setSize(600, 600); // width height

		setTitle("Snake Challenge"); // set the window title

		setLocationRelativeTo(null); // set the window in the center of the screen

		this.getContentPane().setBackground(Color.orange);// set the window color

		iniciarComponentes(); // Initialize buttons, images...

		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the main user interface. Creates a
	 * panel, text labels, and buttons for different options.
	 */
	void iniciarComponentes() {

		JPanel panel = new JPanel(); // create a panel
		panel.setBackground(Color.orange); // set the color of the panel
		panel.setLayout(null); // deactivate its design
		this.getContentPane().add(panel); // add the panel to the window

		// Text label (game title)

		JLabel GameTitle = new JLabel(); // create a text label
		GameTitle.setText("SNAKE CHALLENGE"); // set the text of the label
		GameTitle.setBounds(-115, 20, 800, 100);
		GameTitle.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		GameTitle.setForeground(Color.BLACK); // set the text color
		GameTitle.setOpaque(true); // set the ability to paint the label
		GameTitle.setBackground(Color.orange); // change the background color of the label
		GameTitle.setFont(new Font("arial", Font.BOLD, 50)); // set the text font
		panel.add(GameTitle); // add the label to the panel

		// Buttons of the initial screen

		// Play Button

		JButton Play = new JButton(); // create the button
		Play.setText("Play"); // set text to the button
		Play.setBounds(135, 130, 300, 70); // size and position of the button
		Play.setEnabled(true); // enable or disable the click
		Play.setForeground(Color.BLACK); // button text color
		Play.setBackground(Color.WHITE);
		Play.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		Play.setFocusPainted(false);

		// open the window related to the game levels and close the initial window
		Play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Niveles levelsWindow = new Interfaz_Niveles();
				levelsWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Play)).dispose(); // close the window
			}
		});
		panel.add(Play);

		// How to Play Button

		JButton HowToPlay = new JButton(); // create the button
		HowToPlay.setText("How to Play"); // set text to the button
		HowToPlay.setBounds(135, 295, 300, 70); // size and position of the button
		HowToPlay.setEnabled(true); // enable or disable the click
		HowToPlay.setForeground(Color.BLACK); // button text color
		HowToPlay.setBackground(Color.WHITE);
		HowToPlay.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		HowToPlay.setFocusPainted(false);

		// open the window related to the game instructions and close the initial window
		HowToPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Como_Jugar howToPlayWindow = new Interfaz_Como_Jugar();
				howToPlayWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(HowToPlay)).dispose(); // close the window
			}
		});
		panel.add(HowToPlay);

		// Exit Button

		JButton Exit = new JButton(); // create the button
		Exit.setText("Exit"); // set text to the button
		Exit.setBounds(135, 470, 300, 70); // size and position of the button
		Exit.setEnabled(true); // enable or disable the click
		Exit.setForeground(Color.BLACK); // button text color
		Exit.setBackground(Color.WHITE);
		Exit.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		Exit.setFocusPainted(false);

		// close the main window
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(Exit);
	}
}
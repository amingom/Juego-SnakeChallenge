package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the Level_Interface in the Snake Challenge
 * game. It allows the player to choose from different difficulty levels.
 */
public class Level_Interface extends JFrame {

	static private String level;

	// Method to get the selected level
	public String getLevel() {
		return level;
	}

	// Method to set the value of the level variable
	public static void setLevel(String _level) {
		level = _level;
	}

	/**
	 * Constructor of the class that configures the Level_Interface. Sets
	 * the size, title, position, and other aspects of the window.
	 */
	public Level_Interface() {

		setSize(600, 600); // width height

		setTitle("Snake Challenge"); // set the window title

		setLocationRelativeTo(null); // set the window in the center of the screen
		
		setResizable(false);

		this.getContentPane().setBackground(Color.green); // set the window color

		components(); // Initialize buttons, images...

		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the Level_Interface. Creates a
	 * panel, text labels, and buttons for different difficulty levels.
	 */
	void components() {

		JPanel levels = new JPanel(); // create a panel
		levels.setBackground(Color.green); // set the panel color
		levels.setLayout(null); // disable its layout
		this.getContentPane().add(levels); // add the panel to the window
		JLabel Levels = new JLabel(); // create a text label
		Levels.setText("LEVELS"); // set the text of the label
		Levels.setBounds(-115, 20, 800, 100);
		Levels.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		Levels.setForeground(Color.BLACK); // set the text color
		Levels.setOpaque(true); // set the ability to paint the label
		Levels.setBackground(Color.green); // change the background color of the label
		Levels.setFont(new Font("arial", Font.BOLD, 50)); // set the text font
		levels.add(Levels); // add the label to the panel

		JButton Easy = new JButton(); // create the button
		Easy.setText("Easy"); // set text to the button
		Easy.setBounds(160, 130, 250, 60); // size and position of the button
		Easy.setEnabled(true); // enable or disable the click
		Easy.setForeground(Color.BLACK); // button text color
		Easy.setBackground(Color.WHITE); // button color
		Easy.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		Easy.setFocusPainted(false);

		// Open the window related to snake customization and close the start window
		Easy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLevel("easy");
				Customization_Interface levelCustomizationWindow = new Customization_Interface();
				levelCustomizationWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Easy)).dispose(); // close the window
			}
		});
		levels.add(Easy);

		JButton Medium = new JButton(); // create the button
		Medium.setText("Medium"); // set text to the button
		Medium.setBounds(160, 255, 250, 60); // size and position of the button
		Medium.setEnabled(true); // enable or disable the click
		Medium.setForeground(Color.BLACK); // button text color
		Medium.setBackground(Color.WHITE); // button color
		Medium.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		Medium.setFocusPainted(false);

		// Open the window related to snake customization and close the start window
		Medium.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLevel("medium");
				Customization_Interface customizationWindow = new Customization_Interface();
				customizationWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Medium)).dispose(); // close the window

			}
		});

		levels.add(Medium);

		JButton Hard = new JButton(); // create the button
		Hard.setText("Hard"); // set text to the button
		Hard.setBounds(160, 380, 250, 60); // size and position of the button
		Hard.setEnabled(true); // enable or disable the click
		Hard.setForeground(Color.BLACK); // button text color
		Hard.setBackground(Color.WHITE); // button color
		Hard.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		Hard.setFocusPainted(false);

		// Open the window related to snake customization and close the start window
		Hard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLevel("hard");
				Customization_Interface customizationWindow = new Customization_Interface();
				customizationWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Hard)).dispose(); // close the window

			}
		});

		levels.add(Hard);

		JButton Back = new JButton(); // create the button
		Back.setText("Back"); // set text to the button
		Back.setBounds(10, 510, 150, 40); // size and position of the button
		Back.setEnabled(true); // enable or disable the click
		Back.setForeground(Color.BLACK); // button text color
		Back.setBackground(Color.WHITE); // button color
		Back.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		Back.setFocusPainted(false);
		Back.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				User_Interface initialWindow = new User_Interface();
				initialWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Back)).dispose(); // close the window
			}
		});
		levels.add(Back);
	}
}

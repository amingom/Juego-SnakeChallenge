package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the snake customization interface in the Snake
 * Challenge game. It allows the player to choose from different aspects for the
 * snake.
 */
public class Customization_Interface extends JFrame {

	static private String animal; // Stores the selected snake in the customization interface

	// Method to get the selected animal
	public String getAnimal() {
		return animal;
	}

	// Method to set the value of the animal variable
	public static void setAnimal(String _animal) {
		animal = _animal;
	}

	/**
	 * Constructor of the class that configures the customization interface. Sets
	 * the size, title, position, and other aspects of the window.
	 */
	public Customization_Interface() {

		setSize(600, 600); // width height

		setTitle("Snake Challenge"); // set the window title

		setLocationRelativeTo(null); // set the window in the center of the screen

		this.getContentPane().setBackground(Color.cyan); // set the window color

		components(); // Initialize buttons, images...

		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window

	}

	/**
	 * Initializes the visual components of the customization interface. Creates a
	 * panel, text labels, and buttons for different aspects of the snake.
	 */
	void components() {

		JPanel customize = new JPanel(); // create a panel
		customize.setBackground(Color.cyan); // set the panel color
		customize.setLayout(null); // disable its layout
		this.getContentPane().add(customize); // add the panel to the window

		JLabel snakeCustomization = new JLabel(); // create a text label
		snakeCustomization.setText("CUSTOMIZE"); // set the text of the label
		snakeCustomization.setBounds(-115, 20, 800, 100);
		snakeCustomization.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		snakeCustomization.setForeground(Color.BLACK); // set the text color
		snakeCustomization.setOpaque(true); // set the ability to paint the label
		snakeCustomization.setBackground(Color.cyan); // change the background color of the label
		snakeCustomization.setFont(new Font("arial", Font.BOLD, 50)); // set the text font

		customize.add(snakeCustomization); // add the label to the panel

		JButton cobra = new JButton(); // create the button
		cobra.setText("Cobra"); // set text to the button
		cobra.setBounds(160, 130, 250, 60); // size and position of the button
		cobra.setEnabled(true); // enable or disable the click
		cobra.setForeground(Color.BLACK); // button text color
		cobra.setBackground(Color.WHITE);
		cobra.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		cobra.setFocusPainted(false);

		cobra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("cobra");
				Cobra_Interface CobraWindow = new Cobra_Interface(getAnimal());
				CobraWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(cobra)).dispose(); // close the window

			}
		});

		customize.add(cobra);

		JButton python = new JButton(); // create the button
		python.setText("Python"); // set text to the button
		python.setBounds(160, 255, 250, 60); // size and position of the button
		python.setEnabled(true); // enable or disable the click
		python.setForeground(Color.BLACK); // button text color
		python.setBackground(Color.WHITE);
		python.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		python.setFocusPainted(false);

		python.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("python");
				Python_Interface PitonWindow = new Python_Interface(getAnimal());
				PitonWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(python)).dispose(); // close the window

			}
		});

		customize.add(python);

		JButton viper = new JButton(); // create the button
		viper.setText("Viper"); // set text to the button
		viper.setBounds(160, 380, 250, 60); // size and position of the button
		viper.setEnabled(true); // enable or disable the click
		viper.setForeground(Color.BLACK); // button text color
		viper.setBackground(Color.WHITE);
		viper.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		viper.setFocusPainted(false);

		viper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("viper");
				Viper_Interface ViboraWindow = new Viper_Interface(getAnimal());
				ViboraWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(viper)).dispose(); // close the window

			}
		});

		customize.add(viper);

		JButton back = new JButton(); // create the button
		back.setText("Back"); // set text to the button
		back.setBounds(10, 510, 150, 40); // size and position of the button
		back.setEnabled(true); // enable or disable the click
		back.setForeground(Color.BLACK); // button text color
		back.setBackground(Color.WHITE);
		back.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		back.setFocusPainted(false);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Level_Interface levelWindow = new Level_Interface();
				levelWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(back)).dispose(); // close the window

			}
		});
		customize.add(back);
	}

}
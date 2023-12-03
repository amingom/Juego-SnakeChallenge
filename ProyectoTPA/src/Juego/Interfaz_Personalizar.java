package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the snake customization interface in the Snake
 * Challenge game. It allows the player to choose from different aspects for the
 * snake.
 */
public class Interfaz_Personalizar extends JFrame {

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
	public Interfaz_Personalizar() {

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

		JPanel Customize = new JPanel(); // create a panel
		Customize.setBackground(Color.cyan); // set the panel color
		Customize.setLayout(null); // disable its layout
		this.getContentPane().add(Customize); // add the panel to the window

		JLabel SnakeCustomization = new JLabel(); // create a text label
		SnakeCustomization.setText("CUSTOMIZE"); // set the text of the label
		SnakeCustomization.setBounds(-115, 20, 800, 100);
		SnakeCustomization.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		SnakeCustomization.setForeground(Color.BLACK); // set the text color
		SnakeCustomization.setOpaque(true); // set the ability to paint the label
		SnakeCustomization.setBackground(Color.cyan); // change the background color of the label
		SnakeCustomization.setFont(new Font("arial", Font.BOLD, 50)); // set the text font

		Customize.add(SnakeCustomization); // add the label to the panel

		JButton Cobra = new JButton(); // create the button
		Cobra.setText("Cobra"); // set text to the button
		Cobra.setBounds(160, 130, 250, 60); // size and position of the button
		Cobra.setEnabled(true); // enable or disable the click
		Cobra.setForeground(Color.BLACK); // button text color
		Cobra.setBackground(Color.WHITE);
		Cobra.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		Cobra.setFocusPainted(false);

		Cobra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("cobra");
				Interfaz_Cobra CobraWindow = new Interfaz_Cobra(getAnimal());
				CobraWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Cobra)).dispose(); // close the window

			}
		});

		Customize.add(Cobra);

		JButton Python = new JButton(); // create the button
		Python.setText("Python"); // set text to the button
		Python.setBounds(160, 255, 250, 60); // size and position of the button
		Python.setEnabled(true); // enable or disable the click
		Python.setForeground(Color.BLACK); // button text color
		Python.setBackground(Color.WHITE);
		Python.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		Python.setFocusPainted(false);

		Python.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("python");
				Interfaz_Piton PitonWindow = new Interfaz_Piton(getAnimal());
				PitonWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Python)).dispose(); // close the window

			}
		});

		Customize.add(Python);

		JButton Viper = new JButton(); // create the button
		Viper.setText("Viper"); // set text to the button
		Viper.setBounds(160, 380, 250, 60); // size and position of the button
		Viper.setEnabled(true); // enable or disable the click
		Viper.setForeground(Color.BLACK); // button text color
		Viper.setBackground(Color.WHITE);
		Viper.setFont(new Font("algerian", Font.BOLD, 40)); // button text font
		Viper.setFocusPainted(false);

		Viper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("viper");
				Interfaz_Vibora ViboraWindow = new Interfaz_Vibora(getAnimal());
				ViboraWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Viper)).dispose(); // close the window

			}
		});

		Customize.add(Viper);

		JButton Back = new JButton(); // create the button
		Back.setText("Back"); // set text to the button
		Back.setBounds(10, 510, 150, 40); // size and position of the button
		Back.setEnabled(true); // enable or disable the click
		Back.setForeground(Color.BLACK); // button text color
		Back.setBackground(Color.WHITE);
		Back.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		Back.setFocusPainted(false);
		Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Niveles levelWindow = new Interfaz_Niveles();
				levelWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Back)).dispose(); // close the window

			}
		});
		Customize.add(Back);
	}

}
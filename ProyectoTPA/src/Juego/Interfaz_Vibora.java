package Juego;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the "Vibora" interface in the Snake Challenge game. It
 * provides information about the Snake and its abilities.
 */
public class Interfaz_Vibora extends JFrame {

	/**
	 * Constructor of the class that configures the "Vibora" interface. Sets the
	 * size, title, position, and other aspects of the window.
	 * 
	 * @param animal Parameter that represents the type of animal.
	 */
	public Interfaz_Vibora(String animal) {

		setSize(600, 600); // width height

		setTitle("Snake Challenge"); // set the window title

		setLocationRelativeTo(null); // set the window in the center of the screen

		this.getContentPane().setBackground(Color.green); // set the window color

		iniciarComponentes(); // Initialize buttons, images...

		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the "Vibora" interface. Creates a panel,
	 * text labels, a "Back" button, and a "Start" button.
	 */
	void iniciarComponentes() {

		JPanel viper = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Draw the background image
				ImageIcon backgroundImage = new ImageIcon("img\\vibora.jpg");
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		viper.setLayout(null);
		getContentPane().add(viper);

		JLabel infoLabel = new JLabel(); // create a text label
		infoLabel.setText("Viper Information:\n" + "-Color: blue."); // set the text of the label
		infoLabel.setText("<html>" + infoLabel.getText().replaceAll("\n", "<br/>") + "</html>");
		infoLabel.setBounds(300, -50, 280, 250);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		infoLabel.setForeground(Color.white); // set the text color
		infoLabel.setOpaque(false); // set the ability to paint the label
		infoLabel.setFont(new Font("arial", 0, 25)); // set the text font
		viper.add(infoLabel); // add the label to the panel

		JButton backButton = new JButton(); // create the button
		backButton.setText("Back"); // set text to the button
		backButton.setBounds(10, 510, 150, 40); // size and position of the button
		backButton.setEnabled(true); // enable or disable the click
		backButton.setForeground(Color.black); // color of the letters of the button
		backButton.setBackground(Color.white);
		backButton.setFont(new Font("algerian", Font.BOLD, 20)); // font of the button's letter
		backButton.setFocusPainted(false);
		backButton.setOpaque(true); // set the ability to paint the label
		backButton.setSelected(false);
		LineBorder backButtonBorder = new LineBorder(Color.black); // color the border of the button
		backButton.setBorder(backButtonBorder);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Personalizar customizationWindow = new Interfaz_Personalizar();
				customizationWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(backButton)).dispose(); // close the window
			}
		});
		viper.add(backButton); // add the label to the panel

		JButton startButton = new JButton(); // create the button
		startButton.setText("Start"); // set text to the button
		startButton.setBounds(425, 510, 150, 40); // size and position of the button
		startButton.setEnabled(true); // enable or disable the click
		startButton.setForeground(Color.black); // color of the letters of the button
		startButton.setBackground(Color.white);
		startButton.setFont(new Font("algerian", Font.BOLD, 20)); // font of the button's letter
		startButton.setOpaque(true); // set the ability to paint the label
		startButton.setFocusPainted(false);
		startButton.setSelected(false);
		LineBorder startButtonBorder = new LineBorder(Color.black); // color the border of the button
		startButton.setBorder(startButtonBorder);
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Juego gameInterface = new Interfaz_Juego();
				gameInterface.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(startButton)).dispose(); // close the window

			}
		});
		viper.add(startButton); // add the label to the panel
	}
}
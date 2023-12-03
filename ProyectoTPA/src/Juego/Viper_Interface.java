package Juego;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the "Viper" interface in the Snake Challenge game. It
 * provides information about the Snake and its abilities.
 */
public class Viper_Interface extends JFrame {

	/**
	 * Constructor of the class that configures the "Viper" interface. Sets the
	 * size, title, position, and other aspects of the window.
	 * 
	 * @param animal Parameter that represents the type of animal.
	 */
	public Viper_Interface(String animal) {

		setSize(600, 600); // width height

		setTitle("Snake Challenge"); // set the window title

		setLocationRelativeTo(null); // set the window in the center of the screen
		
		setResizable(false);

		this.getContentPane().setBackground(Color.green); // set the window color

		components(); // Initialize buttons, images...

		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window
	}

	/**
	 * Initializes the visual components of the "Viper" interface. Creates a panel,
	 * text labels, a "Back" button, and a "Start" button.
	 */
	void components() {

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
		infoLabel.setText("Viper Information:\n" + "- Color: blue."); // set the text of the label
		infoLabel.setText("<html>" + infoLabel.getText().replaceAll("\n", "<br/>") + "</html>");
		infoLabel.setBounds(300, -50, 280, 250);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		infoLabel.setForeground(Color.white); // set the text color
		infoLabel.setOpaque(false); // set the ability to paint the label
		infoLabel.setFont(new Font("arial", 0, 25)); // set the text font
		viper.add(infoLabel); // add the label to the panel

		JButton back = new JButton(); // create the button
		back.setText("Back"); // set text to the button
		back.setBounds(10, 510, 150, 40); // size and position of the button
		back.setEnabled(true); // enable or disable the click
		back.setForeground(Color.black); // color of the letters of the button
		back.setBackground(Color.white);
		back.setFont(new Font("algerian", Font.BOLD, 20)); // font of the button's letter
		back.setFocusPainted(false);
		back.setOpaque(true); // set the ability to paint the label
		back.setSelected(false);
		LineBorder backButtonBorder = new LineBorder(Color.black); // color the border of the button
		back.setBorder(backButtonBorder);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Customization_Interface customizationWindow = new Customization_Interface();
				customizationWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(back)).dispose(); // close the window
			}
		});
		viper.add(back); // add the label to the panel

		JButton start = new JButton(); // create the button
		start.setText("Start"); // set text to the button
		start.setBounds(425, 510, 150, 40); // size and position of the button
		start.setEnabled(true); // enable or disable the click
		start.setForeground(Color.black); // color of the letters of the button
		start.setBackground(Color.white);
		start.setFont(new Font("algerian", Font.BOLD, 20)); // font of the button's letter
		start.setOpaque(true); // set the ability to paint the label
		start.setFocusPainted(false);
		start.setSelected(false);
		LineBorder startBorder = new LineBorder(Color.black); // color the border of the button
		start.setBorder(startBorder);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game_Interfece gameInterface = new Game_Interfece();
				gameInterface.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(start)).dispose(); // close the window

			}
		});
		viper.add(start); // add the label to the panel
	}
}
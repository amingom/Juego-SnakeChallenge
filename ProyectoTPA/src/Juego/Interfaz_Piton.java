package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the "Python" interface in the Snake Challenge game. It
 * provides information about the Python and its abilities.
 */

public class Interfaz_Piton extends JFrame {

	/**
	 * Constructor of the class that configures the "Python" interface. Sets the
	 * size, title, position, and other aspects of the window.
	 * 
	 * @param animal Parameter representing the type of animal.
	 */

	public Interfaz_Piton(String animal) {

		setSize(600, 600); // width height

		setTitle("Snake Challenge"); // set the window title

		setLocationRelativeTo(null); // set the window in the center of the screen

		this.getContentPane().setBackground(Color.green); // set the window color

		iniciarComponentes(); // Initialize buttons, images...

		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window

	}

	/**
	 * Initializes the visual components of the "Python" interface. Creates a panel,
	 * text labels, a "Back" button, and a "Start" button.
	 */

	void iniciarComponentes() {

		JPanel python = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Draw the background image
				ImageIcon backgroundImage = new ImageIcon("img\\piton.jpg");
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		python.setLayout(null);
		getContentPane().add(python);

		JLabel Info = new JLabel(); // create a text label
		Info.setText("Python information:\n" + "-Color: Brown."); // set the text of the label
		Info.setText("<html>" + Info.getText().replaceAll("\n", "<br/>") + "</html>");
		Info.setBounds(2, 2, 280, 180);
		Info.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		Info.setForeground(Color.WHITE); // set the text color
		Info.setOpaque(false); // set the ability to paint the label
		Info.setFont(new Font("arial", 0, 25)); // set the text font
		python.add(Info); // add the label to the panel

		JButton Back = new JButton(); // create the button
		Back.setText("Back"); // set text to the button
		Back.setBounds(10, 510, 150, 40); // size and position of the button
		Back.setEnabled(true); // enable or disable the click
		Back.setForeground(Color.BLACK); // button text color
		Back.setBackground(Color.WHITE);
		Back.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		Back.setFocusPainted(false);
		Back.setOpaque(false); // set the ability to paint the label
		Back.setSelected(false);
		Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Personalizar customizationWindow = new Interfaz_Personalizar();
				customizationWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Back)).dispose(); // close the window

			}
		});
		python.add(Back); // add the label to the panel

		JButton Start = new JButton(); // create the button
		Start.setText("Start"); // set text to the button
		Start.setBounds(425, 510, 150, 40); // size and position of the button
		Start.setEnabled(true); // enable or disable the click
		Start.setForeground(Color.WHITE); // button text color
		Start.setBackground(Color.WHITE);
		Start.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		Start.setFocusPainted(false);
		Start.setOpaque(false); // set the ability to paint the label
		Start.setSelected(false);
		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Juego gameWindow = new Interfaz_Juego();
				gameWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Start)).dispose(); // close the window

			}
		});
		python.add(Start); // add the label to the panel
	}
}
package Juego;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the "Python" interface in the Snake Challenge game. It
 * provides information about the Python and its abilities.
 */
public class Python_Interface extends JFrame {

	/**
	 * Constructor of the class that configures the "Python" interface. Sets the
	 * size, title, position, and other aspects of the window.
	 * 
	 * @param animal Parameter representing the type of animal.
	 */
	public Python_Interface(String animal) {

		setSize(600, 600); // width height

		setTitle("Snake Challenge"); // set the window title

		setLocationRelativeTo(null); // set the window in the center of the screen
		
		setResizable(false);

		this.getContentPane().setBackground(Color.green); // set the window color

		components(); // Initialize buttons, images...

		setDefaultCloseOperation(EXIT_ON_CLOSE); // close the program when closing the window

	}

	/**
	 * Initializes the visual components of the "Python" interface. Creates a panel,
	 * text labels, a "Back" button, and a "Start" button.
	 */
	void components() {

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

		JLabel info = new JLabel(); // create a text label
		info.setText("Python information:\n" + "-Color: Brown."); // set the text of the label
		info.setText("<html>" + info.getText().replaceAll("\n", "<br/>") + "</html>");
		info.setBounds(2, 2, 280, 180);
		info.setHorizontalAlignment(SwingConstants.CENTER); // center the text in the label
		info.setForeground(Color.WHITE); // set the text color
		info.setOpaque(false); // set the ability to paint the label
		info.setFont(new Font("arial", 0, 25)); // set the text font
		python.add(info); // add the label to the panel

		JButton back = new JButton(); // create the button
		back.setText("Back"); // set text to the button
		back.setBounds(10, 510, 150, 40); // size and position of the button
		back.setEnabled(true); // enable or disable the click
		back.setForeground(Color.white); // button text color
		back.setBackground(Color.black); // background text color
		back.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		back.setFocusPainted(false);
		back.setOpaque(true); // set the ability to paint the label
		back.setSelected(false);
		LineBorder border_back_cobra = new LineBorder(Color.black);
		back.setBorder(border_back_cobra);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Customization_Interface customizationWindow = new Customization_Interface();
				customizationWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(back)).dispose(); // close the window

			}
		});
		python.add(back); // add the label to the panel

		JButton start = new JButton(); // create the button
		start.setText("Start"); // set text to the button
		start.setBounds(425, 510, 150, 40); // size and position of the button
		start.setEnabled(true); // enable or disable the click
		start.setForeground(Color.white); // button text color
		start.setBackground(Color.black);
		start.setFont(new Font("algerian", Font.BOLD, 20)); // button text font
		start.setFocusPainted(false);
		start.setOpaque(true); // set the ability to paint the label
		start.setSelected(false);
		LineBorder border_start_cobra = new LineBorder(Color.black);
		start.setBorder(border_start_cobra);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game_Interfece gameWindow = new Game_Interfece();
				gameWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(start)).dispose(); // close the window

			}
		});
		python.add(start); // add the label to the panel
	}
}
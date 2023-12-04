package Juego;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the interface of "Cobra" in the game Snake Challenge.
 * Provides information about the Cobra and its abilities.
 */
public class Cobra_Interface extends JFrame {

	/**
	 * Constructor of the class that configures the interface "Cobra". Sets the
	 * size, title, position and other aspects of the window.
	 * 
	 * @param animal Parameter that represents the type of animal.
	 */
	public Cobra_Interface(String animal) {

		setSize(600, 600);
		setTitle("Snake Challenge");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.green);
		components();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Initializes the visual components of the interface "Cobra". Creates a panel,
	 * text labels, a "Back" button and a "Start" button.
	 */
	void components() {

		JPanel cobra = new JPanel() { //make a panel where the image of the "Cobra" appears
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Draws the background image
				ImageIcon backgroundImage = new ImageIcon("img\\cobra.jpg"); //set the image
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null); //set the dimensions of the image
			}
		};
		cobra.setLayout(null);
		getContentPane().add(cobra);

		JLabel info = new JLabel();
		info.setText("Cobra Information:\n" + "- Color: black.\n");  
		info.setText("<html>" + info.getText().replaceAll("\n", "<br/>") + "</html>"); // used to make line breaks
		info.setBounds(2, 2, 280, 180);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setForeground(Color.white);
		info.setOpaque(false);
		info.setFont(new Font("arial", 0, 25));
		cobra.add(info);

		JButton back = new JButton("Back");
		back.setBounds(10, 510, 150, 40);
		back.setEnabled(true);
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.setFont(new Font("algerian", Font.BOLD, 20));
		back.setFocusPainted(false);
		back.setOpaque(true);
		back.setSelected(false);
		LineBorder border_back_cobra = new LineBorder(Color.black);
		back.setBorder(border_back_cobra);
		back.addActionListener(new ActionListener() { // after pressing the back button you will go to the customization Window

			@Override
			public void actionPerformed(ActionEvent e) {
				Customization_Interface customizationWindow = new Customization_Interface();
				customizationWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(back)).dispose();
			}
		});
		cobra.add(back);

		JButton start = new JButton("Start");
		start.setBounds(425, 510, 150, 40);
		start.setEnabled(true);
		start.setForeground(Color.white);
		start.setBackground(Color.black);
		start.setFont(new Font("algerian", Font.BOLD, 20));
		start.setFocusPainted(false);
		start.setOpaque(true);
		start.setSelected(false);
		LineBorder border_start_cobra = new LineBorder(Color.black);
		start.setBorder(border_start_cobra);
		start.addActionListener(new ActionListener() { // after pressing the start button you will go to the game Window

			@Override
			public void actionPerformed(ActionEvent e) {
				Game_Interfece gameWindow = new Game_Interfece();
				gameWindow.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(start)).dispose();
			}
		});
		cobra.add(start);
	}
}
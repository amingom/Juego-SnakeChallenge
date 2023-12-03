package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Bar class represents a loading bar for a game. It includes a
 * progress bar with a background image and handles the loading process with a
 * timer.
 */
public class Bar extends LoadingBar {

	private JProgressBar progressBar; 
	private Timer timer;
	private int progress;
	private JFrame frame;

	/**
	 * Constructs a new Bar object. Initializes the frame and sets up the
	 * user interface components, including a background image panel and a progress
	 * bar.
	 */
	public Bar() {
		frame = new JFrame("SNAKE CHALLENGE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Panel with background image
		JPanel panel = new JPanel() {
			Image backgroundImage = new ImageIcon("img//fondo_barra.png").getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, 500, 300, this);
			}
		};

		// Progress bar
		progressBar = new JProgressBar(0, 40);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.MAGENTA); // Purple color

		timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				progress += 1; // add one percent to the loading bar 
				progressBar.setValue(progress);

				if (progress == 100) { // when it comes to 100 percent it close the loading bar and open another interface
					timer.stop();
					frame.dispose();
					completeCharge();
				}
			}
		});

		// Set layout to null for manual component positioning
		panel.setLayout(null);

		// Position the progress bar at the bottom and wider
		progressBar.setBounds(0, 300, 500, 61);

		// Add the progress bar to the panel
		panel.add(progressBar);

		// Add the panel to the frame
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}

	/**
	 * Displays the loading frame and starts the timer.
	 */
	public void charge() {
		frame.setVisible(true);
		timer.start();
	}

	/**
	 * Disposes of the frame and opens a new user interface when the loading process
	 * is complete.
	 */
	public void completeCharge() {
		frame.dispose();
		new User_Interface().setVisible(true);
	}
}

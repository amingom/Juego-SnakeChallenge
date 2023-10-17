package Juego;

/**
 * Esta clase representa la interfaz del juego Snake Challenge en el nivel facil.
 * Permite a los jugadores jugar el juego en un nivel de dificultad mas bajo.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class Interfaz_juego_facil extends JFrame {
	private JPanel gamePanel;
	private LinkedList<Point> snake;
	private Timer timer;
	private int direction;
	
	/**
     * Constructor de la clase que configura la interfaz del juego en el nivel facil.
     * Establece el tamaño, titulo, posicion y otros aspectos de la ventana.
     */
	public Interfaz_juego_facil() {
		setSize(720, 665);
		setTitle("Snake Challenge");
		setLocationRelativeTo(null);
		iniciarComponentes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
     * Inicializa los componentes visuales del juego, como el tablero, la serpiente y el temporizador.
     */
	void iniciarComponentes() {
		JPanel NivelFacil = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon backgroundImage = new ImageIcon("tablero.jpg");
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		NivelFacil.setLayout(null);
		getContentPane().add(NivelFacil);

		// Crea una etiqueta que representa la serpiente
		gamePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw(g);
			}
		};
		gamePanel.setBounds(0, 0, 720, 640);
		gamePanel.setOpaque(false); // Hace que el fondo del gamePanel sea transparente
		NivelFacil.add(gamePanel);

		// Inicializa la serpiente
		snake = new LinkedList<>();
		snake.add(new Point(5, 5));
		direction = KeyEvent.VK_RIGHT;

		// Agrega un temporizador para mover la serpiente
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				move();
				gamePanel.repaint();
			}
		});

		timer.start();

		NivelFacil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_W && direction != KeyEvent.VK_DOWN) {
					direction = KeyEvent.VK_UP;
				} else if (keyCode == KeyEvent.VK_S && direction != KeyEvent.VK_UP) {
					direction = KeyEvent.VK_DOWN;
				} else if (keyCode == KeyEvent.VK_A && direction != KeyEvent.VK_RIGHT) {
					direction = KeyEvent.VK_LEFT;
				} else if (keyCode == KeyEvent.VK_D && direction != KeyEvent.VK_LEFT) {
					direction = KeyEvent.VK_RIGHT;
				}
			}
		});

		NivelFacil.setFocusable(true);
	}

	/**
     * Dibuja la serpiente en el juego.
     * @param g El objeto Graphics utilizado para dibujar la serpiente.
     */
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		for (Point segment : snake) {
			g.fillRect(segment.x * 20, segment.y * 20, 20, 20);
		}
	}

	/**
     * Mueve la serpiente en la direccion actual.
     * Actualiza la posicion de la serpiente en funcion de la direccion.
     */
	public void move() {
		int headX = snake.getFirst().x;
		int headY = snake.getFirst().y;

		switch (direction) {
		case KeyEvent.VK_UP:
			snake.addFirst(new Point(headX, headY - 1));
			break;
		case KeyEvent.VK_DOWN:
			snake.addFirst(new Point(headX, headY + 1));
			break;
		case KeyEvent.VK_LEFT:
			snake.addFirst(new Point(headX - 1, headY));
			break;
		case KeyEvent.VK_RIGHT:
			snake.addFirst(new Point(headX + 1, headY));
			break;
		}

		snake.removeLast();
	}

}

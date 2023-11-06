package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.JOptionPane; //sirve para mostrar un cuadro al usuario para avisar que ha perdido

/**
 * Esta clase representa la interfaz del juego Snake Challenge en el nivel facil.
 * Permite a los jugadores jugar el juego en un nivel de dificultad mas bajo.
 */

public class Interfaz_juego_facil extends JFrame {
	private JPanel gamePanel;
	private LinkedList<Point> snake;
	private Timer timer;
	private int direction;
	private Point food;
	
	/**
     * Constructor de la clase que configura la interfaz del juego en el nivel facil.
     * Establece el tamano, titulo, posicion y otros aspectos de la ventana.
     */
	public Interfaz_juego_facil() {
		setSize(720, 665);							//tamaño de la ventana
		setTitle("Snake Challenge");				//título de la ventana
		setLocationRelativeTo(null);				//establecer en el centro de la pantalla
		iniciarComponentes();						//inicia el juego
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//cierra el programa al dar a la X
	}

	/**
     * Inicializa los componentes visuales del juego, como el tablero, la serpiente, el temporizador y los alimentos.
     */
	void iniciarComponentes() {
		JPanel NivelFacil = new JPanel() {							//Crea el panel del modo fácil
			@Override
			protected void paintComponent(Graphics g) {				
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon backgroundImage = new ImageIcon("tablero.jpg");			//imagen del fondo
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);		//establece las medidas de la imagen a las de la ventana
			}
		};
		NivelFacil.setLayout(null);					//desactiva el diseño
		getContentPane().add(NivelFacil);			//añade el panel

		// Crea una etiqueta que representa la serpiente
		gamePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw(g);
			}
		};
		gamePanel.setBounds(0, 0, 720, 640);		//establece el tamaño
		gamePanel.setOpaque(false); // Hace que el fondo del gamePanel sea transparente
		NivelFacil.add(gamePanel);

		// Inicializa la serpiente
		snake = new LinkedList<>();
		snake.add(new Point(5, 5));		//posición inicial de la serpiente
		direction = KeyEvent.VK_RIGHT;	//la serpiente comienza a moverse hacia la derecha

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
		
		
	    spawnFood(); // Inicializa la comida en una posición aleatoria
	}
	
	/**
	 * Genera una posición aleatoria para la comida en el tablero.
	 */
	public void spawnFood() {
	    int maxX = 35; // Rango máximo de columnas
	    int maxY = 31; // Rango máximo de filas
	    int foodX, foodY;

	    // Genera una posición aleatoria hasta que sea válida y que sea en una coordenada diferente a la serpiente
	    do {
	        foodX = (int) (Math.random() * maxX); 
	        foodY = (int) (Math.random() * maxY);
	    } while (snake.contains(new Point(foodX, foodY)));

	    food = new Point(foodX, foodY);
	}

	/**
     * Dibuja la serpiente y el alimento en el juego.
     * @param g El objeto Graphics utilizado para dibujar la serpiente y el alimento.
     */
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		for (Point segment : snake) {
			g.fillRect(segment.x * 20, segment.y * 20, 20, 20);
		}
		
		// Genera la comida
	    g.setColor(Color.RED); // establece el color
	    g.fillRect(food.x * 20, food.y * 20, 20, 20);  //establecer el tamaño del alimento
	}
	
	/**
	 * Verifica si la serpiente ha colisionado con los bordes del juego o con su propio cuerpo.
	 * Si ha colisionado, detiene el temporizador y muestra un mensaje de game over.
	 */
	public void checkCollision() {
	    Point head = snake.getFirst();
	    
	    // Verifica si la serpiente choca con el borde del juego
	    if (head.x < 0 || head.x >= 35 || head.y < 0 || head.y >= 32) {
	        timer.stop(); // Detiene el temporizador
	        JOptionPane.showMessageDialog(this, "¡Game Over! Has chocado con el borde.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	    }
	    
	    // Verifica si la serpiente se choca con su propio cuerpo
	    if (snake.size() > 1 && snake.subList(1, snake.size()).contains(head)) {
	        timer.stop(); // Detiene el temporizador
	        JOptionPane.showMessageDialog(this, "¡Game Over! Has chocado con tu propio cuerpo.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
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
		
		// Verifica si la serpiente ha comido
	    if (snake.getFirst().equals(food)) {
	        // Hace crecer la serpiente
	        spawnFood(); // Genera otra posición para la comida
	    } else {
	        snake.removeLast();
	    }
		checkCollision(); //verifica la colisión de la serpiente con la pared

	}

}

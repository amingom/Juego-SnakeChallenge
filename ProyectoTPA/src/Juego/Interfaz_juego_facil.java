package Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
	private int foodType;  // Representa el tipo de alimento actual
	private int score;     // Representa la puntuación del jugador
	private JLabel scoreLabel;
	private BufferedImage headImage;
	private BufferedImage bodyImage;
	private Point obstacle;
	private BufferedImage obstacleImage;
	private Interfaz_Personalizar animal;
	private long lastDirectionChangeTime = System.currentTimeMillis();
	private static final long tiempoMinimo = 100; // Tiempo mínimo entre cambios de dirección en milisegundos

	public int getScore() {
		return score;
	}

	public void setScore(int _score) {
		score = _score;
	}

	/**
	 * Constructor de la clase que configura la interfaz del juego en el nivel facil.
	 * Establece el tamano, titulo, posicion y otros aspectos de la ventana.
	 */
	public Interfaz_juego_facil() {
		setSize(720, 750);							//tamaño de la ventana
		setTitle("Snake Challenge");				//título de la ventana
		setLocationRelativeTo(null);				//establecer en el centro de la pantalla
		iniciarComponentes();						//inicia el juego
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//cierra el programa al dar a la X
		animal = new Interfaz_Personalizar();
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
				ImageIcon backgroundImage = new ImageIcon("img\\tablero.png");			//imagen del fondo
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);		//establece las medidas de la imagen a las de la ventana
			}
		};
		NivelFacil.setLayout(null);					//desactiva el diseño
		getContentPane().add(NivelFacil);			//añade el panel

		JPanel marcador = new JPanel();
		marcador.setBounds(0, -5, 720, 35);
		marcador.setBackground(Color.GRAY); // Puedes cambiar el color según tus necesidades

		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, -5, 720, 35);
		ImageIcon defaultImage = new ImageIcon("img\\marcador.png");
		imageLabel.setIcon(defaultImage);

		marcador.add(imageLabel);
		NivelFacil.add(marcador);

		// Crea una etiqueta que representa la serpiente
		gamePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw(g);
			}
		};
		gamePanel.setBounds(0, 30, 720, 720);		//establece el tamaño
		gamePanel.setOpaque(false); // Hace que el fondo del gamePanel sea transparente
		NivelFacil.add(gamePanel);

		// Inicializa la serpiente
		snake = new LinkedList<>();
		snake.add(new Point(5, 5));		//posición inicial de la serpiente
		direction = KeyEvent.VK_RIGHT;	//la serpiente comienza a moverse hacia la derecha

		// Nuevo componente JLabel para mostrar la puntuación
		scoreLabel = new JLabel("0", SwingConstants.CENTER);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(73, 5, 770, 20);
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		imageLabel.add(scoreLabel);

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
				long currentTime = System.currentTimeMillis();
				// Verifica el tiempo desde el último cambio de dirección
				if ((currentTime - lastDirectionChangeTime) >= tiempoMinimo) {
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
					lastDirectionChangeTime = currentTime; // Actualiza el tiempo del último cambio de dirección
				}
			}
		});

		NivelFacil.setFocusable(true);


		spawnFood(); // Inicializa la comida en una posición aleatoria

		try {
			obstacleImage = ImageIO.read(new File("img\\Enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Genera una posición aleatoria para la comida en el tablero.
	 */
	public void spawnFood() {
		int maxX = 35; // Rango máximo de columnas
		int maxY = 34; // Rango máximo de filas
		int foodX, foodY;

		// Genera una posición aleatoria hasta que sea válida y que sea en una coordenada diferente a la serpiente
		do {
			foodX = (int) (Math.random() * maxX); 
			foodY = (int) (Math.random() * maxY);
		} while (snake.contains(new Point(foodX, foodY)));

		// Elige aleatoriamente el tipo de alimento y su puntuación
		foodType = (int) (Math.random() * 3); // 0: manzana, 1: cereza, 2: plátano

		food = new Point(foodX, foodY);

		// Genera una posición aleatoria para el obstáculo hasta que sea válida y que sea en una coordenada diferente a la serpiente y a la comida
		do {
			obstacle = new Point((int) (Math.random() * maxX), (int) (Math.random() * maxY));
		} while (snake.contains(obstacle) || obstacle.equals(food));
	}

	/**
	 * Dibuja la serpiente y el alimento en el juego.
	 * @param g El objeto Graphics utilizado para dibujar la serpiente y el alimento.
	 */
	public void draw(Graphics g) {


		for (int i = 0; i < snake.size(); i++) {
			Point segment = snake.get(i);
			if (i == 0) {
				drawHeadImage(g, segment.x * 20, segment.y * 20);
			} else {
				drawBodyImage(g, segment.x * 20, segment.y * 20);
			}
		}


		// Dibuja el alimento según su tipo
		if (foodType == 0) {
			drawFoodImage(g, "img\\apple.png");
		} else if (foodType == 1) {
			drawFoodImage(g, "img\\cherry.png");
		} else if (foodType == 2) {
			drawFoodImage(g, "img\\banana.png");
		}

		// Dibuja el obstáculo
		g.drawImage(obstacleImage, obstacle.x * 20, obstacle.y * 20, 20, 20, this);

	}

	// Método para dibujar la cabeza según el tipo de la serpiente
	private void drawHeadImage(Graphics g, int x, int y) {

		try {

			switch (direction) {
			case KeyEvent.VK_UP:
				if(animal.getAnimal() == "cobra") {
					headImage = ImageIO.read(new File("img\\cobra_cabeza_arriba.png"));	
				}
				else if(animal.getAnimal() == "piton") {
					headImage = ImageIO.read(new File("img\\piton_cabeza_arriba.png"));
				}
				else if(animal.getAnimal() == "vibora") {
					headImage = ImageIO.read(new File("img\\vibora_cabeza_arriba.png"));
				}
				break;
			case KeyEvent.VK_DOWN:
				if(animal.getAnimal() == "cobra") {
					headImage = ImageIO.read(new File("img\\cobra_cabeza_abajo.png"));
				}
				else if(animal.getAnimal() == "piton"){
					headImage = ImageIO.read(new File("img\\piton_cabeza_abajo.png"));
				}
				else if(animal.getAnimal() == "vibora") {
					headImage = ImageIO.read(new File("img\\vibora_cabeza_abajo.png"));
				}
				break;
			case KeyEvent.VK_LEFT:
				if(animal.getAnimal() == "cobra") {
					headImage = ImageIO.read(new File("img\\cobra_cabeza_izquierda.png"));
				}
				else if(animal.getAnimal() == "piton") {
					headImage = ImageIO.read(new File("img\\piton_cabeza_izquierda.png"));
				}
				else if(animal.getAnimal() == "vibora") {
					headImage = ImageIO.read(new File("img\\vibora_cabeza_izquierda.png"));
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(animal.getAnimal() == "cobra") {
					headImage = ImageIO.read(new File("img\\cobra_cabeza_derecha.png"));
				}
				else if(animal.getAnimal() == "piton") {
					headImage = ImageIO.read(new File("img\\piton_cabeza_derecha.png"));
				}
				else if(animal.getAnimal() == "vibora") {
					headImage = ImageIO.read(new File("img\\vibora_cabeza_derecha.png"));
				}
				break;
			default:
				headImage = ImageIO.read(new File("img\\cobra_cabeza_derecha.png"));
				break;
			}
			g.drawImage(headImage, x, y, 20, 20, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Método para dibujar el cuerpo según el tipo de serpiente
	private void drawBodyImage(Graphics g, int x, int y) {
		try {
			if(animal.getAnimal() == "cobra") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_cobra.png"));	
			}
			else if(animal.getAnimal() == "piton") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_piton.png"));
			}
			else if(animal.getAnimal() == "vibora") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_vibora.png"));
			}
			g.drawImage(bodyImage, x, y, 20, 20, this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Dibuja la imagen de la comida con fondo transparente.
	 * @param g El objeto Graphics utilizado para dibujar.
	 * @param imgPath La ruta de la imagen de la comida.
	 */
	private void drawFoodImage(Graphics g, String imgPath) {
		try {
			BufferedImage foodImage = ImageIO.read(new File(imgPath));
			// Dentro del método drawFoodImage
			g.drawImage(foodImage, food.x * 20, food.y * 20, 25, 25, this);  // Aumenta el tamaño de la imagen de la comida a 40x40 píxeles
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verifica si la serpiente ha colisionado con los bordes del juego o con su propio cuerpo.
	 * Si ha colisionado, detiene el temporizador y muestra un mensaje de game over.
	 */
	public void checkCollision() {
		Point head = snake.getFirst();

		// Verifica si la serpiente choca con el borde del juego
		if (head.x < 0 || head.x >= 35 || head.y < 0 || head.y >= 34) {
			timer.stop(); // Detiene el temporizador
			dispose();
			abrirNuevaInterfaz();
		}

		// Verifica si la serpiente se choca con su propio cuerpo
		if (snake.size() > 1 && snake.subList(1, snake.size()).contains(head)) {
			timer.stop(); // Detiene el temporizador
			dispose();
			abrirNuevaInterfaz();
		}

		// Verifica si la serpiente choca con el obstáculo
		if (snake.getFirst().equals(obstacle)) {
			timer.stop(); // Detiene el temporizador
			dispose();
			abrirNuevaInterfaz();
		}

	}

	private void abrirNuevaInterfaz() {
		// Crea una nueva interfaz o ventana aquí

		Interfaz_Pantalla_final pantalla_final = new Interfaz_Pantalla_final(this); 
		pantalla_final.setVisible(true);

	}

	/**
	 * Mueve la serpiente en la dirección actual.
	 * Actualiza la posición de la serpiente en función de la dirección.
	 */
	public void move() {
		int headX = snake.getFirst().x;
		int headY = snake.getFirst().y;

		// Guarda la longitud actual de la serpiente antes de moverla

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

			// Hace crecer la serpiente según el tipo de alimento
			for (int i = 1; i < getGrowthAmount(); i++) {
				snake.addLast(new Point(-1, -1)); // Añade segmentos los pixeles correspondientes para el crecimiento
			}

			// Actualiza la puntuación total
			score += foodType + 1;

			// Genera otra posición para el alimento
			spawnFood();

		} else {
			snake.removeLast();
		}

		checkCollision(); // Verifica la colisión de la serpiente con la pared
		updateScoreLabel(); // Actualiza el JLabel de puntuación

	}

	/**
	 * Actualiza el JLabel de puntuación con la puntuación total.
	 */
	private void updateScoreLabel() {
		scoreLabel.setText("" + getScore());
	}

	/**
	 * Obtiene la cantidad de segmentos que debe crecer la serpiente según el tipo de alimento.
	 * @return La cantidad de segmentos que debe crecer la serpiente.
	 */
	private int getGrowthAmount() {
		switch (foodType) {
		case 0: // Manzana
			return 1;
		case 1: // Cereza
			return 2;
		case 2: // Plátano
			return 3;
		default:
			return 0;
		}
	}
}
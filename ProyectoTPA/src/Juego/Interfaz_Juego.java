package Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Esta clase representa la interfaz del juego Snake Challenge en el nivel facil.
 * Permite a los jugadores jugar el juego en un nivel de dificultad mas bajo.
 */

public class Interfaz_Juego extends JFrame {
	private JPanel gamePanel;  // Sirve para representar visualmente el juego
	private LinkedList<Point> snake; //Representa la serpiente
	private Timer timer;  // Sirve para gestionar el tiempo en el juego
	private int direction;  // Almacena la dirección de movimiento de la serpiente
	private Point food;  //Representa la posición de la comida
	private int foodType;  // Representa el tipo de alimento actual
	private int score;     // Representa la puntuación del jugador
	private JLabel scoreLabel;  //Se utiliza para mostrar la puntuación 
	private BufferedImage headImage;  // Almacena la imagen de la cabeza
	private BufferedImage bodyImage; // Almacena la imagen del cuerpo
	private LinkedList<Point> obstacles; // Almacena las posiciones de los obstáculos
	private BufferedImage obstacleImage; // Almacena la imagen obstáculo
	private Interfaz_Personalizar animal; // Sirve para saber la serpiente elegida por el usuario
	private long lastDirectionChangeTime = System.currentTimeMillis(); // Sirve para guardar el último cambio de dirección de la serpiente
	private static final long tiempoMinimo = 90; // Tiempo mínimo entre cambios de dirección en milisegundos
	private Interfaz_Niveles nivel; // Sirve para saber el nivel elegido por el usuario
	private int velocidad; //Almacena el valor de la velocidad como numero entero
	private int cantidadObstaculos; //Almacena la cantidad de obstáculos

	/**
	 * Obtiene la punciacion actual del objeto
	 * @return La puntuacion actual del objeto
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Establece el valor de la puntuacion del objeto
	 * @param _score El nuevo valor de la puntuacion a establecer
	 */
	public void setScore(int _score) {
		score = _score;
	}

	/**
	 * Constructor de la clase Interfaz_Juego que inicializa la ventana del juego de la serpiente
	 * Establece el tamaño, título, ubicación y otros componentes para la interfaz gráfica del juego.
	 */
	public Interfaz_Juego() {
		setSize(495, 488);							//establece el tamaño de la ventana
		setTitle("Snake Challenge");				//establece el título de la ventana
		setLocationRelativeTo(null);				//establece la pantalla en el centro
		animal = new Interfaz_Personalizar();		//inicializa la interfaz de personalización
		nivel = new Interfaz_Niveles();				//inicializa la interfaz de niveles
		iniciarComponentes();						//inicia los componentes del juego
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//cierra el programa al dar a la X
	}

	/**
	 * Inicializa los componentes necesarios para el juego de la serpiente en los distintos modos de juego
	 * Se establecen paneles, imágenes, la serpiente, la puntuación, la velocidad y los controles del juego.
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
		marcador.setBounds(0, -5, 500, 35);
		marcador.setBackground(Color.GRAY); // Color del fondo del marcador

		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, -5, 500, 35);
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
		gamePanel.setBounds(0, 30, 500, 500);		//establece el tamaño
		gamePanel.setOpaque(false); // Hace que el fondo del gamePanel sea transparente
		NivelFacil.add(gamePanel);

		// Inicializa la serpiente
		snake = new LinkedList<>();
		snake.add(new Point(5, 5));		//posición inicial de la serpiente
		direction = KeyEvent.VK_RIGHT;	//la serpiente comienza a moverse hacia la derecha

		// Nuevo componente JLabel para mostrar la puntuación
		scoreLabel = new JLabel("0", SwingConstants.CENTER);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(209, 6, 500, 20);
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		imageLabel.add(scoreLabel);

		Velocidad velocidadInicial = new VelocidadInicial();
		Velocidad serpienteLenta = new SlowSpeed(velocidadInicial);
		Velocidad serpienteMedia = new MediumSpeed(serpienteLenta);
		Velocidad serpienteRapida = new FastSpeed(serpienteMedia);

		// Agrega un temporizador para mover la serpiente
		if(nivel.getNivel() == "facil") {

			//Se decora la velocidad a lenta
			velocidad = serpienteLenta.getVelocidad();

		}else if(nivel.getNivel() == "medio") {

			//Se decora la velocidad a media
			velocidad = serpienteMedia.getVelocidad();

		}else if(nivel.getNivel() == "dificil") {

			//Se decora la velocidad a rapida
			velocidad = serpienteRapida.getVelocidad();
			
		}
		timer = new Timer(velocidad, new ActionListener() { //velocidad de la serpiente
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
		spawnEnemy(); // Inicializa los obstáculos en posiciones aleatorias

		try {
			obstacleImage = ImageIO.read(new File("img\\Enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Genera una posición aleatoria para la comida en el tablero.
	 * La posición se elige aleatoriamente y debe ser diferente de la posición actual de la serpiente.
	 * Selecciona aleatoriamente el tipo de alimento y asigna su posición.
	 * Si el número total de píxeles en el tablero está ocupado por la serpiente y los obstáculos, detiene el temporizador y muestra la ventana de victoria.
	 */
	public void spawnFood() {
		int maxX = 24; // Rango máximo de columnas
		int maxY = 21; // Rango máximo de filas
		int foodX, foodY;
		int totalPixels = maxX * maxY; // Ancho * Alto del tablero

		// Genera una posición aleatoria hasta que sea válida y que sea en una coordenada diferente a la serpiente
		do {
			foodX = (int) (Math.random() * maxX); 
			foodY = (int) (Math.random() * maxY);
		} while (snake.contains(new Point(foodX, foodY)));

		// Elige aleatoriamente el tipo de alimento y su puntuación
		foodType = (int) (Math.random() * 3); // 0: manzana, 1: cereza, 2: plátano

		food = new Point(foodX, foodY);
		
		//Verifica si todos los píxeles del tablero están ocupados por la serpiente y los obstaculos
		if (totalPixels == snake.size() + cantidadObstaculos) {
			timer.stop(); // Detiene el temporizador
			dispose();
			Victoria();	// Muestra la ventana de victoria

		}

	}

	/**
	 * Compruba si hay un obstáculo en una posición específica del tablero.
	 * 
	 * @param position La posicion para verificar si contiene un obstaculo
	 * @return true si hay un obstaculo en la posicion dado, false en caso contrario
	 */
	public boolean obstacleAtPosition(Point position) {
		return obstacles != null && obstacles.contains(position);
	}

	/**
	 * Genera y coloca obstáculos en el tablero del juego, según el nivel de dificultad seleccionado.
	 * La cantidad y posición de los obstáculos varía según el nivel.
	 */
	public void spawnEnemy() {
		int maxX = 24; // Rango máximo de columnas
		int maxY = 21; // Rango máximo de filas

		obstacles = new LinkedList<>(); // Lista para almacenar posiciones de obstáculos

		// Determina la cantidad de obstáculos según el nivel
		if (nivel.getNivel() == "facil") {
			cantidadObstaculos = 1;
		} else if (nivel.getNivel() == "medio") {
			cantidadObstaculos = 3;
		} else if (nivel.getNivel() == "dificil") {
			cantidadObstaculos = 5;
		}

		// Genera y coloca los obstáculos en posiciones aleatorias
		for (int i = 0; i < cantidadObstaculos; i++) {
			Point obstaclePosition;
			int minDistance = 2; // Mínima distancia permitida entre la cabeza y el obstáculo

			// Genera una posición aleatoria para el obstáculo hasta que sea válida y que sea diferente a la serpiente, la comida y otros obstáculos
			do {
				obstaclePosition = new Point((int) (Math.random() * maxX), (int) (Math.random() * maxY));
				minDistance--; // Reducimos la distancia mínima
			} while (snake.contains(obstaclePosition) || obstaclePosition.equals(food) || obstacleAtPosition(obstaclePosition) || isObstacleTooCloseToHead(obstaclePosition, minDistance));

			obstacles.add(obstaclePosition);
		}
	}

	private boolean isObstacleTooCloseToHead(Point obstaclePosition, int minDistance) {
		Point head = snake.getFirst();

		return Math.abs(head.x - obstaclePosition.x) < minDistance || Math.abs(head.y - obstaclePosition.y) < minDistance;
	}

	/**
	 * Dibuja los elementos del juego en el tablero, incluyendo la serpiente, la comida y los obstáculos.
	 * @param g Objeto Graphics utilizado para dibujar la serpiente, los alimentos y los obstaculos.
	 */
	public void draw(Graphics g) {

		// Dibuja cada segmento de la serpiente
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

		// Dibuja los obstáculos
		for (Point obstaclePosition : obstacles) {
			g.drawImage(obstacleImage, obstaclePosition.x * 20, obstaclePosition.y * 20, 20, 20, this);
		}

	}

	/**
	 * Dibuja la cabeza de la serpiente en la posición especificada en el tablero.
	 * La imagen de la cabeza varía según la dirección de movimiento y el tipo de animal seleccionado.
	 * @param g Objeto Graphics utilizado para dibujar en el componente.
	 * @param x	Coordenada x de la posición de la cabeza en el tablero.
	 * @param y	Coordenada y de la posición de la cabeza en el tablero.
	 */
	private void drawHeadImage(Graphics g, int x, int y) {

		try {
			// Selecciona la imagen de la cabeza según la dirección de movimiento y el tipo de animal
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
				// Por defecto, se utiliza la imagen de la cabeza de la cobra hacia la derecha
				headImage = ImageIO.read(new File("img\\cobra_cabeza_derecha.png"));
				break;
			}
			// Dibuja la imagen de la cabeza en la posición especificada
			g.drawImage(headImage, x, y, 20, 20, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Dibuja un segmento del cuerpo de la serpiente en la posición especificada en el tablero.
	 * La imagen del cuerpo varía según el tipo de animal seleccionado.
	 * 
	 * @param g Objeto Graphics utilizado para dibujar en el componente.
	 * @param x Coordenada x de la posición del cuerpo en el tablero.
	 * @param y Coordenada y de la posición del cuerpo en el tablero.
	 */
	private void drawBodyImage(Graphics g, int x, int y) {
		try {
			// Selecciona la imagen del cuerpo según el tipo de animal
			if(animal.getAnimal() == "cobra") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_cobra.png"));	
			}
			else if(animal.getAnimal() == "piton") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_piton.png"));
			}
			else if(animal.getAnimal() == "vibora") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_vibora.png"));
			}
			// Dibuja la imagen del cuerpo en la posición especificada
			g.drawImage(bodyImage, x, y, 20, 20, this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Dibuja la imagen del alimento en el tablero en la posición especificada.
	 * 
	 * @param g Objeto Graphics utilizado para dibujar en el componente.
	 * @param imgPath Ruta del archivo de imagen del alimento.
	 */
	private void drawFoodImage(Graphics g, String imgPath) {
		try {
			BufferedImage foodImage = ImageIO.read(new File(imgPath));
			// Dibuja la imagen del alimento en la posición especificada, modificando el tamaño al proporcionado
			g.drawImage(foodImage, food.x * 20, food.y * 20, 20, 20, this); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verifica si la serpiente ha colisionado con los bordes del juego, con su propio cuerpo o con un obstaculo.
	 * Si ha colisionado, detiene el temporizador y muestra la ventana de derrota.
	 */
	public void checkCollision() {
		Point head = snake.getFirst();

		// Verifica si la serpiente choca con el borde del juego
		if (head.x < 0 || head.x >= 24 || head.y < 0 || head.y >= 21) {
			timer.stop(); // Detiene el temporizador
			dispose();
			Derrota();	// Muestra la ventana de derrota
		}

		// Verifica si la serpiente se choca con su propio cuerpo
		if (snake.size() > 1 && snake.subList(1, snake.size()).contains(head)) {
			timer.stop(); // Detiene el temporizador
			dispose();
			Derrota();	// Muestra la ventana de derrota
		}

		// Verifica si la serpiente choca con el obstáculo
		if (obstacles.contains(snake.getFirst())) {
			timer.stop(); // Detiene el temporizador
			dispose();
			Derrota();	// Muestra la ventana de derrota
		}	

	}

	/**
	 * Muestra la interfaz de derrota cuando se cumplen las condiciones que hacen que finalice el juego cuando se pierde.
	 * Crea una nueva instancia de la clase Interfaz_Derrota y la hace visible.
	 */
	private void Derrota() {
		// Crea una nueva interfaz de derrota

		Interfaz_Derrota pantalla_Derrota = new Interfaz_Derrota(this); 
		pantalla_Derrota.setVisible(true);

	}

	/**
	 * Muestra la interfaz de victoria cuando se cumplen las condiciones que hacen que finalice el juego cuando se gana.
	 * Crea una nueva instancia de la clase Interfaz_Victoria y la hace visible.
	 */
	private void Victoria() {
		// Crea una nueva interfaz de victoria

		Interfaz_Victoria pantalla_Victoria = new Interfaz_Victoria(this); 
		pantalla_Victoria.setVisible(true);

	}

	/**
	 * Realiza el movimiento de la serpiente en el tablero, según la dirección actual.
	 * Verifica si la serpiente ha comido, ajusta su longitud y actualiza la puntuación.
	 */
	public void move() {
		int headX = snake.getFirst().x;
		int headY = snake.getFirst().y;

		// Guarda la longitud actual de la serpiente antes de moverla

		// Realiza el movimiento según la dirección actual
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
				snake.addLast(new Point(-1, -1)); // Añade los segmentos correspondientes para el crecimiento
			}

			// Actualiza la puntuación total
			score += foodType + 1;

			// Genera otra posición para el alimento
			spawnFood();

			// Genera otra posición para el enemigo
			spawnEnemy();

		} else {
			snake.removeLast();
		}

		checkCollision(); // Verifica la colisión de la serpiente con la pared, con su propio cuerpo o con obstáculos
		updateScoreLabel(); // Actualiza el JLabel de puntuación en la interfaz

	}

	/**
	 * Actualiza el contenido del JLabel de puntuación en la interfaz con la puntuación actual del juego.
	 */
	private void updateScoreLabel() {
		scoreLabel.setText("" + getScore());
	}

	/**
	 * Obtiene la cantidad de segmentos que debe crecer la serpiente después de comer, según el tipo de alimento.
	 * @return Cantidad de segmentos de crecimiento de la serpiente.
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

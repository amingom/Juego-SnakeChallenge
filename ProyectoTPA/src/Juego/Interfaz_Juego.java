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
 * This class represents the interface of the Snake Challenge game on the easy
 * level. It allows players to play the game at a lower difficulty level.
 */
public class Interfaz_Juego extends JFrame {
	private JPanel gamePanel; // Used to visually represent the game
	private LinkedList<Point> snake; // Represents the snake
	private Timer timer; // Used to manage the time in the game
	private int direction; // Stores the direction of the snake's movement
	private Point food; // Represents the position of the food
	private int foodType; // Represents the current type of food
	private int score; // Represents the player's score
	private JLabel scoreLabel; // Used to display the score
	private BufferedImage headImage; // Stores the image of the snake's head
	private BufferedImage bodyImage; // Stores the image of the snake's body
	private LinkedList<Point> obstacles; // Stores the positions of obstacles
	private BufferedImage obstacleImage; // Stores the image of an obstacle
	private Interfaz_Personalizar animal; // Used to know the snake chosen by the user
	private long lastDirectionChangeTime = System.currentTimeMillis(); // Used to save the last direction change time of
																		// the snake
	private static final long tiempoMinimo = 90; // Minimum time between direction changes in milliseconds
	private Interfaz_Niveles level; // Used to know the level chosen by the user
	private int speed; // Stores the speed value as an integer
	private int amountObstacles; // Stores the quantity of obstacles
	private int appleEaten; // Counter for the apples eaten
	private int cherryEaten; // Counter for the cherries eaten
	private int bananaEaten; // Counter for the bananas eaten

	/**
	 * Obtiene la punciacion actual del objeto
	 * 
	 * @return La puntuacion actual del objeto
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Establece el valor de la puntuacion del objeto
	 * 
	 * @param _score El nuevo valor de la puntuacion a establecer
	 */
	public void setScore(int _score) {
		score = _score;
	}

	/**
	 * Constructor of the class that configures the game interface at the easy
	 * level. Sets the size, title, position, and other aspects of the window.
	 */
	public Interfaz_Juego() {
		setSize(495, 488); // Sets the size of the window
		setTitle("Snake Challenge"); // Sets the title of the window
		setLocationRelativeTo(null); // Sets the window to the center of the screen
		animal = new Interfaz_Personalizar(); // Initializes the customization interface
		level = new Interfaz_Niveles(); // Initializes the levels interface
		iniciarComponentes(); // Initializes the game components
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Closes the program when clicking the close button (X)
	}

	/**
	 * Initializes the visual components of the game, such as the board, snake,
	 * timer, and food.
	 */
	void iniciarComponentes() {
		JPanel Game = new JPanel() { // Creates the panel for the easy mode
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Draws the background image
				ImageIcon backgroundImage = new ImageIcon("img\\tablero.png"); // Background image
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null); // Sets the image
																								// dimensions to match
																								// the window
			}
		};
		Game.setLayout(null); // Disables layout management
		getContentPane().add(Game); // Adds the panel

		JPanel scoreboard = new JPanel();
		scoreboard.setBounds(0, -5, 500, 35);
		scoreboard.setBackground(Color.GRAY); // Background color of the scoreboard

		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, -5, 500, 35);
		ImageIcon defaultImage = new ImageIcon("img\\marcador.png");
		imageLabel.setIcon(defaultImage);

		scoreboard.add(imageLabel);
		Game.add(scoreboard);

		// Creates a label representing the snake
		gamePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw(g);
			}
		};
		gamePanel.setBounds(0, 30, 500, 500); // Sets the size
		gamePanel.setOpaque(false); // Makes the background of gamePanel transparent
		Game.add(gamePanel);

		// Initializes the snake
		snake = new LinkedList<>();
		snake.add(new Point(5, 5)); // Initial position of the snake
		direction = KeyEvent.VK_RIGHT; // Snake starts moving to the right

		// New JLabel component to display the score
		scoreLabel = new JLabel("", SwingConstants.CENTER);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(10, 6, 500, 20);
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		imageLabel.add(scoreLabel);

		// Initializes the speed decorators
		Velocidad initialSpeed = new VelocidadInicial();
		Velocidad slowSnake = new SlowSpeed(initialSpeed);
		Velocidad mediumSnake = new MediumSpeed(slowSnake);
		Velocidad fastSnake = new FastSpeed(mediumSnake);

		// Adds a timer to move the snake
		if (level.getNivel() == "easy") {
			// Decorates the speed to slow
			speed = slowSnake.getVelocidad();
		} else if (level.getNivel() == "medium") {
			// Decorates the speed to medium
			speed = mediumSnake.getVelocidad();
		} else if (level.getNivel() == "hard") {
			// Decorates the speed to fast
			speed = fastSnake.getVelocidad();
		}

		timer = new Timer(speed, new ActionListener() { // Snake speed
			@Override
			public void actionPerformed(ActionEvent e) {
				move();
				gamePanel.repaint();
			}
		});

		timer.start();

		Game.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				long currentTime = System.currentTimeMillis();
				// Verifies the time since the last direction change
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
					lastDirectionChangeTime = currentTime; // Updates the time of the last direction change
				}
			}
		});

		Game.setFocusable(true);

		spawnFood(); // Initializes the food at a random position
		spawnEnemy(); // Initializes obstacles at random positions

		try {
			obstacleImage = ImageIO.read(new File("img\\Enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generates a random position for the food on the board. The position is
	 * randomly chosen and must be different from the current position of the snake.
	 * Randomly selects the type of food and assigns its position. If the total
	 * number of pixels on the board is occupied by the snake and obstacles, stops
	 * the timer and displays the victory window.
	 */
	public void spawnFood() {
		int maxX = 24; // Maximum column range
		int maxY = 21; // Maximum row range
		int foodX, foodY;
		int totalPixels = maxX * maxY; // Width * Height of the board

		// Generates a random position until it is valid and different from the snake's
		// position
		do {
			foodX = (int) (Math.random() * maxX);
			foodY = (int) (Math.random() * maxY);
		} while (snake.contains(new Point(foodX, foodY)));

		// Randomly chooses the type of food and its score
		foodType = (int) (Math.random() * 3); // 0: apple, 1: cherry, 2: banana

		food = new Point(foodX, foodY);

		// Checks if all pixels on the board are occupied by the snake and obstacles
		if (totalPixels == snake.size() + amountObstacles) {
			timer.stop(); // Stops the timer
			dispose();
			Victory(); // Displays the victory window
		}
	}

	/**
	 * Checks if there is an obstacle at a specific position on the board.
	 *
	 * @param position The position to check for the presence of an obstacle.
	 * @return true if there is an obstacle at the given position, false otherwise.
	 */
	public boolean obstacleAtPosition(Point position) {
		return obstacles != null && obstacles.contains(position);
	}

	/**
	 * Generates and places obstacles on the game board based on the selected
	 * difficulty level. The quantity and position of obstacles vary according to
	 * the level.
	 */
	public void spawnEnemy() {
		int maxX = 24; // Maximum column range
		int maxY = 21; // Maximum row range

		obstacles = new LinkedList<>(); // List to store obstacle positions

		// Determine the quantity of obstacles based on the level
		if (level.getNivel().equals("easy")) {
			amountObstacles = 1;
		} else if (level.getNivel().equals("medium")) {
			amountObstacles = 3;
		} else if (level.getNivel().equals("hard")) {
			amountObstacles = 5;
		}

		// Generate and place obstacles at random positions
		for (int i = 0; i < amountObstacles; i++) {
			Point obstaclePosition;
			int minDistance = 2; // Minimum allowed distance between the head and the obstacle

			// Generate a random position for the obstacle until it is valid and different
			// from the snake, food, and other obstacles
			do {
				obstaclePosition = new Point((int) (Math.random() * maxX), (int) (Math.random() * maxY));
				minDistance--; // Reduce the minimum distance
			} while (snake.contains(obstaclePosition) || obstaclePosition.equals(food)
					|| obstacleAtPosition(obstaclePosition) || isObstacleTooCloseToHead(obstaclePosition, minDistance));

			obstacles.add(obstaclePosition);
		}
	}

	/**
	 * Checks if an obstacle is too close to the head of the snake.
	 *
	 * @param obstaclePosition The position to check if it contains an obstacle
	 * @param minDistance      The minimum allowed distance between the head and the
	 *                         obstacle
	 * @return true if there is an obstacle at the given position that is too close
	 *         to the head, false otherwise
	 */
	private boolean isObstacleTooCloseToHead(Point obstaclePosition, int minDistance) {
		Point head = snake.getFirst();

		return Math.abs(head.x - obstaclePosition.x) < minDistance
				|| Math.abs(head.y - obstaclePosition.y) < minDistance;
	}

	/**
	 * Draws the game elements on the board, including the snake, food, and
	 * obstacles.
	 * 
	 * @param g Graphics object used to draw the snake, food, and obstacles.
	 */
	public void draw(Graphics g) {

		// Draw each segment of the snake
		for (int i = 0; i < snake.size(); i++) {
			Point segment = snake.get(i);
			if (i == 0) {
				drawHeadImage(g, segment.x * 20, segment.y * 20);
			} else {
				drawBodyImage(g, segment.x * 20, segment.y * 20);
			}
		}

		// Draw the food based on its type
		if (foodType == 0) {
			drawFoodImage(g, "img\\apple.png");
		} else if (foodType == 1) {
			drawFoodImage(g, "img\\cherry.png");
		} else if (foodType == 2) {
			drawFoodImage(g, "img\\banana.png");
		}

		// Draw the obstacles
		for (Point obstaclePosition : obstacles) {
			g.drawImage(obstacleImage, obstaclePosition.x * 20, obstaclePosition.y * 20, 20, 20, this);
		}
	}

	/**
	 * Draw the snake's head at the specified position on the board. The head image
	 * varies depending on the direction of movement and the type of animal
	 * selected.
	 * 
	 * @param g Graphics object used to draw on the component.
	 * @param x coordinate of the head position on the board.
	 * @param y coordinate of the position of the head on the board.
	 */
	private void drawHeadImage(Graphics g, int x, int y) {

		try {
			// Select the head image based on the direction of movement and the type of
			// animal
			switch (direction) {
			case KeyEvent.VK_UP:
				if (animal.getAnimal() == "cobra") {
					headImage = ImageIO.read(new File("img\\cobra_cabeza_arriba.png"));
				} else if (animal.getAnimal() == "python") {
					headImage = ImageIO.read(new File("img\\piton_cabeza_arriba.png"));
				} else if (animal.getAnimal() == "viper") {
					headImage = ImageIO.read(new File("img\\vibora_cabeza_arriba.png"));
				}
				break;
			case KeyEvent.VK_DOWN:
				if (animal.getAnimal() == "cobra") {
					headImage = ImageIO.read(new File("img\\cobra_cabeza_abajo.png"));
				} else if (animal.getAnimal() == "python") {
					headImage = ImageIO.read(new File("img\\piton_cabeza_abajo.png"));
				} else if (animal.getAnimal() == "viper") {
					headImage = ImageIO.read(new File("img\\vibora_cabeza_abajo.png"));
				}
				break;
			case KeyEvent.VK_LEFT:
				if (animal.getAnimal() == "cobra") {
					headImage = ImageIO.read(new File("img\\cobra_cabeza_izquierda.png"));
				} else if (animal.getAnimal() == "python") {
					headImage = ImageIO.read(new File("img\\piton_cabeza_izquierda.png"));
				} else if (animal.getAnimal() == "viper") {
					headImage = ImageIO.read(new File("img\\vibora_cabeza_izquierda.png"));
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (animal.getAnimal() == "cobra") {
					headImage = ImageIO.read(new File("img\\cobra_cabeza_derecha.png"));
				} else if (animal.getAnimal() == "python") {
					headImage = ImageIO.read(new File("img\\piton_cabeza_derecha.png"));
				} else if (animal.getAnimal() == "viper") {
					headImage = ImageIO.read(new File("img\\vibora_cabeza_derecha.png"));
				}
				break;
			default:
				// By default, the cobra head image facing right is used
				headImage = ImageIO.read(new File("img\\cobra_cabeza_derecha.png"));
				break;
			}
			// Draws the head image at the specified position
			g.drawImage(headImage, x, y, 20, 20, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Draws a segment of the snake's body at the specified position on the board.
	 * The body image varies based on the selected animal type.
	 *
	 * @param g Graphics object used for drawing on the component.
	 * @param x X-coordinate of the body position on the board.
	 * @param y Y-coordinate of the body position on the board.
	 */
	private void drawBodyImage(Graphics g, int x, int y) {
		try {
			// Selects the body image based on the animal type
			if (animal.getAnimal() == "cobra") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_cobra.png"));
			} else if (animal.getAnimal() == "python") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_piton.png"));
			} else if (animal.getAnimal() == "viper") {
				bodyImage = ImageIO.read(new File("img\\cuerpo_vibora.png"));
			}
			// Draws the body image at the specified position
			g.drawImage(bodyImage, x, y, 20, 20, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Draws the food image on the board at the specified position.
	 *
	 * @param g       Graphics object used for drawing on the component.
	 * @param imgPath File path of the food image.
	 */
	private void drawFoodImage(Graphics g, String imgPath) {
		try {
			BufferedImage foodImage = ImageIO.read(new File(imgPath));
			// Draws the food image at the specified position, resizing it to the provided
			// size
			g.drawImage(foodImage, food.x * 20, food.y * 20, 20, 20, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if the snake has collided with the game borders, its own body, or an
	 * obstacle. If a collision occurs, it stops the timer and displays the defeat
	 * window.
	 */
	public void checkCollision() {
		Point head = snake.getFirst();

		// Checks if the snake collides with the game border
		if (head.x < 0 || head.x >= 24 || head.y < 0 || head.y >= 21) {
			timer.stop(); // Stops the timer
			dispose();
			Defeat(); // Displays the defeat window
		}

		// Checks if the snake collides with its own body
		if (snake.size() > 1 && snake.subList(1, snake.size()).contains(head)) {
			timer.stop(); // Stops the timer
			dispose();
			Defeat(); // Displays the defeat window
		}

		// Checks if the snake collides with the obstacle
		if (obstacles.contains(snake.getFirst())) {
			timer.stop(); // Stops the timer
			dispose();
			Defeat(); // Displays the defeat window
		}
	}

	/**
	 * Displays the defeat interface when the conditions for losing the game are
	 * met. Creates a new instance of the Interfaz_Derrota class and makes it
	 * visible.
	 */
	private void Defeat() {
		// Creates a new defeat interface
		Interfaz_Derrota defeatScreen = new Interfaz_Derrota(this);
		defeatScreen.setVisible(true);
	}

	/**
	 * Displays the victory interface when the conditions for winning the game are
	 * met. Creates a new instance of the Interfaz_Victoria class and makes it
	 * visible.
	 */
	private void Victory() {
		// Creates a new victory interface
		Interfaz_Victoria victoryScreen = new Interfaz_Victoria(this);
		victoryScreen.setVisible(true);
	}

	/**
	 * Performs the movement of the snake on the board, according to the current
	 * direction. Verifies if the snake has eaten, adjusts its length, and updates
	 * the score.
	 */
	public void move() {
		int headX = snake.getFirst().x;
		int headY = snake.getFirst().y;

		// Save the current length of the snake before moving it

		// Perform the movement according to the current direction
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

		// Verifies if the snake has eaten
		if (snake.getFirst().equals(food)) {

			// Grows the snake according to the type of food
			for (int i = 1; i < getGrowthAmount(); i++) {
				snake.addLast(new Point(-1, -1)); // Adds the corresponding segments for growth
			}

			// Updates the total score
			score += foodType + 1;

			// Increase the counter of each fruit according to the type of food.
			switch (foodType) {
			case 0: // Apple
				appleEaten++;
				break;
			case 1: // Cherry
				cherryEaten++;
				break;
			case 2: // Banana
				bananaEaten++;
				break;
			}

			// Generates another position for the food
			spawnFood();

			// Generates another position for the enemy
			spawnEnemy();

		} else {
			snake.removeLast();
		}

		checkCollision(); // Verifies collision of the snake with the wall, with its own body, or with
							// obstacles

		updateFruits(); // updates the Jlabel of interface scoreboard
	}

	/**
	 * Updates the content of the score JLabel on the interface with the current
	 * game score.
	 */
	private void updateFruits() {

		// Display counters on the scoreboard
		scoreLabel.setText("  " + getScore() + "            " + appleEaten + "             " + cherryEaten
				+ "                        " + bananaEaten);

	}

	/**
	 * Gets the number of segments the snake should grow after eating, based on the
	 * type of food.
	 * 
	 * @return Number of snake growth segments.
	 */
	private int getGrowthAmount() {
		switch (foodType) {
		case 0: // Apple
			return 1;
		case 1: // Cherry
			return 2;
		case 2: // Banana
			return 3;
		default:
			return 0;
		}
	}
}
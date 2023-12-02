package Juego;

/**
 * The Main class represents the main class of the Snake Challenge game. It
 * initializes the game's user interface and makes it visible.
 */
public class Main {

	/**
	 * The main entry point for the program. Initializes the loading bar and starts
	 * the game.
	 */
	public static void main(String[] args) {
		BarraCarga barraDeCarga = new BarraDeCarga();
		barraDeCarga.cargar();
	}
}

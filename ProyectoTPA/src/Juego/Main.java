package Juego;

/**
 * Esta clase representa la clase principal del juego Snake Challenge.
 * Inicializa la interfaz de usuario del juego y la hace visible.
 */

public class Main {

	//Main del programa
	public static void main(String[] args) {
		BarraDeCarga frame = new BarraDeCarga();
        frame.setVisible(true);
        frame.iniciarCarga();
	}

}
package Juego;

/**
 * Concrete implementation of an initial 'Velocidad' object. Implements the
 * 'Velocidad' interface by providing a method to retrieve the initial speed.
 */
public class VelocidadInicial implements Velocidad {

	/**
	 * Gets the initial speed value.
	 * 
	 * @return The initial speed value.
	 */
	@Override
	public int getVelocidad() {
		return 110;
	}
}

package Juego;

/**
 * Concrete implementation of an initial 'Speed' object. Implements the
 * 'Speed' interface by providing a method to retrieve the initial speed.
 */
public class InitialSpeed implements Speed {

	/**
	 * Gets the initial speed value.
	 * 
	 * @return The initial speed value.
	 */
	@Override
	public int getSpeed() {
		return 110;
	}
}
package Juego;

/**
 * A concrete decorator that makes the speed faster.
 */
class FastSpeed extends VelocidadDecorator {

	/**
	 * Constructor for the 'FastSpeed' decorator.
	 *
	 * @param serpiente The 'Velocidad' object being decorated with a faster speed.
	 */
	public FastSpeed(Velocidad snake) {
		super(snake);
	}

	/**
	 * Gets the speed after decreasing it for a faster effect.
	 *
	 * @return The modified speed after decreasing it.
	 */
	@Override
	public int getSpeed() {
		return super.getSpeed() - 15;
	}
}

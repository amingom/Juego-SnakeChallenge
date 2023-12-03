package Juego;

/**
 * A concrete decorator that makes the speed faster.
 */
class FastSpeed extends SpeedDecorator {

	/**
	 * Constructor for the 'FastSpeed' decorator.
	 *
	 * @param snake The 'Speed' object being decorated with a faster speed.
	 */
	public FastSpeed(Speed snake) {
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

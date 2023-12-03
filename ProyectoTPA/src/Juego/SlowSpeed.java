package Juego;

/**
 * A concrete decorator that makes the speed slower.
 */
class SlowSpeed extends SpeedDecorator {

	/**
	 * Constructor for the 'SlowSpeed' decorator.
	 *
	 * @param snake The 'Speed' object being decorated with a slower speed.
	 */
	public SlowSpeed(Speed snake) {
		super(snake);
	}

	/**
	 * Gets the speed after decreasing it for a slower effect.
	 *
	 * @return The modified speed after decreasing it.
	 */
	@Override
	public int getSpeed() {
		return super.getSpeed() - 10;
	}
}

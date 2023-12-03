package Juego;

/**
 * A concrete decorator that makes the speed moderate.
 */
class MediumSpeed extends SpeedDecorator {

	/**
	 * Constructor for the 'MediumSpeed' decorator.
	 *
	 * @param snake The 'Speed' object being decorated with a more moderate
	 *                  speed.
	 */
	public MediumSpeed(Speed snake) {
		super(snake);
	}

	/**
	 * Gets the speed after decreasing it for a more moderate effect.
	 *
	 * @return The modified speed after decreasing it.
	 */
	@Override
	public int getSpeed() {
		return super.getSpeed() - 25;
	}
}

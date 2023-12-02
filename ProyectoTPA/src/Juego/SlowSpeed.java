package Juego;

/**
 * A concrete decorator that makes the speed slower.
 */
class SlowSpeed extends VelocidadDecorator {

	/**
	 * Constructor for the 'SlowSpeed' decorator.
	 *
	 * @param serpiente The 'Velocidad' object being decorated with a slower speed.
	 */
	public SlowSpeed(Velocidad serpiente) {
		super(serpiente);
	}

	/**
	 * Gets the speed after decreasing it for a slower effect.
	 *
	 * @return The modified speed after decreasing it.
	 */
	@Override
	public int getVelocidad() {
		return super.getVelocidad() - 10;
	}
}

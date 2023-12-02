package Juego;

/**
 * A concrete decorator that makes the speed moderate.
 */
class MediumSpeed extends VelocidadDecorator {

	/**
	 * Constructor for the 'MediumSpeed' decorator.
	 *
	 * @param serpiente The 'Velocidad' object being decorated with a more moderate
	 *                  speed.
	 */
	public MediumSpeed(Velocidad serpiente) {
		super(serpiente);
	}

	/**
	 * Gets the speed after decreasing it for a more moderate effect.
	 *
	 * @return The modified speed after decreasing it.
	 */
	@Override
	public int getVelocidad() {
		return super.getVelocidad() - 25;
	}
}

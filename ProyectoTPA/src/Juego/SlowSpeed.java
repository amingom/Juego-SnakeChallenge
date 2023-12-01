package Juego;

/**
 * Un decorador concreto que hace mas lenta la velocidad
 */

class SlowSpeed extends VelocidadDecorator{

	/**
	 * Constructor para el decorador 'SlowSpeed'
	 * @param serpiente El objeto 'Velocidad' que esta siendo decorado con una velocidad mas lenta
	 */
	public SlowSpeed(Velocidad serpiente) {
		super(serpiente);
	}
	
	/**
	 * Añade mas velocidad para que vaya mas lento
	 */
	@Override
	public int getVelocidad() {
		return super.getVelocidad() + 10;
	}
}

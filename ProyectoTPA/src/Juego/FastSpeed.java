package Juego;

/**
 * Un decorador concreto que hace la velocidad mas rapida
 */


class FastSpeed extends VelocidadDecorator {

	/**
	 * Constructor para el decorador 'FastSpeed'
	 * @param serpiente El objeto 'Velocidad' que esta siendo decorado con una velocidad mas rapida
	 */
	public FastSpeed(Velocidad serpiente) {
		super(serpiente);
	}
	
	/**
	 * Disminuye la velocidad para que vaya mas rapido
	 */
	@Override
	public int getVelocidad() {
		return super.getVelocidad() - 15;
	}
	
}

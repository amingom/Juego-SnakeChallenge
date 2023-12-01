package Juego;

/**
 * Un decorador concreto que hace la velocidad moderada
 */

class MediumSpeed extends VelocidadDecorator{
	
	/**
	 * Constructor para el decorador 'MediumSpeed'
	 * @param serpiente El objeto 'Velocidad' que esta siendo decorado con una velocidad mas moderada
	 */
	public MediumSpeed(Velocidad serpiente) {
		super(serpiente);
	}
	
	/**
	 * Disminuye la velocidad para que vaya mas rapido
	 */
	@Override
	public int getVelocidad() {
		return super.getVelocidad() - 25;
	}

}

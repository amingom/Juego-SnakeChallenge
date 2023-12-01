package Juego;

/**
 * Clase abstracta que actua como la clase base para todos los decoradores
 */

abstract class VelocidadDecorator implements Velocidad {

	private Velocidad serpiente;
	
	/**
	 * Constructor para el decorador de velocidad
	 * @param serpiente El objeto 'Velocidad' que esta siendo decorado
	 */
	
	public VelocidadDecorator(Velocidad serpiente) {
		this.serpiente = serpiente;
	}
	
	/**
	 * Implementa la operacion 'getDescripcion' del componente 'Velocidad'
	 */
	public int getVelocidad() {
		return serpiente.getVelocidad();
	}
}

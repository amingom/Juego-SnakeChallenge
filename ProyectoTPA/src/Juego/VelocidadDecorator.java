package Juego;

/**
 * An abstract class that serves as the base class for all decorators.
 * Implements the 'Velocidad' interface and delegates the 'getVelocidad'
 * operation to the decorated 'Velocidad' object.
 */
abstract class VelocidadDecorator implements Velocidad {

	private Velocidad serpiente;

	/**
	 * Constructor for the speed decorator.
	 */
	public VelocidadDecorator(Velocidad serpiente) {
		this.serpiente = serpiente;
	}

	/**
	 * Implements the 'getVelocidad' operation of the 'Velocidad' component.
	 * Delegates to the decorated 'Velocidad' object.
	 * 
	 * @return The speed value.
	 */
	@Override
	public int getVelocidad() {
		return serpiente.getVelocidad();
	}
}

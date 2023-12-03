package Juego;

/**
 * An abstract class that serves as the base class for all decorators.
 * Implements the 'Velocidad' interface and delegates the 'getVelocidad'
 * operation to the decorated 'Velocidad' object.
 */
abstract class VelocidadDecorator implements Velocidad {

	private Velocidad snake;

	/**
	 * Constructor for the speed decorator.
	 */
	public VelocidadDecorator(Velocidad snake) {
		this.snake = snake;
	}

	/**
	 * Implements the 'getVelocidad' operation of the 'Velocidad' component.
	 * Delegates to the decorated 'Velocidad' object.
	 * 
	 * @return The speed value.
	 */
	@Override
	public int getSpeed() {
		return snake.getSpeed();
	}
}

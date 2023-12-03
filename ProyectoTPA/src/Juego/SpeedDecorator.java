package Juego;

/**
 * An abstract class that serves as the base class for all decorators.
 * Implements the 'Speed' interface and delegates the 'getSpeed'
 * operation to the decorated 'Speed' object.
 */
abstract class SpeedDecorator implements Speed {

	private Speed snake;

	/**
	 * Constructor for the speed decorator.
	 */
	public SpeedDecorator(Speed snake) {
		this.snake = snake;
	}

	/**
	 * Implements the 'getSpeed' operation of the 'Speed' component.
	 * Delegates to the decorated 'Speed' object.
	 * 
	 * @return The speed value.
	 */
	@Override
	public int getSpeed() {
		return snake.getSpeed();
	}
}

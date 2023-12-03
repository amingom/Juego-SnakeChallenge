package Juego;

/**
 * Abstract class that implements the loading bar. Provide two abstract methods
 * that must be implemented by the inherit classes.
 */
abstract class BarraCarga {

	/**
	 * This abstract method must be implemented to handle the loading logic of the
	 * progress bar. It is called during the loading process.
	 */
	public abstract void charge();

	/**
	 * This abstract method must be implemented to handle specific actions that
	 * should be taken when the loading is complete.
	 */
	public abstract void completeCharge();

}

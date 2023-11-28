package Juego;

class FastSpeed extends AnimalDecorator {

	public FastSpeed(Animal serpiente) {
		super(serpiente);
	}
	
	@Override
	public int getVelocidad() {
		return super.getVelocidad() - 33;
	}
	
}

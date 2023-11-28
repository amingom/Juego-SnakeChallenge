package Juego;

class SlowSpeed extends AnimalDecorator{

	public SlowSpeed(Animal serpiente) {
		super(serpiente);
	}
	
	@Override
	public int getVelocidad() {
		return super.getVelocidad() + 10;
	}
}

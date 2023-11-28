package Juego;

class MediumSpeed extends AnimalDecorator{
	
	public MediumSpeed(Animal serpiente) {
		super(serpiente);
	}
	
	@Override
	public int getVelocidad() {
		return super.getVelocidad() - 15;
	}

}

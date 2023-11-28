package Juego;

abstract class AnimalDecorator implements Animal {

	private Animal serpiente;
	
	public AnimalDecorator(Animal slowAnimal) {
		this.serpiente = slowAnimal;
	}
	
	public int getVelocidad() {
		return serpiente.getVelocidad();
	}
}

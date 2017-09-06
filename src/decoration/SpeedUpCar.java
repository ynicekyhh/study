package decoration;

public class SpeedUpCar extends TunedCar {

	Car car = null;
	
	public SpeedUpCar(Car car) {
		this.car = car;
	}
	
	@Override
	public void speed() {
		System.out.println("speed up!");
	}
	
	@Override
	public void move() {
		speed();
		car.move();
	}

}

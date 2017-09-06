package decoration;

public class DecorationTest {

	public static void main(String[] args) {
		Car car = new SpeedUpCar(new Bus());
		car.move();
	}

}

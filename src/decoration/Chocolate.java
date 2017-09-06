package decoration;

public class Chocolate extends DecorationCake {
	private Cake cake;
	
	public Chocolate(Cake cake) {
		this.cake = cake;
	}
	
	@Override
	public void add() {
		
	}

	@Override
	public void makeCake() {
		System.out.print("초콜릿을 넣고, ");
		cake.makeCake();
	}

}

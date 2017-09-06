package lamdaExpressions;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		IntSupplier intSupplier = () -> {
			return (int)(Math.random() * 6) + 1;
		};
		
		System.out.println(intSupplier.getAsInt());
		
		Supplier<Integer> supplier = () -> {
			return 1;
		};
		
		System.out.println(supplier.get());
	}

}

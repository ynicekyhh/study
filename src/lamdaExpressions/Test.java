package lamdaExpressions;

public class Test {
	
	public static void main(String[] args) {
		
		MyFunctionalInterface fi;
		
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> {System.out.println("method call2");};
		fi.method();
		
		fi = () -> System.out.println("method call3");
		fi.method();
		
		System.out.println("--------------------------------------");
		
		MyFunctionalInterface2 fi2;
		
		fi2 = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fi2.method(2);
		
		fi2 = (x) -> { System.out.println(x*5); };
		fi2.method(2);
		
		fi2 = x-> System.out.println(x*5);
		fi2.method(2);
		
		System.out.println("--------------------------------------");
		
		MyFunctionalInterface3 fi3;
		
		fi3 = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fi3.method(2, 5));
		
		fi3 = (x, y) -> {return x + y;};
		System.out.println(fi3.method(2, 5));
		
		fi3 = (x, y) -> x + y;
		System.out.println(fi3.method(2, 5));
		
		fi3 = (x, y) -> sum(x, y);
		System.out.println(fi3.method(2, 5));
		
		System.out.println("--------------------------------------");
		
	}
	
	public static int sum(int x, int y) {
		return x + y;
	}
}

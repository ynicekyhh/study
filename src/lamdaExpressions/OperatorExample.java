package lamdaExpressions;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
	private static int[] scores = {90, 80, 20};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for(int score : scores) {
			result = operator.applyAsInt(result, score); 
		}
		return result;
	}
	
	public static void main(String[] args) {
		int max = maxOrMin(
				(a, b)->{
					if(a>=b) return a;
					return b;
				});
		System.out.println("최대값: " + max);
		
		int min = maxOrMin((a, b)->{
			if(a<b) return a;
			return b;
		});
		System.out.println("최소값: " + min);
	}

}

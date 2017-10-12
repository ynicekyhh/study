package kakao_algorithm_test;

public class Ex1 {

	public int solution(int n) {
		int sum=0;
		
		if(n > 100000000) {
			return 0;
		}
		
		while(n > 0) {
			sum += n%10;
			n = n/10;
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		new Ex1().solution(123);
		new Ex1().solution(987);
	}

}

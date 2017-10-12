package kakao_algorithm_test;

public class Test1 {

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int[] result = new int[n];

		for(int i = 0; i<n; i++) {
			result[i] = arr1[i] | arr2[i];
			answer[i] = Integer.toBinaryString(result[i]);
			
			while(answer[i].length() < n) {
				answer[i] = '0' + answer[i];
			}
			
			answer[i] = answer[i].replace('0', ' ');
			answer[i] = answer[i].replace('1', '#');
			System.out.println(answer[i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};

		new Test1().solution(6, arr1, arr2);
	}
}

package kakao_algorithm_test;

import java.util.ArrayList;

public class Ex2 {
	public boolean solution(int[] arr) {
        boolean answer = true;
        
        if(arr.length > 100000) {
        	return false;
        }

        for(int i=0; i < arr.length; i++) {
        	if(arr[i] > arr.length) {
        		return false;
        	}
        }

        for(int i=0; i < arr.length-1; i++) {
        	for(int j=i+1; j < arr.length; j++) {
            	if(arr[i] == arr[j] ) {
            		return false;
            	}
            }
        }
        
        return answer;
    }
	
	public static void main( String[] args ) {
		int[] arr = {4, 1, 3, 2};
		int[] arr2 = {4, 1, 3};
		System.out.println(new Ex2().solution(arr));
		System.out.println(new Ex2().solution(arr2));
	}
}

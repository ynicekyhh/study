package nhn_ent;

import java.util.Arrays;
import java.util.Scanner;

public class PreTest1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String numbers = scanner.nextLine();
		String[] numList = numbers.split(" ");
		String maxStr = new String();
		
		if(numList.length > 10) {
			System.out.println("길다");
			return;
		}
		
		int[] numArr = new int[numList.length]; 
		int[] numFirstDigit = new int[numList.length];
		
		for(int i=0; i<numList.length; i++) {
			numArr[i] = Integer.parseInt(numList[i]);
			
			if(numArr[i] >= 10) {
				numFirstDigit[i] = numArr[i]/10;
			}else {
				numFirstDigit[i] = numArr[i]; 
			}
		}
		
		for(int i=0; i<numFirstDigit.length-1; i++) {
			for(int j=i+1; j<numFirstDigit.length; j++) {
				if(numFirstDigit[j] > numFirstDigit[i]) {
					int temp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = temp;
					
					temp = numFirstDigit[i];
					numFirstDigit[i] = numFirstDigit[j];
					numFirstDigit[j] = temp;
				}else if(numFirstDigit[j] == numFirstDigit[i]) {
					if( (numArr[j] % 10) > (numArr[i] % 10) ) {
						int temp = numArr[i];
						numArr[i] = numArr[j];
						numArr[j] = temp;
						
						temp = numFirstDigit[i];
						numFirstDigit[i] = numFirstDigit[j];
						numFirstDigit[j] = temp;
					}
				}
			}
		}
		
		for(Integer i: numArr) {
			maxStr += Integer.toString(i);
//			System.out.print(i + " ");
		}
		System.out.println(maxStr);
	}
}

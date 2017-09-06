package algorithm;

import java.util.Scanner;

class Jolly {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numArray = null;
		int[] returnNumArray = null;
		int arraySize = 0;
		boolean checkFlag = true;

		while(scanner.hasNextInt()) {

			try{arraySize = scanner.nextInt();} catch(Exception e) {break;}
			
			checkFlag = true;

			if(arraySize == 0) {
//				continue;
				break;
			}

			if(arraySize == 1) {
				scanner.nextInt();
				System.out.println("Jolly");
				continue;
			}

			numArray = new int[arraySize];
			returnNumArray = new int[arraySize-1];

			for(int i = 0; i < arraySize; i++ ) {
				numArray[i] = scanner.nextInt();
			}

			for(int i = 1; i < arraySize; i++ ) {
				int temp = Math.abs(numArray[i] - numArray[i - 1]);

				if(0 < temp && temp < arraySize) {
					returnNumArray[temp-1] = temp;
				}else {
					//error 처리
					break;
				}
			}

			for(int i = 0; i < arraySize-1; i++ ) {
				if(returnNumArray[i] == 0) {
					checkFlag = false;
					break;
				}
			}

			if(checkFlag) {
				System.out.println("Jolly");
			}else {
				System.out.println("Not jolly");
			}

		}//end while(scanner.hasNextInt())

		scanner.close();
	}
}

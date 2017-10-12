package nhn_ent;

import java.util.Scanner;

public class PreTest2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = 0;
		int indexCnt = 0;
		String[] numberStr = null;
		
		int[] numberInteger = null;
		
		N = Integer.parseInt(scanner.nextLine());
		numberStr = new String[N];
		numberInteger = new int[N*N];
		
		for(int i=0; i<N; i++) {
			numberStr[i] = scanner.nextLine();
			
			for(int j=0; j<N; j++) {
				numberInteger[indexCnt++] = Integer.parseInt( numberStr[i].split(" ")[j] );
			}
		}
		
		for(int i=0; i<N; i++) {
			numberStr[i] = "";
			for(int j=i; j<indexCnt; j+=N) {
				numberStr[i] += numberInteger[j] + " ";
			}
			System.out.println( numberStr[i].trim() );
		}
	}
}

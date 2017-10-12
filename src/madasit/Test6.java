package madasit;

import java.util.Scanner;

/*
사과세트
철수는 과일가게에서 사과를 팔고 있다. 
가게 마감까지 얼마 남지 않아서 현재 남아 있는 사과 N 개를 묶음으로 구성해서 팔려고 한다. 
사과 묶음별 가격은 정해져 있는데 욕심쟁이인 철수는 적절히 사과 묶음을 구성해서 최대의 수익을 얻으려고 한다.

사과 n개로 이루어진 사과 묶음의 가격은 An 이다.

예를 들어 사과 4개 남아있는데 A1 = 1, A2 = 6, A3 = 7, A4 = 10 인 경우 철수가 얻을 수 있는 최대 수익은 12이다. 
사과 2개로 이루어진 묶음 2개를 파는 경우가 최대 수익이기 때문이다.

사과 묶음의 가격이 주어졌을 때, 철수가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.

 

입력

첫째 줄에 남아있는 사과의 개수 N이 주어진다.
(1 <= N <= 300)
둘째 줄에 N개의 묶음 가격이 A1부터 An 까지 빈칸을 사이에 두고 주어진다.
(1 <= An <= 100,000)



출력

철수가 얻을 수 있는 최대 수익을 출력한다.



입출력 예시

입력 예시 1
4
1 6 7 10
출력 예시 1
12
 */
public class Test6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = Integer.parseInt(scanner.nextLine());
		
		String[] prices = scanner.nextLine().split(" ");
		int len = prices.length;
		float[] piecePrice = new float[len];
		float max = 0;
		int maxIndex = 0;
		int maxPriceBundle = 0;	//개수
		
		int count = 0;
		int leftCount = 0;
		
		int totalPrice = 0;
		
		/* 개당 가격 */
		for(int i=0; i<len; i++) {
			piecePrice[i] = Float.parseFloat(prices[i]) / (i+1);
			
			if(max < piecePrice[i]) {
				max = piecePrice[i];
				maxIndex = i;
			}
		}
		maxPriceBundle = maxIndex + 1;
		
		while(N > 0) {
			count = N / maxPriceBundle;
			leftCount = N % maxPriceBundle;
			
			totalPrice = count * piecePrice[maxIndex];
			N -= maxPriceBundle * count;
		}
	}
}

package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//숫자 2개 입력
		while(scanner.hasNextInt()) 
		{
			int min = scanner.nextInt();
			int max = scanner.nextInt();
			int temp = 0;

			if(min > max) {
				temp = min;
				min = max;
				max = temp;
				temp = 1;
			}

			List<Long> list = new ArrayList<Long>(); 

			for(long i = min ; i <= max; i++ ) {
				list.add(Main.getCycleLength(i));
			}

			if(temp == 1) {
				System.out.println(max + " " + min + " " + Main.getMaxValue(list));
			}else {
				System.out.println(min + " " + max + " " + Main.getMaxValue(list));
			}

		}
		scanner.close();
	}

	static long getMaxValue(List<Long> list) {
		long max = 0;

		for(long n : list) {
			if(max < n) {
				max = n;
			}
		}

		return max;
	}

	static long getCycleLength(long n) {
		long count=1;

		while(n != 1) {
			if(n % 2 == 0) {
				n /= 2;
			}else {
				n = 3 * n + 1;
			}
			count++;
		}

		return count;
	}
}

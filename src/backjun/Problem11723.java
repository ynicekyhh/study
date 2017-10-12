package backjun;

import java.util.Scanner;

public class Problem11723 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = Integer.parseInt(scanner.nextLine());
		String line[] = null;
		String exp = null;
		int calcNum = 0;
		int result = 0;
		
		System.out.println(Integer.toBinaryString(num));
		
		while(scanner.hasNext()) {
			line = scanner.nextLine().split(" ");
			exp = line[0];
			calcNum = Integer.parseInt(line[1]);
			
			switch(exp) {
			case "add":
				result = num | calcNum;
				break;
			case "check":
				result = ((num & calcNum) != 0? 1: 0);
				break;
			case "remove":
				break;
			case "toggle":
				break;
			case "all":
				break;
			case "empty":
				break;
			default:
				break;
			}
			
			System.out.println(Integer.toBinaryString(result));
		}
		
	}
}

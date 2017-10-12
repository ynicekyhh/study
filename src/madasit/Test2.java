package madasit;

import java.util.Scanner;

/*
연애편지 미스테리
제임스는 친구 해리가 그의 여자친구에게 썼던 연애편지 한개를 발견했습니다. 제임스는 장난꾸러기라서, 그는 그 편지를 조작하기로 마음먹었습니다. 그는 편지안에 있는 모든 단어들을 팰린드롬으로 바꿀 것입니다.

이걸 하기위해, 아래 두가지 룰을 따라야 합니다.

1. 한 글자의 값을 감소시킬 수 있습니다. 예를 들어, d에서 c로 바꿀수 있습니다. 하지만 c에서 d로는 바꿀수 없습니다.

2. 팰린드롬을 만들기 위해, 반복적으로 글자의 값을 감소시켜야 한다면, a가 될때까지 그 글자를 바꿀수 있습니다. a에서 값을 감소시키는 것은 불가능 합니다.

어떤 글자 값을 한번 감소시키면 그것은 한번의 연산작업을 하게 되는 것입니다. 그렇다면 주어진 문자열을 팰린드롬으로 바꾸기 위해 최소한의 연산작업을 한다면 몇번의 연산작업이 필요합니까?  



입력

첫째 줄에 테스트케이스 수 T가 주어집니다. 다음 T줄에는 각각 공백이 없는 문자열이 주어집니다.



출력

테스트케이스마다 각 줄에 최소한의 연산작업의 수를 출력하세요.



제약조건

1 <= T <= 10

1 <= 문자열의 길이 <= 10000

모든 문자열은 알파벳 소문자로만 이뤄집니다.


입출력 예시

입력 예시 1
4
abc
abcba
abcd
cba

출력 예시 1
2
0
4
2
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = Integer.parseInt(scanner.nextLine());

		int count = 0;

		while(N > 0) {
			String palindrome = scanner.nextLine();
			int len = palindrome.length();
			int halfLen = len/2;

			for(int i=0; i<halfLen; i++) {
				char big;
				char small;
				
				if(palindrome.charAt(i) > palindrome.charAt(len-1-i)) {
					big = palindrome.charAt(i);
					small = palindrome.charAt(len-1-i);
				} else {
					big = palindrome.charAt(len-1-i);
					small = palindrome.charAt(i);
				}

				while(big != small) {
					big--;
					count++;
				}

				char[] cArr = palindrome.toCharArray();
				cArr[i] = big;
				palindrome = new String(cArr, 0, cArr.length);
			}

			System.out.println(count);
			count = 0;
			N--;
		}
	}
}

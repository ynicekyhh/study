package nhn_ent;

import java.util.Arrays;
import java.util.Scanner;

/*
2. 암복호화 제출 완료

사내 개발자 커플인 철수와 영희에게 둘만의 비밀 통신 프로그램이 필요합니다. 아래 기능 명세를 만족하는 비밀 통신 프로그램을 구현하세요.

이 프로그램은 암호화와 복호화 두 가지 동작을 수행합니다.

메시지를 암호화하려면 다음과 같이 입력합니다,
encrypt secretword 3 helloworld
이 입력을 받아 프로그램은 암호화된 문장을 출력합니다.

cspkfcgzin


반대로 복호화는 다음과 같이 수행합니다.
decrypt secretword 3 cspkfcgzin
아래와 같이 복호화된 문장을 출력합니다.

helloworld


[암호화/복호화 방식]

암호화는 '비밀키'를 이용해서 원문자를 다른 영문자로 바꾸고,
'로테이트' 연산을 통해서 문자 배치를 바꾸는 방식을 사용합니다.
'비밀키'에서 사용되는 a~z는 0~25를 의미하며,
원본 문자를 비밀키만큼 이동시킨 알파벳 소문자로 변환하기 위해 사용합니다.
예시) e(원본 문자) + b(비밀키 문자) = f(변환된 문자)
비밀키는 원본 메시지 길이만큼 반복해서 사용합니다.
변환된 메시지는 '로테이트 횟수'만큼 로테이트 된 후 출력됩니다.
'로테이트 횟수'에서 양의 정수는 왼쪽 로테이트 횟수, 음의 정수는 오른쪽 로테이트 횟수를 의미합니다.
예시) 로테이트 횟수가 2이면 iloveyou는 oveyouil 로 변환됩니다.
복호화는 암호화의 역순으로 수행되며, 원본 메시지를 출력합니다.

[입력]
첫 번째 자리는 '암호화/복호화 명령'를 나타내며,
'encrypt' 이면 암호화 수행, 'decrypt'이면 복호화를 수행합니다.
두 번째 자리는 '비밀키'입니다.
'비밀키' 길이는 1~30자이며, 알파벳 소문자로만 구성됩니다.
세 번째 자리는 문자열의 '로테이트 횟수'입니다.
로테이트 횟수는 -10000 이상, 10000 이하 범위의 정수입니다.
네 번째 자리는 '메시지'입니다.
'메시지'는 최대 30자이며, 알파벳 소문자로만 구성됩니다.
'비밀키'와 '메시지'는 모두 알파벳 소문자로만 구성됩니다.


[출력]

주어진 입력 조건에 따라 암호화 또는 복호화로 변환한 메시지를 출력합니다.


[예시]
비밀키가 secretword이고, 로테이트 횟수 3, 메시지가 helloworld 인 경우 다음과 같이 됩니다.


 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char[] alpabetArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int alpabetArrLength = alpabetArr.length;
		
		String line = scanner.nextLine();
		String[] words = line.split(" ");
		
		String command = words[0];
		String key = words[1];
		int rotateCnt = Integer.parseInt(words[2]);
		String msg = words[3];
		
		int arrIndex = 0;	//alpabetArr
		String changedStr = "";
		String result = "";
		
		if("encrypt".equals(command)) {
			for(int i=0; i<msg.length(); i++) {
				arrIndex = (Arrays.binarySearch(alpabetArr, msg.charAt(i)) + 
						Arrays.binarySearch(alpabetArr, key.charAt(i)) ) 
						% alpabetArrLength;
				changedStr += alpabetArr[arrIndex];
			}
			
			//left
			if(rotateCnt > 0) {
				for(int j=0; j<rotateCnt; j++) {
					result = "";
					char tempChar = changedStr.charAt(0);
					for(int i=1; i<changedStr.length(); i++) {
						result += changedStr.charAt(i);
					}
					result += tempChar;
					changedStr = result;
				}
			}else {	//right
				for(int j=0; j<Math.abs(rotateCnt); j++) {
					result = "";
					
					char tempChar = changedStr.charAt(changedStr.length()-1);
					result += tempChar;
					
					for(int i=0; i<changedStr.length()-1; i++) {
						result += changedStr.charAt(i);
					}
					changedStr = result;
				}
			}
			
		}else if("decrypt".equals(command)) {
			changedStr = msg;
			//right
			if(rotateCnt > 0) {
				for(int j=0; j<Math.abs(rotateCnt); j++) {
					result = "";
					
					char tempChar = changedStr.charAt(changedStr.length()-1);
					result += tempChar;
					
					for(int i=0; i<changedStr.length()-1; i++) {
						result += changedStr.charAt(i);
					}
					changedStr = result;
				}
			}else {	//left
				for(int j=0; j<rotateCnt; j++) {
					result = "";
					char tempChar = changedStr.charAt(0);
					for(int i=1; i<changedStr.length(); i++) {
						result += changedStr.charAt(i);
					}
					result += tempChar;
					changedStr = result;
				}
			}
			
			result = "";
			for(int i=0; i<msg.length(); i++) {
				arrIndex = (Arrays.binarySearch(alpabetArr, changedStr.charAt(i)) - 
						Arrays.binarySearch(alpabetArr, key.charAt(i)) ) 
						% alpabetArrLength;
				
				if(arrIndex < 0) {
					arrIndex = (Arrays.binarySearch(alpabetArr, changedStr.charAt(i)) + alpabetArrLength - 
					Arrays.binarySearch(alpabetArr, key.charAt(i)) ) 
					% alpabetArrLength;
				}
				
				result += alpabetArr[arrIndex];
			}
		}
		
		System.out.println(result);
	}
}

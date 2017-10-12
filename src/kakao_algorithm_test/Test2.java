package kakao_algorithm_test;

public class Test2 {
	
	public int solution(String dartResult) {
		int answer = 0;
		
		int count = 0;		//다트 던진 횟수
		
		int hit = 0;		//다트던져서 맞춘 곳의 점수
		int hitScore = 0;	//맞춘곳의 S, D, T가 적용된 점수
		
		int nowScore = 0;	//맞춘곳에서 보너스와 옵션 적용한 점수
		int prevScore = 0;	//바로 직전기회의 총 점수
		int totalScore = 0;	//3번을 다 던진 후 모두 계산된 점수
		
		boolean optionFlag = false;
		
		String number = new String();
		
		
		for(int i=0; i<dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			
			switch(c) {
			case 'S':
				count++;

				hit = Integer.parseInt(number);
				number = "";
				hitScore = hit;
				nowScore = hitScore;
				
				optionFlag = false;
				break;
			case 'D':
				count++;

				hit = Integer.parseInt(number);
				number = "";
				hitScore = (int) Math.pow(hit, 2);
				nowScore = hitScore;
				
				optionFlag = false;
				break;
			case 'T':
				count++;

				hit = Integer.parseInt(number);
				number = "";
				hitScore = (int) Math.pow(hit, 3);
				nowScore = hitScore;
				
				optionFlag = false;
				break;
			case '*':	//스타상
				totalScore -= prevScore;
				prevScore = prevScore * 2;
				nowScore = nowScore * 2;
				optionFlag = true;

				/* 스타'*'가 있는 위치에 따라 */
				switch(count) {
				case 1:
				case 2:
					totalScore = prevScore + nowScore;
					break;
				default:
					totalScore = totalScore + prevScore + nowScore;
					break;
				}
				
				break;
			case '#':	//아차상 : 기존
				nowScore = nowScore * -1;
				optionFlag = true;
				
				switch(count) {
				case 1:
				case 2:
					totalScore = prevScore + nowScore;
					break;
				default:
					totalScore += nowScore;
					break;
				}
				break;
			default:	//숫자일 때
				number += c;
				prevScore = nowScore;
				if(!optionFlag) {
					totalScore += nowScore;
				}
				break;
			}
		}
		if(!optionFlag) {
			totalScore += nowScore;
		}
		answer = totalScore;
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		
		/*
		 * 스타상이나 아차상이 String에서 몇개나 포함되어 있는지 확인 -> 1개면 그냥 처리
		 * 2개 이상이면...
		 */
		
		/*
		 *  스타상(*) : 
		 *  1. prevScore * 2 + nowScore * 2, 
		 *  2. if(첫번째기회) : nowScore * 2
		 *  3. 스타상 중첩 가능(예제 4번)
		 *  4. 아차상 효과와 중첩 가능(예제 5번)
		 */
		// 아차장(#) : - nowScore 
		new Test2().solution("1D2S#10S");
	}
}

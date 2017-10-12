package kakao_algorithm_test;

/*
직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 
점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 
단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.

제한사항
v는 세 점의 좌표가 들어있는 2차원 배열입니다.
v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
좌표값은 1 이상 10억 이하의 자연수입니다.
직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
 */
public class Ex3 {

	public int[] solution(int[][] v) {
		int[] answer = {};
		/*
		int x = 0, y = 0;
		int xCount = 0;
		int yCount = 0;

		//기본값 세팅
		x = v[0][0];
		y = v[0][1];

		int xIndex = 0;
		int yIndex = 0;

		for(int i=0; i < v.length; i++ ) {
			if(x == v[i][0]) {
				xCount++;
			}
			if(xCount==2) {
				if(i==1) {
					xIndex = 2;
					break;
				}else if(i==2) {
					xIndex = 1;
					break;
				}
			}
			
			
			if(y == v[i][1]) {
				yCount++;
			}
			if(yCount==2) {
				if(i==1) {
					yIndex = 2;
					break;
				}else if(i==2) {
					yIndex = 1;
					break;
				}
			}
		}
		
//		answer[0] = v[xIndex][0];
//		answer[1] = v[yIndex][0];
		int[] temp = {v[xIndex][0], v[yIndex][1]}; 
		answer = temp;
		
		*/
		return answer;
	}
	
	public static void main(String[] args) {
		int [][] v = {{1,4}, {3,4}, {3,10}};
		System.out.println(new Ex3().solution(v));
	}
}

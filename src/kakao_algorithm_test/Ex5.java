package kakao_algorithm_test;

public class Ex5 {

	int solution(int[][] land) {
        int answer = 0;

        int max = 0;
        int prevIndex = 0;
        int index = 0;
        
        int arrLen = land[0].length;
        
        //첫째 행의 max값
        for(int i=0; i < 4; i++) {
        	if(max < land[0][i]) {
        		max = land[0][i];
        		prevIndex = i;
        	}
        }
        
        answer += max;
        
        //둘째 행부터
        for(int i=1; i<land.length; i++) {
        	max = 0;
        	
        	for(int j=0; j<arrLen; j++) {
        		if(j != prevIndex) {
        			if(max < land[i][j]) {
        				max = land[i][j];
        				index = j;
        			}
        		}
        	}
        	
        	answer += max;
        	prevIndex = index;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
//		int [][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		int [][] land = {{4, 4, 5, 4},{3, 3, 5, 4},{2, 0, 10, 2}};
		System.out.println(new Ex5().solution(land));
	}

}

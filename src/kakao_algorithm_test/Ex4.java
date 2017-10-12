package kakao_algorithm_test;

public class Ex4 {

	public int solution(int [][]board)
	{
		int answer = 1234;
		
		int a, b, c, d;
		int x1 = 0, y1 = 0, k = 1;
		
		int i=4;
		int j=4;
		
		int result = 0;
		int[][] x = board;
		
		for(a = 0; a < i; ++a) {
			for(b = 0; b < j; ++b) {
				if(x[a][b] == 1) {	//'1'을 찾으면
					/* 배열크기내에서 하나씩 오른쪽, 아래로 증가하면서 검사 */
					for(; a+k <= i && b+k <= j; ++k) {
						for(c = a; c < a+k; ++c) {
							for(d = b; d < b+k; ++d) {
								if(x[c][d] != 1) {
									break;
								}
							}
							/* 다 돌고나서 확인 */
							if(d != b+k) {
								break;
							}
						}
						/* 다 돌고나서 확인 */
						if(c != a+k) {
							break;
						}
						if(k>result) {
							result = k;
						}
					}
				}
			}
		}
		System.out.println(result);
		
		return k;
	}
	
	public static void main(String[] args) {
		int [][] v = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		new Ex4().solution(v);
	}
}

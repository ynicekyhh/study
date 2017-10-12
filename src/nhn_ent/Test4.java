package nhn_ent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
4. 행렬의 영역 제출 완료

모든 원소가 0 또는 1인 행렬이 있습니다.

1로 표시된 원소는 영역을 나타냅니다.
여기에서 상하좌우에 인접한 1은 같은 영역이라고 가정합니다.
각 영역의 크기는 1의 개수로 정의합니다.

주어진 N x N 크기의 행렬에서 영역의 개수와 각 영역의 크기를 오름차순으로 출력하세요.


[입력]

첫 번째 행은 행렬의 크기인 N입니다. N은 1 이상 10 이하의 자연수입니다.
입력 두 번째 행부터는 공백으로 구분된 0과 1로 행렬이 주어집니다. 각 행은 개행 문자(newline, \n)로 구분됩니다.


[출력]

첫 번째 행은 영역의 개수를 출력합니다.
두 번째 행은 각 영역의 크기를 공백으로 구분하여 오름차순으로 출력합니다.
한 행의 끝은 불필요한 공백 없이 개행 문자(newline, \n)로 끝나야 합니다.
영역이 존재하지 않을 경우 영역 수 0으로 1행으로만 출력합니다. 

[행렬 및 영역 예시]



영역은 3개이며, 각 영역의 크기는 4, 5, 7입니다. 
 */

/*
6
0 1 1 0 0 0
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0 
 */

public class Test4 {
	
	static int[][] space;
	static boolean[][] checkSpace;

	public static void main(String[] args) {
		int N;
		int size = 0;
		int lump = 0;
		List<Integer> lumpList = new ArrayList<Integer>();

		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();

		space = new int[N][N];
		checkSpace = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				space[i][j] = scanner.nextInt();
				checkSpace[i][j] = false;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				size = calcSize(i, j, N);
				
				if(size > 0) {
					lump++;
					lumpList.add(size);
				}
			}
		}
		
		System.out.println(lump);
		for(int result : lumpList) {
			System.out.print(result + " ");
		}
	}

	static int calcSize(int i, int j, int N) {
		int size = 0;
		
		if(i<N && j<N) {
			if(space[i][j] == 1 && checkSpace[i][j] == false) {
				size += calcSize(i, j+1, N);
				size += calcSize(i+1, j, N);
				size += space[i][j];
				checkSpace[i][j] = true;
			}
		}
		
		return size;
	}
}

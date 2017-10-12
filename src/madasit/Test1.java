package madasit;

import java.util.Scanner;

/*
격자세계의 기차
격자세계의 도시는 n by m 행렬로 나타내어진다. 각 행은 1부터 n까지 번호가 붙어있다. 각 열은 1부터 m까지 번호가 붙어있다.

격자세계는 기차는 도시의 한 행을 수평으로 가로지른다. 즉, 격자세계의 기차는 두 끝 위치 (r, c1)과 (r, c2)사이를 운행한다. r은 행 번호, c1과 c2는 열 번호를 뜻한다. 두 끝 지점도 운행 범위에 포함된다.

총 k종류의 기차가 있다. 한 기차가 운행하는 범위는 다른 기차가 운행하는 범위와 겹칠 수도 있고, 겹치지 않을 수도 있다.

격자세계의 도시에는 총 nm개의 지점들이 있다. 시장은 이 지점들 중 기차가 운행되지 않는 지점의 개수를 세려고 한다.



입력

첫째 줄에는 세 정수 n, m, k가 공백으로 구분되어 주어진다. 이후 k개의 줄이 더 주어지고, 각 줄에는 각 기차의 정보를 뜻하는 세 정수 r, c1, c2가 공백으로 구분되어 주어진다.



출력

기차가 운행되지 않는 지점의 개수를 출력하여라.



제한조건

1 <= n, m <= 10

0 <= k <= 10

1 <= r <= n

1 <= c1 <= c2 <= m



입출력 예시

입력 예시 1
4 4 3
2 2 3
3 1 4
4 4 4
출력 예시 1
9
입력 예시 2
4 4 0
출력 예시 2
16
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		
		String token = scanner.nextLine();
		String space[] = new String[3];

		space = token.split(" ");

		String train[] = new String[Integer.parseInt(space[2])];
		String train_S[] = new String[3];

		boolean[][] matrix = new boolean[Integer.parseInt(space[0])][Integer.parseInt(space[1])];

		for (int i = 0; i < Integer.parseInt(space[2]); i++) {
			train[i] = scanner.nextLine();
			train[i] =train[i].replaceAll(" ", ""); 
			char[] c = new char[3];
			for (int j = 0; j < train[i].length(); j++) {
				c[j] = train[i].charAt(j);

			}


			for (int b = Integer.parseInt(c[1]+""); b < Integer.parseInt(c[2]+"")+1; b++) {

				matrix[Integer.parseInt(c[0]+"")-1][b-1] = true;
				System.out.println("a: "+ Integer.parseInt(c[0]+"") + " b:" + b);
			}




		}

		for (int i = 0; i < Integer.parseInt(space[0]); i++) {
			for(int j = 0; j <Integer.parseInt(space[1]); j++) {
				if(matrix[i][j] == false) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}

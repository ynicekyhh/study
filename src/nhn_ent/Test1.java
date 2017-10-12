package nhn_ent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
1. NHN엔터의 모험
"NHN엔터의 모험"이라는 롤플레잉 게임을 출시하였습니다.
이 게임에는 6개의 아이템이 나오며,
이 게임의 주인공은 아이템을 3개까지 넣을 수 있는 주머니를 가지고 있습니다.

퀘스트를 수행하면 이 여섯 가지의 아이템 중에 하나를 습득하게 됩니다.
주인공은 여러 퀘스트를 수행하면서 아이템을 계속 주머니에 담습니다.

이때, 주머니에 빈 자리가 있을 때는 아이템을 순서대로 주머니에 넣습니다.
주머니가 가득 찬 상태에서 아이템을 얻게 되면,

주머니에 없는 아이템이라면 가장 오래 전에 습득한 아이템을 버리고 주머니에 담습니다.
이미 주머니에 들어 있는 아이템이라면 주머니에 새로 담고, 
기존 아이템은 동료 캐릭터에게 선물합니다. 
이 경우 주머니에서 아이템은 빠져 나오지만, 버려지는 아이템은 없습니다.


주어진 입력 대로 아이템을 습득하였을 때, 버리게 된 아이템은 무엇일까요?
아이템을 버린 순서대로 출력하세요. 

아이템의 이름은 구현 편의상 1, 2, 3, 4, 5, 6으로 정합니다.


[입력]

입력값은 주머니 속의 아이템(1~6 숫자)이며, 공백으로 구분합니다.

[출력]
버린 아이템은 개행 문자 (newline, \n)로 구분하여 출력합니다.
버린 아이템이 없는 경우에는 0을 출력합니다.


[예시]

입력이 1 2 3 4 5 6 4 5 3 일 경우, 

입력 --- 주머니 속의 아이템 (가장 오른쪽 아이템이 가장 오래 전에 습득한 아이템입니다.)
1 --- 1
2 --- 2 1
3 --- 3 2 1
4 --- 4 3 2  (1을 버림)
5 --- 5 4 3  (2를 버림)
6 --- 6 5 4  (3을 버림)
4 --- 4 6 5  (4가 가장 오래 전에 습득한 아이템이었지만, 다시 4를 습득했으므로, 5가 가장 오래 전에 습득한 아이템이 됩니다.)
5 --- 5 4 6  (5를 다시 습득했으므로, 6이 가장 오래 전에 습득한 아이템이 됩니다.)
3 --- 3 5 4  (6을 버림)

이므로, 결과는 다음과 같아야 한다.
1
2
3
6
 */

public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		String[] inputNumbers = scanner.nextLine().split(" ");
		int[] inMyPocket = new int[3];
		int[] numArr = new int[inputNumbers.length];
		int arrIndex = 0;
		int dumpItem = 0;

		for(int i=0; i<numArr.length; i++) {
			numArr[i] = Integer.parseInt(inputNumbers[i]);

			if(i < 3) {
				inMyPocket[i] = numArr[i];
				dumpItem = numArr[i];
			} else {
				arrIndex = Arrays.binarySearch(inMyPocket, numArr[i]);

				/* 획득한 아이템이 이미 있을 때 */
				switch(arrIndex) {
				case 0:
					dumpItem = 0;
					break;
				case 1:
					inMyPocket[arrIndex] = inMyPocket[0];
					inMyPocket[0] = numArr[i];
					
					dumpItem = 0;
					break;
				case 2:
				default :	/* 획득한 아이템이 없을 때 */
					for(int j=inMyPocket.length-1; j>0; j--) {
						inMyPocket[j] = inMyPocket[j-1];
					}
					inMyPocket[0] = numArr[i];
					
					if(arrIndex != 2) {
						dumpItem = numArr[i];
					} else {
						dumpItem = 0;
					}
					break;
				}
			}
			
			System.out.print(dumpItem + "--------");
			for(int k=0; k<inMyPocket.length; k++) {
				System.out.print(inMyPocket[k] + " ");
			}
			System.out.println();
		}



		/* 서원이 풀이
      Scanner scanner = new Scanner(System.in);
      String s = null;
      s = scanner.nextLine();
      String[] sarr = new String[100];
      sarr = s.split(" ");
      int len=sarr.length;
      //System.out.println(sarr.length);
      int []arr=new int[len+1];
      for (int i = 0; i < sarr.length; i++) {
         arr[i]=Integer.parseInt(sarr[i]);
         //System.out.println(arr[i]);
      }

      Queue<Integer> q=new LinkedList<Integer>();

      q.add(arr[0]);
      int i=1;
      int []th=new int[len+1];
      while(i<len) {
         if(q.size()<3) {
            q.add(arr[i]);
            //System.out.println(arr[i]);
         }
         else if(q.size()==3) {
            int now=q.poll();
            if(now!=arr[i]) {
               //System.out.println(now);
               th[i]=now;
               System.out.println(th[i]);
            }
            q.add(arr[i]);


         }
      i++;
      }
      if(th[0]==0) {
         System.out.println("0");
      }*/
	}

}
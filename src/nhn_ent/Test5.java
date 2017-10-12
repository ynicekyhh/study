package nhn_ent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
조건 순으로 정렬
조건1 : 성별	(M < W)
조건2 : 나이	- 7세 이하(어릴수록 높음)
			- 7세 이상(많을수록 높음)
조건3 : 장애유무, 노약자 (YES > NO)

-----input-----
2 1 3	<- 조건 순서 입력
5		<- 5명
M 20 Y
W 5		<- 조건3은 없으면 안적음
W 3 Y
M 60 Y
M 25


2 1 3
10
M 20 Y
M 20 N
W 20 N
W 5
W 5 Y
W 3 Y
M 60 N
M 60 Y
W 60 Y
M 25
-----output----
정렬해서 출력
 */

public class Test5 {

	//	public enum Condition {sex, age, senior}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] conditionOrder = new int[3];
		int personCnt = 0;

		String[] persons;
		String[] orderedPersons;

		char[] sex;
		int[] age;
		char[] senior;

		String[] temp;

		/* ----------------- initialize ----------------- */
		String[] inputConditions = scanner.nextLine().split(" ");

		for(int i=0; i<conditionOrder.length; i++) {
			conditionOrder[i] = Integer.parseInt(inputConditions[i]);
		}

		personCnt = Integer.parseInt(scanner.nextLine());

		persons = new String[personCnt];
		orderedPersons = new String[personCnt];
		sex = new char[personCnt];
		age = new int[personCnt];
		senior = new char[personCnt];


		for(int i=0; i<personCnt; i++) {
			persons[i] = scanner.nextLine();

			temp = persons[i].split(" ");
			sex[i] = temp[0].charAt(0);
			age[i] = Integer.parseInt(temp[1]);

			if(temp.length > 2) {
				senior[i] = temp[2].charAt(0);
			}
		}
		/* ----------------- end init ------------------- */

		orderedPersons = ordering(persons, sex, age, senior, conditionOrder, 0);

		for(String person : orderedPersons) {
			System.out.println(person);
		}
	}

	private static String[] ordering(String[] persons, char[] sex, int[] age, char[] senior, int[] conditionOrder, int index) {
		if(index > 2) {
			return persons;
		}
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] resultA = null;
		String[] resultB = null;
		String[] result = new String[persons.length];

		switch(conditionOrder[index]) {
		case 1:
			map = orderBySex(persons, sex, map);
			break;
		case 2:
			map = orderByAge(persons, age, map);
			break;
		case 3:
			map = orderBySenior(persons, senior, map);
			break;
		default :
			break;
		}

		if(index < conditionOrder.length) {
			resultA = ordering(map.get("resultA"), sex, age, senior, conditionOrder, index+1);
			resultB = ordering(map.get("resultB"), sex, age, senior, conditionOrder, index+1);

			for(int i=0; i<resultA.length; i++) {
				result[i] = resultA[i];
			}

			for(int i=resultA.length; i<resultA.length + resultB.length; i++) {
				result[i] = resultB[i-resultA.length];
			}
		}

		return result;
	}

	private static Map<String, String[]> orderBySex(String[] persons, char[] sex, Map<String, String[]> map) {
		String[] resultA = null;
		String[] resultB = null;
		int indexA = 0;
		int indexB = 0;

		int personLen = persons.length;

		/* resultA, resultB의 크기 구하기 */
		for(int i=0; i<personLen; i++) {
			if(sex[i] == 'M') {
				indexA++;
			} else {
				indexB++;
			}
		}
		resultA = new String[indexA];
		resultB = new String[indexB];
		indexA=0;
		indexB=0;

		for(int i=0; i<personLen; i++) {
			if(sex[i] == 'M') {
				resultA[indexA++] = persons[i];
			} else {
				resultB[indexB++] = persons[i];
			}
		}

		map.put("resultA", resultA);
		map.put("resultB", resultB);

		return map;
	}

	private static Map<String, String[]> orderByAge(String[] persons, int[] age, Map<String, String[]> map) {
		String[] resultA = null;
		String[] resultB = null;
		int indexA = 0;
		int indexB = 0;

		int personLen = persons.length;

		/* resultA, resultB의 크기 구하기 */
		for(int i=0; i<personLen; i++) {
			if(age[i] <= 7) {
				indexA++;
			} else {
				indexB++;
			}
		}
		resultA = new String[indexA];
		resultB = new String[indexB];
		int[] ageA = new int[indexA];
		int[] ageB = new int[indexB];
		
		indexA=0;
		indexB=0;

		for(int i=0; i<personLen; i++) {
			if(age[i] <= 7) {
				resultA[indexA] = persons[i];
				ageA[indexA++] = age[i]; 
			} else {
				resultB[indexB] = persons[i];
				ageB[indexB++] = age[i];
			}
		}

		if(personLen > 1) {
			
			int tempNum = 0;
			String tempStr = null;

			/* 7세 이하 배열 정렬(나이 어린 순) */
			for(int i=0; i<indexA-1; i++) {
				for(int j=i; j<indexA; j++) {
					if(ageA[i] > ageA[j]) {
						tempNum = ageA[i];
						ageA[i] = ageA[j];
						ageA[j] = tempNum;

						tempStr = resultA[i];
						resultA[i] = resultA[j];
						resultA[j] = tempStr;
					}
				}
			}

			/* 7세 이상 배열 정렬(나이 많은 순) */
			for(int i=0; i<indexB-1; i++) {
				for(int j=i; j<indexB; j++) {
					if(ageB[i] < ageB[j]) {
						tempNum = ageB[i];
						ageB[i] = ageB[j];
						ageB[j] = tempNum;

						tempStr = resultB[i];
						resultB[i] = resultB[j];
						resultB[j] = tempStr;
					}
				}
			}
		}

		map.put("resultA", resultA);
		map.put("resultB", resultB);

		return map;
	}

	private static Map<String, String[]> orderBySenior(String[] persons, char[] senior, Map<String, String[]> map) {
		String[] resultA = null;
		String[] resultB = null;
		int indexA = 0;
		int indexB = 0;

		int personLen = persons.length;

		/* resultA, resultB의 크기 구하기 */
		for(int i=0; i<personLen; i++) {
			if(senior[i] == 'Y') {
				indexA++;
			} else {
				indexB++;
			}
		}
		resultA = new String[indexA];
		resultB = new String[indexB];
		indexA=0;
		indexB=0;

		for(int i=0; i<personLen; i++) {
			if(senior[i] == 'Y') {
				resultA[indexA++] = persons[i];
			} else {
				resultB[indexB++] = persons[i];
			}
		}

		map.put("resultA", resultA);
		map.put("resultB", resultB);

		return map;
	}

}

package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * Erdos와 같이 작업을 했으면 1촌, 1촌과 작업했으면 2촌, ...
 * -----input
 * 1
 * 4 3
 * Smith, M.N., Martin, G., Erdos, P.: Newtonian forms of prime factor matrices
 * Smith, M.N., B, C: Newtonian forms of prime factor matrices
 * B, D: Newtonian forms of prime factor matrices
 * E: Newtonian forms of prime factor matrices
 * Smith, M.N.
 * B
 * E
 * 
 * -----output
 * Smith, M.N. 1
 * B 2
 * E infinity
 * 
 */

/*
1
4 3
Smith, M.N., Martin, G., Erdos, P.: Newtonian forms of prime factor matrices
Erdos, P., Reisig, W.: Stuttering in petri nets
Smith, M.N., Chen, X.: First oder derivates in structured programming
Jablonski, T., Hsueh, Z.: Selfstabilizing data structures
Smith, M.N.
Hsueh, Z.
Chen, X.
*/
public class Erdos {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashSet<HashSet<String>> thesisSet = new HashSet<HashSet<String>>();	//thesis들이 모인 set
		HashSet<String> writerSet = null;
		String[] compareName = null; 
		Map<String, Integer> map = null;

		while(scanner.hasNextLine()) {
			int scenarioNo = scanner.nextInt();
			int thesisNo = scanner.nextInt();
			int writerNo = scanner.nextInt();
			scanner.nextLine();

			
			/* ------- 논문에 포함된 저자들을 각각의 set에 저장 ------- */
			for(int index=0; index < thesisNo; index++) {
				String thesisLine = scanner.nextLine();

				writerSet = new HashSet<String>();	//하나의 논문에 참여한 사람들 set
				
				String names = thesisLine.split(":")[0];
				String[] writers = names.split(",");

				for(int i=0; i<writers.length; i+=2) {
					String writerName = writers[i].trim() + ", " + writers[i+1].trim();
					writerSet.add(writerName);
				}

				thesisSet.add(writerSet);
			}

			while(true) {
				int distance = 0;
				boolean erdosFlag = false;
				map = new HashMap<String, Integer>();
				
				/* Erdos부터 검색 */
				Iterator<HashSet<String>> thesisIterator = thesisSet.iterator();
				while(thesisIterator.hasNext()) {
					writerSet = thesisIterator.next();
					Iterator<String> writerIterator = writerSet.iterator();
					
					/*
					 * 1) writerSet에서 Erdos를 찾아서 value를 '0'으로 map에 저장
					 * 2) 같은 set안의 녀석들을 '1'을 value로 map저장
					 * 3) 이미 저장한 writerSet을 thesisSet에서 제거
					 * 4) map에서 value가 1인 녀석들을 찾아 배열로 저장
					 * 5) thesisSet에서 writerSet을 읽고, 거리가 1인 배열의 첫번째부터 있는지 비교
					 * 6) 거리가 1인 writerSet이 있으면 다른 놈들을 읽어, 이미 map에 저장되어 있지 않으면 거리+1을 하여 map에 저장
					 * 7) 다 반복 후 사용된 writerSet 제거
					 * 8) 이런식으로 반복 후 거리가 n인 배열의 녀석들을 writerSet에서 찾지 못하면 걔네들은 다 infinity
					 */
					
					
					
					
//					if(writerSet.contains("Erdos, P.")) {
//						
//						while(writerIterator.hasNext()) {
//							String name = writerIterator.next();
//
//							if("Erdos, P.".equals(name) && !erdosFlag ) {
//								distance = 0;
//								erdosFlag = true;
//							}else {
//								distance = 1;
//							}
//							map.put(name, distance);
//						}
//					} else {
//						boolean nameExist = false;
//						while(writerIterator.hasNext()) {
//							String name = writerIterator.next();
//							//Smith, M.N., Smith, M.N., Chen, X. 이런경우...
//							if(map.containsKey(name)) {
//								nameExist = true;
//							} else if(nameExist){
//								
//							}
//						}
//					}
				}
				
				break;
			}
			
			
			/* 검색하고자 하는 이름들을 저장 */
			compareName = new String[writerNo];
			for(int index=0; index < writerNo; index++ ) {
				compareName[index] = scanner.nextLine();
			}
		}

		scanner.close();
	}

}

package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Person {
	private String name;
	private int distance;
	private boolean visited = false;

	List<Person> list = null;

	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}

public class ErdosNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int S = 0;	//number of scenario 
		int P = 0;	//number of dissertation
		int N = 0;	//number of writer
		
		/**
		 * Erdos와의 거리
		 */
		int distance = 0;
		
		/**
		 * 	하나의 논문을 검색할 때 Erdos가 있으면 true
		 */
		boolean checkErdos = false;

		String nameLine = null;
		String[] names = null;
		String name = null;
		
		List<String> nameList = new ArrayList<String>();
		
		Map<String, Person> personMap = new HashMap<String, Person>();
		Person person = null;
		
		
		while(scanner.hasNext()) {
			//1. input scenario
//			S = scanner.nextInt();

			//2. input number of dissertation + ' ' + input number of writers
//			P = scanner.nextInt();
//			N = scanner.nextInt();

			// Smith, M.N., Martin, G., Erdos, P.: Newtonian forms of prime factor matrices
			// 한 줄 기준
			nameLine = scanner.nextLine().split(":")[0];
			names = nameLine.split(",");

			for(int i=1; i<names.length; i+=2) {
				name = makeFullName(i, names).trim();
				System.out.println(name);
				if("Erdos, P.".equals(name)) {
					checkErdos = true;
				}
				
				person = new Person();
				person.setName(name);
				
				if(!personMap.containsKey(name)) {
					personMap.put(name, person);
				}
				nameList.add(name);
			}
			
			for(int i=1; i<names.length; i+=2) {
				name = makeFullName(i, names);
				
				if(checkErdos) {
					/*
					 * 한 줄에 Erdos가 있으면 Erdos를 제외한 사람들 모두에게 거리 1, 방문 표시
					 */
					for(String nameInList : nameList) {
						person = personMap.get(nameInList);
						person.setVisited(true);

						if(!"Erdos, P.".equals(nameInList)) {
							person.setDistance(1);
						}
					}
				}else {
					/*
					 * Erdos가 없으면 자기 자신을 제외한 이미 방문한 사람들의 주변 사람들을 조사, 거리 + 1, 방문 표시 
					 */
					person = personMap.get(name);
					if(person.isVisited()) {
						for( String nameInList : nameList ) {
							if(!person.getName().equals(nameInList)) {
								
							}
						}
					}
					
				}
			}
			
			checkErdos = false;
		}//while(scanner.hasNext())
		scanner.close();
	}

	/*
	 * lastName + firstName
	 */
	private static String makeFullName(int i, String[] names) {
		return names[i-1] + "," + names[i];
	}

}

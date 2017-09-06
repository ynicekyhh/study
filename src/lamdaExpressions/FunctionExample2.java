package lamdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionExample2 {

	static FunctionExample2 fe = new FunctionExample2();
	
	class Student{
		private String name;
		private int englishScore;
		private int mathScore;
		
		public Student(String name, int englishScore, int mathScore) {
			this.name = name;
			this.englishScore = englishScore;
			this.mathScore = mathScore;
		}

		public String getName() {
			return name;
		}

		public int getEnglishScore() {
			return englishScore;
		}

		public int getMathScore() {
			return mathScore;
		}
	}
	
	private static List<Student> list = Arrays.asList(
			fe.new Student("가", 10, 20),
			fe.new Student("나", 30, 40)
			);
	
	public static double avg( ToIntFunction<Student> function ) {
		int sum = 0;
		for(Student student : list) {
			sum += function.applyAsInt(student);
		}
		
		return (double)sum/list.size();
	}
	
	public static void main(String[] args) {
		System.out.println("평균 영어 점수 : " + avg(e->e.getEnglishScore()));
		System.out.println("평균 수학 점수 : " + avg(m->m.getMathScore()));
	}

}

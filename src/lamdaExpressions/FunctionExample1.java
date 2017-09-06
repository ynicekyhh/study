package lamdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 {
	static FunctionExample1 fe = new FunctionExample1();

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
			fe.new Student("김용호", 100, 99),
			fe.new Student("신용권", 90, 80)
			);
	
	public static void printString(Function<Student, String> function) {
		for(Student student : list) {
			System.out.println(function.apply(student) + " ");
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> function) {
		for(Student student : list) {
			System.out.println(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("[학생 이름]");
		printString(t-> t.getName());
		
		System.out.println("[영어 점수]");
		printInt(f->f.getEnglishScore());
		
		System.out.println("[수학 점수]");
		printInt(c -> c.getMathScore());
	}

}

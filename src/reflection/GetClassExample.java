package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetClassExample {

	/*
	 * Class 객체를 이용하여 클래스의 생성자, 필드, 메소드 정보를 알아내는 것이 Reflection
	 */
	public static void main(String[] args) {
		String str = new String();
		Class clazz1 = str.getClass();
		
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName());
		System.out.println();
		
		try {
			Class clazz2= Class.forName("java.lang.String");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			Class clazz = Class.forName("java.lang.Math");
			System.out.println("[class name]");
			System.out.println(clazz.getName());
			System.out.println();
			System.out.println("[생성자 정보]");
			Constructor[] constructors = clazz.getDeclaredConstructors();
			for(Constructor constructor : constructors) {
				System.out.println(constructor.getName() + "(");
				Class[] parameters = constructor.getParameterTypes();
				printParameters(parameters);
				System.out.println(")");
				System.out.println();
			}
			
			/* 필드 타입과 필드 이름을 출력 */
			System.out.println("[필드 정보]");
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields) {
				System.out.println(field.getType().getSimpleName() + " " + field.getName());
			}

			/* 메서드 이름과 매개 변수를 출력 */
			Method[] methods = clazz.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println(method.getName() + "(");
				Class[] parameters = method.getParameterTypes();
				printParameters(parameters);
				System.out.println(")");
			}
			
			/* Class.forName()으로 가져온 클래스 정보를 가지고 newInstance()로 메서드 호출 가능
			 * 리턴타입이 Object이므로 강제 타입 변환 시 사용할 수 있음 */
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void printParameters(Class[] parameters) {
		for(int i=0; i < parameters.length; i++) {
			System.out.println(parameters[i].getName());
			if(i<(parameters.length-1)) {
				System.out.println(",");
			}
		}
	}

}

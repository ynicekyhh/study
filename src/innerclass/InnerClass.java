package innerclass;

public class InnerClass {
	String a = "OuterClass a";
	public static class StaticInnerClass{
		static String a = "StaticInnerClass static a";
		String b = "StaticInnerClass b";
	}
	
	public static class MemberInnerClass{
		static String a = "MemberInnerClass static a";
		String b = "MemberInnerClass b";
	}
}

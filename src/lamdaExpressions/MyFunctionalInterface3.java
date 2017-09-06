package lamdaExpressions;

/* interface에서 두 개 이상의 method가 있으면 컴파일 에러를 낸다. 람다식에서 interface는 하나의 메서드만 가져야 한다. */
@FunctionalInterface
public interface MyFunctionalInterface3 {
	public int method(int x, int y);
}

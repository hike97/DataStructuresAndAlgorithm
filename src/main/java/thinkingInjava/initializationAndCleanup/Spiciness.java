package thinkingInjava.initializationAndCleanup;

public enum Spiciness {
	NOT,MILD,MEDIUM,HOT,FLAMING
}
class SimpleEnumUse{
	public static void main (String[] args) {
		Spiciness medium = Spiciness.MEDIUM;
		System.out.println (medium);
		//创建枚举时，会创建toString()方法 ordinal()方法  以及static values() 方法
		for (Spiciness s : Spiciness.values ()) {
			System.out.println (s + ", ordinal " + s.ordinal ());
		}
	}
}

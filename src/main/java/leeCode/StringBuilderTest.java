package leeCode;

/**
 * @Author hike97
 * @Description
 * @create 2020-05-09 9:28
 * @Modified By:
 **/
public class StringBuilderTest {
	public static void main (String[] args) {
		String str = "八级大风暴";
		StringBuilder reverse = new StringBuilder (str).reverse ();
		System.out.println (reverse);
	}
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author hike97
 * @Description
 * @create 2020-06-15 15:09
 * @Modified By:
 **/
public class TestCode {
	public static void main (String[] args) {
//		boolean matches = "1".matches ("[1,3]");
//		boolean matches_ = "2".matches ("[1,3]");
//		System.out.println (matches+":"+matches_);
		UUID uuid = UUID.randomUUID ();
		System.out.println (uuid.toString ().replace ("-",""));
		//528e1258aac54cd9971f034d5e9fcc5b
		List<String> list = Arrays.asList ("1", "3", "5", "a", "b", "c", "8", "剔除", "无单剔除");
		List<String> filter = list.stream ().filter (s -> !("剔除".equals (s) || "无单剔除".equals (s))).collect (Collectors.toList ());
		filter.forEach (System.out::println);
	}
}



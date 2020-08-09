package thinkingInjava.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hike97 2month
 * @create 2020-07-12 9:38
 * @desc 正则表达式汇总
 **/
public class RegexDemo {
	public static void main (String[] args) {

		System.out.println ("-1234".matches ("-?\\d+"));
		System.out.println ("5678".matches ("-?\\d+"));
		System.out.println ("+911".matches ("-?\\d+"));
		//起始字符可能是一个-或+ 或者二者都没有
		System.out.println ("+911".matches ("(-|\\+)?\\d+"));
		System.out.println ();
		//判断一个句子是或否以大写字母开头，句号结尾
		System.out.println(matches("This is correct."));
		System.out.println(matches("bad sentence 1."));
		System.out.println(matches("Bad sentence 2"));
		System.out.println(matches("This is also correct..."));
		System.out.println ();

		String demo = "THE embedded flag expression (?i) enables case-insensitive matching. The\n" +
				"regular expression demonstrates how to handle mixed uppercase/lowercase\n" +
				"vowels, (though none occur above).";
		//(?i) 不区分大小写
		String result = demo.replaceAll ("(?i)[a,e,i,o,u]", "_");
		System.out.println ("替换所有元音字母");
		System.out.println (result);
		//regex and pattern
		String source = "Java now has regular expressions";
		String[] regEx = {"^Java", "\\Breg.*",
				"n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}.",
				"s{0,3}"};
		System.out.println("Source string: " + source);
		for(String pattern : regEx) {
			System.out.println(
					"Regular expression: \"" + pattern + "\"");
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(source);
			while(m.find()) {
				System.out.println("Match \"" + m.group() +
						"\" at positions " + m.start() + "-" +
						(m.end() - 1));
			}
		}

		//aeiou
		System.out.println ("aeiou");
		Pattern p = Pattern.compile(
				"(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
		Matcher m = p.matcher("Arline ate eight apples and " +
				"one orange while Anita hadn't any");
		while(m.find()) {
			System.out.println("Match \"" + m.group() +
					"\" at positions " + m.start() + "-" +
					(m.end() - 1));
		}


	}

	public static boolean matches(String text) {
		return text.matches("\\p{javaUpperCase}.*\\.");
	}
}

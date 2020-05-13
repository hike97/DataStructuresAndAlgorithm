package thinkingInjava.interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 * @author hike97 2month
 * @create 2020-04-18 21:43
 * @desc 策略设计模式 ：创建一个能够根据所传递的参数对象的不同而具有不同行为的方法 改进：将Processor 改为一个接口用于复用
 **/
interface Processor {
 	String name();
	Object process(Object input);
}

abstract class StringProcessor implements Processor {
	public String name(){
		return getClass ().getSimpleName ();
	}
	public abstract String process (Object input);
}

class Upcase extends StringProcessor {
	public String process (Object input){
		return ((String) input).toUpperCase ();
	}
}

class Downcase extends StringProcessor {
	public String process (Object input){
		return ((String) input).toLowerCase ();
	}
}

class Splitter extends StringProcessor {
	public String process (Object input){
		return Arrays.toString (((String) input).split (" "));
	}
}

public class Apply {
	static void process(Processor p , Object s){
		System.out.println ("Using Processor :"+p.name ());
		System.out.println (p.process (s));
	}

	public static void main (String[] args) {
		String s = "Hello World";
		process (new Upcase (),s);
		process (new Downcase (),s);
		process (new Splitter (),s);
	}
}

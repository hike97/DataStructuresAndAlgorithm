package thinkingInjava.interfaces;

import java.util.Arrays;

/**
 * @author hike97 2month
 * @create 2020-04-18 21:43
 * @desc 策略设计模式 ：创建一个能够根据所传递的参数对象的不同而具有不同行为的方法
 **/
class Processor {
 	public String name(){
 		return getClass ().getSimpleName ();
	}
	Object process(Object input){
 		return input;
	}
}
class Upcase extends Processor{
	String process(Object input){
		return ((String) input).toUpperCase ();
	}
}
class Downcase extends Processor{
	String process(Object input){
		return ((String) input).toLowerCase ();
	}
}
class Splitter extends Processor{
	String process(Object input){
		return Arrays.toString (((String) input).split (" "));
	}
}
public class Apply {
	static void process(Processor p ,Object s){
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

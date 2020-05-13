package thinkingInjava.interfaces;

/**
 * @author hike97 2month
 * @create 2020-04-18 20:06
 * @desc
 **/


import static net.mindview.util.Print.print;

/**
 * @author hike97 2month
 * @create 2020-04-18 14:06
 * @desc
 **/
enum Note{
	MIDDLE_C,C_SHARP,B_FLAT;//etc
}
abstract class Instrument{
	abstract void play (Note n);
	public String toString (){
		return "Instrument";
	}
	abstract void adjust ();

}
class Wind extends Instrument {
	void play(Note n){
		System.out.println ("Wind.play():\n"+n);
	}
	public String toString (){
		return "Wind";
	}
	void adjust(){
		System.out.println ("Adjusting Wind");
	}
}
class Percussion extends Instrument {
	void play(Note n){
		System.out.println ("Percussion.play():\n"+n);
	}
	public String toString (){
		return "Percussion";
	}
	void adjust(){
		System.out.println ("Percussion Wind");
	}
}

class Stringed extends Instrument {
	void play(Note n){
		System.out.println ("Stringed.play():\n"+n);
	}
	public String toString (){
		return "Stringed";
	}
	void adjust(){
		System.out.println ("Adjusting Stringed");
	}
}

class Brass extends Wind {
	void play(Note n){
		System.out.println ("Brass.play():\n"+n);
	}
	public String toString (){
		return "Brass";
	}
}
class Woodwind extends Wind {
	void play(Note n){
		System.out.println ("Woodwind.play():\n"+n);
	}
	void adjust(){
		System.out.println ("Adjusting Woodwind");
	}
}

class Electronic extends Instrument {
	void play(Note n) { print("Electronic.play() " + n); }
	public String toString() { return "Electronic"; }

	@Override
	void adjust () {

	}
}

class InstrumentGenerator {
	java.util.Random gen = new java.util.Random(47);
	public Instrument next() {
		switch(gen.nextInt(6)) {
			default:
			case 0: return new Wind ();
			case 1: return new Percussion ();
			case 2: return new Stringed ();
			case 3: return new Brass ();
			case 4: return new Woodwind ();
			case 5: return new Electronic ();
		}
	}
}
class InstrumentGenerator2 {
	java.util.Random gen = new java.util.Random(47);
	Class<?> instruments[] = {
			Wind.class,
			Percussion.class,
			Stringed.class,
			Brass.class,
			Woodwind.class,
			Electronic.class,
	};
	public Instrument next() {
		try {
			int idx = Math.abs(gen.nextInt(instruments.length));
			return (Instrument) instruments[idx].newInstance();
		} catch(Exception e) {
			throw new RuntimeException("Cannot Create", e);
		}
	}
}




public class Music4 {
	static void tune(Instrument i){
		i.play (Note.MIDDLE_C);
	}
	static void tuneAll(Instrument[] e){
		for (Instrument i : e) {
			tune (i);
		}
	}

	static void printAll(Instrument[] e){
		for (Instrument i : e) {
			System.out.println (e);
		}
	}


	public static void main (String[] args) {
		InstrumentGenerator gen = new InstrumentGenerator ();
		InstrumentGenerator2 gen2 = new InstrumentGenerator2 ();
		Instrument[] orchestra = {
				new Wind (),new Percussion (),new Stringed (),new Brass (),new Woodwind (),new Electronic ()
		};
		//		tuneAll (orchestra);
		//		printAll (orchestra);
		//		for(int i = 0; i < 20; i++)
		//			System.out.println(gen.next());
		for(int i = 0; i < 20; i++)
			System.out.println(gen2.next());
	}

}


package thinkingInjava.reusing;

/**
 * @author hike97 2month
 * @create 2020-04-13 18:22
 * @desc  向上转型 :将Wind转为Instrument
 **/
class Instrument {
	void play(){}
	static void tune(Instrument i){
		i.play ();
	}
}
public class Wind extends Instrument{
	public static void main (String[] args) {
		Instrument.tune (new Wind ());
	}
}

package thinkingInjava.interfaces.interfaceprocessor;

/**
 * @author hike97 2month
 * @create 2020-04-18 22:06
 * @desc 适配器设计模式
 **/
class Waveform{
	private static  long counter;
	private final long id = counter++;

	@Override
	public String toString () {
		return "Waveform{" +
				"id=" + id +
				'}';
	}
}
class Filter {
	public String name(){
		return getClass ().getSimpleName ();
	}
	public Waveform process (Waveform input){
		return input;
	}
}

class LowPass extends Filter{
	double cutoff;

	public LowPass (double cutoff) {
		this.cutoff = cutoff;
	}
}
class HighPass extends Filter{
	double cutoff;

	public HighPass (double cutoff) {
		this.cutoff = cutoff;
	}
}

class BandPass extends Filter{
	double lowCutoff,highCutooff;

	public BandPass (double lowCutoff, double highCutooff) {
		this.lowCutoff = lowCutoff;
		this.highCutooff = highCutooff;
	}
}

public class FilterAdapter implements Processor {
	Filter filter;

	public FilterAdapter (Filter filter) {
		this.filter = filter;
	}

	@Override
	public String name () {
		return filter.name ();
	}

	@Override
	public Waveform process (Object input) {
		return filter.process ((Waveform) input);
	}

	public static void main (String[] args) {
		Waveform waveform = new Waveform ();
		Apply.process (new FilterAdapter (new LowPass (1.0)),waveform);
		Apply.process (new FilterAdapter (new HighPass (3.0)),waveform);
		Apply.process (new FilterAdapter (new BandPass (1.0,2.0)),waveform);
	}
}

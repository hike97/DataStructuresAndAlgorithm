package thinkingInjava.innerclasses;

/**
 * @author hike97 2month
 * @create 2020-04-22 0:31
 * @desc
 **/
class Sequence2 {
	private Object[] items;
	private int next;
	public Sequence2(int size) { items = new Object[size]; }
	public void add(Object x) {
		if(next < items.length)
			items[next++] = x;
	}
	private class SequenceSelector implements Selector {
		private int i;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; }
		public Sequence2 sequence() { return Sequence2.this; }
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	public boolean check() {
		return
				this == ((SequenceSelector)selector()).sequence();
	}
}
public class E04_SequenceSelectorToSequence {
	public static void main(String[] args) {
		Sequence2 s = new Sequence2(10);
		System.out.println(s.check());
	}
}

package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {
	private int[] a1,a2;
	public TwoArrays(int[] a1, int[] a2) {//constructor
		this.a1=a1;
		this.a2=a2;
	}
	private class Iterator1 implements Iterator<Integer>{
		private int count=0;//the index for the arrays
		private int counter=0;//counter to check when to get bigger the count
		@Override
		public boolean hasNext() {//check that we have numbers in at least 1 array
			if(count<a1.length||count<a2.length)
				return true;
			return false;
		}

		@Override
		public Integer next() {
			if(count<a1.length&&count<a2.length) {//if we have numbers in both arrays
				if(counter%2==0) {//if counter modulu 2 so count stay else he get bigger
					counter++;
					return a1[count];
				}
				else {
					counter++;
					return a2[count++];
				}
			}
			else if(count<a1.length) {//check in which array has numbers
				return a1[count++];
			}
			return a2[count++];
			
		}
		
	}

	@Override
	public Iterator<Integer> iterator() 
	{
		return new Iterator1();
	}
}

package iterator;

import java.util.Iterator;



public class Combined<E> implements Iterable<E> {
	private Iterable<E> first,second;
	public Combined(Iterable<E> first, Iterable<E> second) {//constructor
		this.first=first;
		this.second=second;
	}
	
	private class Iterator2 implements Iterator<E>{
		private int counter=0;//to check which array we go
		private Iterator<E> itfirst=first.iterator();//get the iterators
		private Iterator<E> itsecond=second.iterator();
		@Override
		public boolean hasNext() {//check that we E numbers in at least 1 Iterable
			if(itfirst.hasNext()==true||itsecond.hasNext()==true)
				return true;
			return false;
		}

		@Override
		public E next() {
			if(itfirst.hasNext()==true&&itsecond.hasNext()==true) {//if we have E in both Iterable
				if(counter%2==0) {//counter modulu 2 define whice Iterable to return
					counter++;
					return itfirst.next();
				}
				else {
					counter++;
					return itsecond.next();
				}
			}
			else if(itfirst.hasNext()==true) {//check in which Iterable has E
				return itfirst.next();
			}
			return itsecond.next();
			
		}
			
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iterator2();
	}

}

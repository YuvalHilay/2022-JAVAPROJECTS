package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator  {
	private int []x;
	private int index;
	public MyArray(int[]x)//constructor
	{
		this.x=x;
		index=0;
	}
	@Override
	public boolean hasNext() {//check if there is next number
		if(index<x.length)
			return true;
		return false;
	}
	@Override
	public int next() {//run on x and return next number
		if(index>=x.length)
			throw new NoSuchElementException();
		return x[index++];
	}

}

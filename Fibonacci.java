package iterator;

public class Fibonacci implements MyIterator {
	private int upperBound; 
	private int firstlast, secondlast, timerun;//define variables for the last 2 numbers in the Fibonacci
	public Fibonacci(int upperBound)//constructor
	{
		this.upperBound=upperBound;
		firstlast=1;
		secondlast=1;
		timerun=0;	
	}
	@Override
	public boolean hasNext() {//check if next number is bigger than upperBound
		if(firstlast+secondlast<=upperBound)
			return true;
		else
			return false;
	}

	@Override
	public int next() {//calc next number in Fibonacci
		int temp;
		if(timerun==0||timerun==1)//check if this first or second time
		{
			timerun++;
			return firstlast;
		}
		if(hasNext()==false)//check if next number is bigger than upperBound
		{
			return firstlast;
		}
		temp=firstlast; //calc next number and return him
		firstlast=firstlast+secondlast;
		secondlast=temp;
		return firstlast;
		
	}

}

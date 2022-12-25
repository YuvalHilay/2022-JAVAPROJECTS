package root;

public class Rooter 
{
	private double precision;//field of Rooter
	
	//initializing an object of Rooter with certain precision level
	public Rooter(double precision)
	{
		this.precision=precision;
	}

	//function that set the precision level
	public void setPrecision(double precision)
	{
		this.precision=precision;
	}

	//function that calculate square root of x with precision level
	public double sqrt(double x)
	{
		double one=x/2;
		
		double two=x/one;
		
		while((one!=two) && (Math.abs(one-two)>=precision)) {
			
			one=(one+two)/2;
			
			two=x/one;
		}
		return one;
	}
}

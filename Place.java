package graph;

/*
class that describe 2D place in square 
*/
public class Place {
	private int x, y;
	public Place(int x, int y, int bound) {//constructor
		if(x<0 || x>bound-1 ||y<0 ||y>bound-1)//check if point in the frame
			throw new IllegalArgumentException();
		else
			this.x=x;
			this.y=y;
	}
	
	//return the x value
	public int getX() {
		return x;
	}
	
	//return the y value
	public int getY() {
		return y;
	}
	
	//checking if two places are equals
	@Override
	public boolean equals(Object obj) {
		Place other =(Place)obj;//casting
		if(this.x==other.x && this.y==other.y)
			return true;
		return false;
	}
	
	//function that calculate the hash code
	@Override 
	public int hashCode() {
		return Long.hashCode(x)*31+Long.hashCode(y);
	}
	
	
	@Override
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}


}

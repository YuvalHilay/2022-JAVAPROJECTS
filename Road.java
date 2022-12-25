package cities;

public class Road 
{
	private City city1;//fields of Road
	private City city2;
	private int length;
	
	// constructor of the class
	public Road(City city1,City city2,int length)
	{
		this.city1=city1;
		this.city2=city2;
		this.length=length;
		
		city1.connect(this);
		city2.connect(this);
	}
	
	
	public City getCity1()//returning the first city connected to the road
	{
		return city1;
	}
	
	public City getCity2()//returning the second city connected to the road
	{
		return city2;
	}
	
	public int getLength()//returning the length of the road
	{
		return length;
	}
}

package library;

public class Author 
{
	private String name; //fields of Author
	private int birthYear;
	
	// constructor of the class
	public Author(String name,int birthYear)
	{
		this.name=name;
		this.birthYear=birthYear;
	}
	
	public String getName() //returning the name of the author
	{
		return name;
	}
	
	public int getBirthYear() //returning the birth year of the author
	{
		return birthYear;
	}
	
	public int getAge(int thisYear) //getting year and calculate the age of the author
	{
		return (thisYear-birthYear);
	}
	
	public String toString() //returning the name of the author and his birthYear in one string
	{
		return String.format("%s(%d)",name,birthYear);
	}
}


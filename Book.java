package library;

public class Book 
{
	private String title;//fields of Book
	private Author auth;
	
	// constructor of the class
	public Book(String title,Author auth) 
	{
		this.title=title;
		this.auth=auth;
	}
	
	public String getTitle()//returning the title of the book
	{
		return title;
	}
	
	public String getAuthorName()//returning the name of the book's author
	{
		return auth.getName();
	}
	
	public int getAuthorBirthYear()//returning the birth date of the book's author
	{
		return auth.getBirthYear();
	}
	
	public String toString()//returning the book's title and the author's name and birth date
	{
		return String.format("%s written by %s", title,auth);
	}
}

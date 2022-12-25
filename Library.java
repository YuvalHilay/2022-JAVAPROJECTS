package library;

public class Library 
{
	private Book[] bookArray;//field of Library
	
	// constructor of the class
	public Library(int size)
	{
		bookArray=new Book[size];
	}
	
	//function that add new book to the library
	public void setBook(int bookNum,String title,Author auth)
	{
		Book b1=new Book(title,auth);
		
		bookArray[bookNum]=b1;
	}
	
	//returning the book in the selected place
	public Book getBook(int bookNum)
	{
		if((bookNum>bookArray.length)||(bookNum<0))
			return null;
		
		else
			return bookArray[bookNum];
	}
}

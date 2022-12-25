package bank;
/*
 This class describe an object as Account in Bank's system
 */
public class Account 
{
    //fields of Account
	private String name;
	private int amountOfShekels;
	
	public Account(String name) //Constructor of Account class
	{
		this.name=name;
		amountOfShekels=0;
	}
	
	public int getShekels() //Function that return the amount of money in shekels
	{
		return amountOfShekels;
	}
	
	public String getName() //Function that return the name of the account's owner
	{
		return name;
	}
	
	public void add(int amount) //Function that add amount of money to the account
	{
		amountOfShekels=amountOfShekels+amount;
	}
	
	@Override
	public String toString() //Function that return the name of the account's owner and the amount of
	{                        //money he has in the account
		
		return String.format("%s has %d shekels",name,amountOfShekels);
	}
}

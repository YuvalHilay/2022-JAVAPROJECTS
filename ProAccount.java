package bank;
/*
This class describe an object as Account with history in Bank's system
*/
public class ProAccount extends Account
{
	//fields of ProAccount
	private int history[]; //array that has the history of the account
	private int amountOfHistory; //variable that holds the amount of history to this point
	
	public ProAccount(String name)//Constructor of ProAccount class
	{
		super(name);
		history=new int[100];//the history is no more then 100 info
		amountOfHistory=0;
	}
	
	@Override
	public void add(int amount)// Function that add amount of money to the account and saving it 
	{                          // in the account history
		super.add(amount);
		history[amountOfHistory]=super.getShekels();
		amountOfHistory=amountOfHistory+1;
	}
	
	@Override
	public String toString() //Function that return the name of the account's owner and the amount of
	{                        //money he has in the account with the history of the account
		String s=super.toString();
		s=s+" [";
		for(int i=0;i<amountOfHistory;i++)
		{
			s=s+history[i];
			if((i+1)!=amountOfHistory)
				s=s+",";
		}
		s=s+"]";
		return s;
	}
	// Function that transfer money from account number 1 to account number 2
	public static void transfer(ProAccount from,ProAccount to,int amount)
	{
		from.add((amount)*(-1));
		to.add(amount);
	}
	
}

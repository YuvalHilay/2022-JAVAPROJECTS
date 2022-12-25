package tree;

public class Node {
	private int count;
	private Node[] children = new Node['z'-'a'+1];
	public int num(String s)
	{
		if(s.length()==1) {//condition for stop
			if(children[25-('z'-s.charAt(0))]==null)
				return 0;
			else
				return children[25-('z'-s.charAt(0))].count;
		}
		if(children[25-('z'-s.charAt(0))]==null)//condition for stop
			return 0;
		return children[25-('z'-s.charAt(0))].num(s.substring(1));//recursive call
	}
	public void add(String s)
    {
		if(s.length()==1)//condition for stop
		{
			if(children[25-('z'-s.charAt(0))]!=null)//if node Exists
				children[25-('z'-s.charAt(0))].count++;
			
			else
			{
				children[25-('z'-s.charAt(0))]=new Node();//if node doesn't Exists
				children[25-('z'-s.charAt(0))].count=1;
			}
		}
		else
		{
			if(children[25-('z'-s.charAt(0))]==null)//if node in the way doesn't Exists create him
				children[25-('z'-s.charAt(0))]=new Node();
			
			children[25-('z'-s.charAt(0))].add(s.substring(1));//recursive call
		}
	}
	
}

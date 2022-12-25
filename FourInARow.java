package game;

public class FourInARow extends Game {
	public FourInARow(String player1, String player2) {
		super(6,7,new Player(player1,'W'),new Player(player2,'B'));
	}
	@Override
	protected boolean doesWin(int i, int j) {//override when player win
		if(maxLineContaining(i,j)>=4)
			return true;
		return false;
	}
	@Override
	protected boolean onePlay(Player p) {
		int x=0,y;
		boolean flag=false;
		do {
			System.out.format("%s, please enter column:",p);
			y=s.nextInt(); //take input for column
			if(get(0,y)!=null) {//check if column is full
				flag=true;
				System.out.println("column is full please try again...");
			}
			else
				flag=false;
		}while(flag); //keep take input until given column is not full
		while(get(x,y)==null) {//calc the correct row to put
			x++;
			if(x==6) {
				break;
			}
				
		}
		x--;
		set(x,y,p);//put player mark
		return doesWin(x,y);//check if win
	}
}

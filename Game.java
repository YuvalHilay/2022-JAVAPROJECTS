package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s = new Scanner(System.in);
	public Game(int n, int m, Player p1, Player p2) {//constructor
		super(n,m);
		players=new Player[2];
		players[0]=p1;
		players[1]=p2;
	}
	protected boolean doesWin(int i, int j) {//func return win if you put in index (0,0)
		if(i==0&&j==0)
			return true;
		return false;
	}
	protected boolean onePlay(Player p) {//func that implements one round of play
		int x,y;
		boolean flag=false;
		do {
			System.out.format("%s, please enter x and y:",p);
			x=s.nextInt(); //take input from user
			y=s.nextInt();
			if(set(x,y,p)==false) {//check if place is free
				flag=true;
				System.out.println("There is a piece there already...");
			}
			else
				flag=false;
		}while(flag);
		return doesWin(x,y);//check if win
	}
	public Player play() {
		int flag0=0,flag1=0;
		while(isFull()==false) {//while there is place in board
			if(onePlay(players[0])) {//player0 play
				flag0=1;
				break;
			}
			System.out.println(toString()); //print board
			if(onePlay(players[1])) {//player1 play
				flag1=1;
				break;
			}
			System.out.println(toString()); //print board
		}
		if(flag0==1) {//check if player0 win
			System.out.println(toString());
			System.out.format("%s won!",players[0]);
			return players[0];	
		}
		else if(flag1==1) {//check if player1 win
			System.out.println(toString());
			System.out.format("%s won!",players[1]);
			return players[1];	
		}
			
		else
			return null;
	}

}

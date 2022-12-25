package cards;

public class Card {
	
	private int num, suit; //fields of card
	 
	public Card(int num, int suit) {//constructor of card
		this.num=num;
		this.suit=suit;
	}
	public int getNum() { //return the number of card
		return num;
	}
	public int getSuit() {//return the suit of card
		return suit;
	}
	public String toString() {//build a string of the card
		String s1 = "";
		if(suit==0)
			s1+="C";
		else if(suit==1)
			s1+="D";
		else if(suit==2)
			s1+="H";
		else
			s1+="S";
		return String.format("%d%s",num,s1);
	}
	public int compareTo(Card other) {//check which card is bigger
		if(num==other.num &&suit==other.suit)
			return 0;
		int x=num-other.num;
		int y=suit-other.suit;
		if(x!=0)
			return x;
		else if(y!=0)
			return y;
		else
			return 0;
 
	}
}

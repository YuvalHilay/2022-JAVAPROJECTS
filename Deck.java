package cards;

public class Deck {
	
	private Card[] arr; //fields of deck
	private int num;
 
	public Deck(int num) {  //constructor build deck of cards from zero to num with cards of all kinds
		this.num=num*4;
		arr =new Card[num*4];
		int j=0;
		for(int i=0; i<arr.length;i=i+4) { //build the deck
			arr[i]=new Card(j,0);
			arr[i+1]=new Card(j,1);
			arr[i+2]=new Card(j,2);
			arr[i+3]=new Card(j,3);
			j++;
		}
	}
	public Deck(Deck from, int num) { //constructor Builds a deck of cards so each time he takes a card from the end of the deck he received
		if(num>from.num) {    //check that num isnt bigger than from size
			arr=new Card[from.num];
			this.num=from.num;
		}
		else
			arr=new Card[num];
			this.num=num;
		for(int i =0; i<this.num;i++) { //build the deck
			arr[i]=from.takeOne();
		}
	}
	public Deck(Deck first, Deck second) { //constructor Builds a deck of cards so each time takes a card from the end of the first deck he received and then the end of the second deck
		num=first.num+second.num; //initialization num
		arr=new Card[num];
		int minlen;
		int i, k=0;
		if(first.num<second.num)//calc minlen of two decks
			minlen=first.num;
		else
			minlen=second.num;
		for(i=0;i<minlen; i++) {//run on minlen and start build the deck
			arr[k]=first.takeOne();
			arr[k+1]=second.takeOne();
			k=k+2;
		}
		int first1 = first.num;
		int second1 = second.num;
		if(first.num==0) { //Checks which deck of cards are remain cards and runs on it
			for(int j=0;j<second1;j++) {
				arr[k]=second.takeOne();
				k++;
			}
		}
		else {
			for(int j=0;j<first1;j++) {
				arr[k]=first.takeOne();
				k++;
 
			}
		}
 
	}
	public int getNumCards() {//return the number of cards in the deck
		return num;
	}
	public Card takeOne() {//Returns the last card in the deck and removes it
		if(num==0)
			return null;
		else {
			num=num-1;
			return arr[num];
		}
 
	}
	public String toString() {//build a string of the deck
		String s="[";
		for(int i=0 ; i<num ; i++) {
			if(i!=num-1)
				s+=arr[i]+", ";
			else
				s+=arr[i];
		}
		s+="]";
		return s;
	}
	public void sort() {//bubble sort
		for (int i=1; i<arr.length;i++) {
			for(int j =i; j>0 && arr[j].compareTo(arr[j-1])<0;j--) {
				Card temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
			}
		}
 
	}
}

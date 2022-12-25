package shop;

/*
Class that describe musical Instruments
*/
public abstract class Instrument {
	private String company; //company details
	private int price;  //price
	private int Serialnum; //serial number 
	private static int Serial=0; 
	
	public Instrument(String company,int price) {//constructor
		this.company=company;
		this.price=price;
		Serialnum=Serial;
		Serial++;
	}
	
	//return the Price
	public int getPrice() {
		return price;
	}
	
	//return the company
	public String getCompany() {
		return company;
	}
	
	//return the serial
	public int getSerial() {
		return Serialnum;
	}
	
	@Override
	public String toString() {//common part tostring
		return String.format("%s(%d), price = %d",getCompany(),getSerial(),getPrice());
	}
}

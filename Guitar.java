package shop;

/*
Class that describe piano
*/
public class Guitar extends Instrument {
	private Type type; //type of guitar
	
	public Guitar(String company, int price, Type type) {//constructor
		super(company,price);
		this.type=type;
	}
	
	//return the type of the guitar
	public Type getType() {
		return type;
	}
	
	@Override
	public String toString() {//tostring using super
		return String.format("%s(%s) %s",getClass().getSimpleName(),getType(),super.toString());
	}
}

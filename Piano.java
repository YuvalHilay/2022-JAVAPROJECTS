package shop;

/*
Class that describe piano
*/
public class Piano extends Instrument {
	private int octaves; //amount of octaves
	
	public Piano(String company, int price, int octaves) {//constructor
		super(company,price);
		this.octaves=octaves;
	}
	
	//return the number of octaves
	public int getOctaves() {
		return octaves;
	}
	
	@Override
	public String toString() {//tostring using super
		return String.format("%s(%d octaves) %s",getClass().getSimpleName(),getOctaves(),super.toString());
	}
}

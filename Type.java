package shop;

/*
Class that types of guitar
*/
public enum Type {
	ACOUSTIC, ELECTRIC, CLASSICAL;
	
	@Override
	public String toString() {//check what string to return
		if(this.equals(ACOUSTIC))
			return "Acoustic";
		else if(this.equals(ELECTRIC))
			return "Electric";
		else if(this.equals(CLASSICAL))
			return "Classical";
		else
			return "";
	}
}

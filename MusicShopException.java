package shop;

/*
Class that describe exception for the musical Instruments 
*/
public class MusicShopException extends Exception {
	private static final long serialVersionUID = 1L;
	public MusicShopException(String msg) {
		super(msg); //error message
	}
}

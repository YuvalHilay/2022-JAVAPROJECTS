package game;

public class Player {
	private String name;
	private char mark;
	public Player(String name, char mark) {//constructor
		this.name=name;
		this.mark=mark;
	}
	public String getName() {//geters
		return name;
	}
	public char getMark() {
		return mark;
	}
	public String toString() {
		return String.format("%s(%c)",name,mark);
	}
}

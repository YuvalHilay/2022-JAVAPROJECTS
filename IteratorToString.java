package iterator;

public class IteratorToString {
	
	public static String toString(MyIterator it) {
		StringBuilder b=new StringBuilder();//create string using StringBuilder
		b.append("[");
		while(it.hasNext()==true) {//while there is next number append him
			b.append(it.next()+" ");
		}
		b.deleteCharAt(b.length() - 1 );//delete last space
		b.append("]");
		return b.toString();
	}

}

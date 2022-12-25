package equiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Generic class that describes equilibrium ratio 
*/
public class Equiv<E> {
	private List<Set<E>> eqArray=new ArrayList<>();//define our array
	private Set<E> find(E e){//help func that get E and return his set
		for(Set<E> i:eqArray) {
			for(E j:i)  {
				if(j.equals(e))
					return i;
			}
		}
		return null;
	}
	public void add(E e1, E e2) {//func that add e1 and e2 save the equals
		 Set<E> set1=find(e1);//fund set e1 and e2
		 Set<E> set2=find(e2);
		 if(are(e1,e2)==true)//check if they equal
			 return;
		 else if(set1==null&&set2==null) {//check if their not in any set, so create new one 
			Set<E> newset = new HashSet<>();
			newset.add(e2);
			newset.add(e1);
			eqArray.add(newset);
		 }
		 else if(set1==null&&set2!=null) {//if only one of them in set so add the other
			 set2.add(e1);
		 }
		 else if(set1!=null&&set2==null) {
			 set1.add(e2);
		 }
		 else {
			set1.addAll(set2); //if both in set add all set2 to set1 and delete set2
			eqArray.remove(set2);
		 }
			 
		 
	}
	public boolean are(E e1, E e2) {//func check if e1 and e2 equals
		if(e1.equals(e2))//if they are the same
			return true;
		Set<E> set1=find(e1);//check if they in same set
		Set<E> set2=find(e2);
		if(set1==null||set2==null)
			return false;
		else if(set1.equals(set2)) 
			return true;
		return false;
	}




}

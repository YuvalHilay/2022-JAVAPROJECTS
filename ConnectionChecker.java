package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
class that check if two vertices are connected in graph
*/
public class ConnectionChecker<V> {
	private Set<V> checked= new HashSet<>();//checked set for vertices we checked ;
	private GraphInterface<V> gf;
	
	//Initializing the class with given graph
	public ConnectionChecker(GraphInterface<V> g) {//constructor
		gf=g;
	}
	
	//check if you can go from point 1 to point 2
	public boolean check(V v1, V v2) {
		boolean flag=false;
		Collection<V> n=gf.neighbours(v1);
		if(n==null)
			return false;
		if(n.contains(v2)==true)
			return true;
		checked.add(v1);
		for(V v:n) {//for every neighbour
			if(checked.contains(v)==false) {
				if(flag=check(v,v2))
					break;
			}
		}
		return flag;
	}


}

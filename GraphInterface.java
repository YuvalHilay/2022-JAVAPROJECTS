package graph;

import java.util.Collection;

/*
Interface for graph 
*/
public interface GraphInterface<V> {
	public Collection<V> neighbours(V v); //function that return the neighbours of V v
}

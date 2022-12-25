package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
class that describe graph 
*/
public class Graph<V> {
	private Set<V> vertices=new HashSet<>();//define vertices set 
	private Map<V, Set<V>> edges =new HashMap<>();//define map for edges
	public void addVertex(V v) throws GraphException{ //fun that add Vertex to vertices
		if(vertices.contains(v))
			throw new GraphException("point was in the gragh"); 
		vertices.add(v);
	}
	public void addEdge(V v1, V v2) throws GraphException{//func add Edge to edges
		if(vertices.contains(v1)==false||vertices.contains(v2)==false)
			throw new GraphException("point was not in the gragh"); 
		if(hasEdge(v1,v2)==true)
			throw new GraphException("edge is exsits"); 
		if(edges.get(v1)==null)//if theres no edges create new set
			edges.put(v1, new HashSet<>());
		edges.get(v1).add(v2);
		if(edges.get(v2)==null)//if theres no edges create new set
			edges.put(v2, new HashSet<>());
		edges.get(v2).add(v1);
	}
	public boolean hasEdge(V v1, V v2) {//func check if there is edge between two points
		Set<V> set;
		set= edges.get(v1);
		if(set==null)
			return false;
		if(set.contains(v2))
			return true;
		return false;
		
	}
	private boolean achieveCheck(Set<V> edgeset ,V v2, Set<V> checked) {//func check recursively if we can go from v1 to v2 
		if(edgeset.contains(v2))
			return true;
		for(V ver : edgeset) {
			if(checked.contains(ver)==false) {
				checked.add(ver);//add vertex to checked
				if(achieveCheck(edges.get(ver),v2,checked)==true)//go recursive
					return true;
			}		
		}
		return false;
	}
	public boolean connected(V v1, V v2) throws GraphException{//func check if you can go from point 1 to point 2
		Set<V> checked;
		checked= new HashSet<>();//checked set for vertices we checked 
		if(vertices.contains(v1)==false)
			throw new GraphException("vertex isnt exsits");
		if(vertices.contains(v2)==false)
			throw new GraphException("vertex isnt exsits");
		if(v1.equals(v2))
			return true;
		if(edges.get(v1)==null ||edges.get(v2)==null)
			return false;
		checked.add(v1);
		return achieveCheck(edges.get(v1),v2,checked);//call achieveCheck func
	}



}

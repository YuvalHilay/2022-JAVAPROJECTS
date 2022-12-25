package graph;

import java.util.ArrayList;
import java.util.Collection;

/*
class that describe 2D maze 
*/
public class Maze implements GraphInterface<Place> {
	private int size; //size of the maze
	private char arr[][]; //array that contains the maze
	private Place start,end; //starting and ending place
	
	public Maze(int size, int startx, int starty, int endx, int endy) {//constructor
		this.size=size;
		start=new Place(startx,starty,size);//save place end and start
		end=new Place(endx,endy,size);
		arr=new char[size][size];//create the maze array with dots
		for(int i=0 ; i<size;i++) {
			for (int j=0;j<size;j++)
				arr[i][j]='.';
		}
		arr[startx][starty]='S';//put S and E in the maze
		arr[endx][endy]='E';
	}
	
	private boolean inmaze(int x) {//check if x  is in frame
		if(x<0||x>size-1)
			return false;
		return true;
	}
	
	//function that add wall to the maze
	public boolean addWall(int x, int y) {
		if(inmaze(x)==false||inmaze(y)==false)//check x and y
			throw new IllegalArgumentException();
		else if (arr[x][y]!='.' ||(x==start.getX()&&y==start.getY())||(x==end.getX()&&y==end.getY()))
				return false;//if it not dot or equal to start or end
		else
			arr[x][y]='@';//add wall
			return true;
	}
	
	@Override
	public String toString() {
		String s="";
		for(int i=0 ; i<size;i++) {//create string for maze 
			for (int j=0;j<size;j++) {
				s+=arr[i][j];
			}
			s+="\n";	
		}
		return s;
	}
	public boolean isSolvable() {//func check if can solve maze using graph
		boolean flag= false;//flag if we can solve or not
		Graph<Place> g=new Graph<>();//define new graph
		int i,j;
		for( i=0 ; i<size;i++) {//run on arr and add vertex
			for ( j=0;j<size;j++) {
				if(arr[i][j]!='@') {
					try {
						g.addVertex(new Place(i,j,size));
					} catch (GraphException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
		}
		for( i=0 ; i<size;i++) {//run on arr and add edeges using connectPlace
			for ( j=0;j<size;j++) {
				if(arr[i][j]!='@') {
					connectPlace(g,i,j);
				}
			}
		}
		try {
			flag= g.connected(start,end);//call connected on g
		} catch (GraphException e) {
			e.printStackTrace();
		}
		return flag;
	}
	private void connectPlace(Graph<Place> g, int i,int j) {//connect arr[i][j] to place above down left and right if there is
		if(inmaze(i-1)) {
			if(arr[i-1][j]!='@'&&g.hasEdge(new Place(i,j,size),new Place(i-1,j,size))==false)
				try {
					g.addEdge(new Place(i,j,size),new Place(i-1,j,size));
				} catch (GraphException e) {
					e.printStackTrace();
				}
		}
		if(inmaze(i+1)) {
			if(arr[i+1][j]!='@'&&g.hasEdge(new Place(i,j,size),new Place(i+1,j,size))==false)
				try {
					g.addEdge(new Place(i,j,size),new Place(i+1,j,size));
				} catch (GraphException e) {
					e.printStackTrace();
				}
		}
		if(inmaze(j-1)) {
			if(arr[i][j-1]!='@'&&g.hasEdge(new Place(i,j,size),new Place(i,j-1,size))==false)
				try {
					g.addEdge(new Place(i,j,size),new Place(i,j-1,size));
				} catch (GraphException e) {
					e.printStackTrace();
				}
		}
		if(inmaze(j+1)) {
			if(arr[i][j+1]!='@'&&g.hasEdge(new Place(i,j,size),new Place(i,j+1,size))==false)
				try {
					g.addEdge(new Place(i,j,size),new Place(i,j+1,size));
				} catch (GraphException e) {
					e.printStackTrace();
				}
		}
	}
	@Override
	public Collection<Place> neighbours(Place v) {//func create Collection of neighbours of v
		int i,j;
		Collection<Place> n=new ArrayList<>();// define ArrayList
		i=v.getX();//get x and y of v
		j=v.getY();
		if(inmaze(i-1)) {//add to n if relevant
			if(arr[i-1][j]!='@')
					n.add(new Place(i-1,j,size));
				
		}
		if(inmaze(i+1)) {
			if(arr[i+1][j]!='@')
					n.add(new Place(i+1,j,size));
				
		}
		if(inmaze(j-1)) {
			if(arr[i][j-1]!='@')
					n.add(new Place(i,j-1,size));
				
		}
		if(inmaze(j+1)) {
			if(arr[i][j+1]!='@')
					n.add(new Place(i,j+1,size));
				
		}
		return n;
	}

}

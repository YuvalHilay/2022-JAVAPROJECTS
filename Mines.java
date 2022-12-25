package mines;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

//class describe mines game
public class Mines
{
	//class that compare between 2 places
	private class Place implements Comparable<Place>
	{
		private int i;
		private int j;

		public Place(int i, int j) //Constructor
		{
			this.i = i;
			this.j = j;
		}
		
		@Override
		public String toString() //toString
		{
			return "(" + i + ", " + j + ")";
		}

		@Override
		public int compareTo(Place other)
		{
			return this.toString().compareTo(other.toString());
		}
	}


	private int height;//saving the height of the board
	private int width;//saving the width of the board
	private int fieldSize;//total size of board
	private int numMines;//saving the amount of mines in the board
	private boolean showAll;//flag
	private int[][] field;//board of points
	private Set<Place> flags = new TreeSet<>();
	private Set<Place> discovered = new TreeSet<>();
	
	//used for checking all places around: x+1,x-1,y+1,y-1
	private int[][] dirDxDy = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
	private Random r = new Random();

	public Mines(int height, int width, int numMines)//constructor
	{
		int i, j;
		fieldSize = height * width;
		field = new int[this.height = height][this.width = width];

		int m=0;
		while(m<numMines) //putting random mines
		{
			i = r.nextInt(height);
			j = r.nextInt(width);
			if (addMine(i, j))
				m++;
		}
	}

	// check if place represent by x y is in board
	boolean isInBounds(int x, int y)
	{
		return 0 <= x && x < height && 0 <= y && y < width;
	}

	//adding mine if its indexes are valid
	public boolean addMine(int i, int j)
	{
		// returns false if there is already a mine at (i,j)
		if (field[i][j] == -1)
			return false;

		int nx, ny;
		// adds indications that (i,j) is a mine to nearby places
		for (int k = 0; k < 8; k++)
		{
			nx = i + dirDxDy[k][0];
			ny = j + dirDxDy[k][1];

			if (isInBounds(nx, ny) && field[nx][ny] != -1)
				field[nx][ny]++;
		}

		// mark (i,j) as a mine
		field[i][j] = -1;
		numMines++;
		return true;
	}

	//function that open place on board
	public boolean open(int i, int j)
	{
		int nx, ny;
		Place checkPlace = new Place(i,j);

		//check if its already mine
		if (field[i][j] == -1)
			return false;
		
		// check if its flag or open place
		if (flags.contains(checkPlace))
			return true;

		// adding the place to the discovered
		discovered.add(checkPlace);

		// check if there are mines around
		if (field[i][j] != 0)
			return true;
		// opening places around
		else for (int k = 0; k < 8; k++)
		{
			nx = i + dirDxDy[k][0];
			ny = j + dirDxDy[k][1];

			if (isInBounds(nx, ny) && field[i][j] != -1 && !discovered.contains(new Place(nx,ny)))
				open(nx, ny);
		}
		return true;
	}

	//setting the flag on the board
	public void toggleFlag(int x, int y)
	{
		Place addFlag = new Place(x, y);
		if (flags.contains(addFlag))
			flags.remove(addFlag);
		else flags.add(addFlag);
	}

	//checking if all places that are not mine opens
	public boolean isDone()
	{
		return (fieldSize - discovered.size() == numMines);
	}

	//returning the view point
	public String get(int i, int j)
	{
		Place p = new Place(i, j);

		//checking if the place discovered
		if (!discovered.contains(p) && !showAll)
			return (flags.contains(p)) ? "F" : ".";

		if (field[i][j] == -1)
			return "X";
		
		if (field[i][j] == 0)
			return " ";
		
		return field[i][j] + "";
	}

	//setting flag of showAll to true
	public void setShowAll(boolean showAll)
	{
		this.showAll = showAll;
	}

	//returning the view on the board
	@Override
	public String toString()
	{
		StringBuilder mf = new StringBuilder();
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
				mf.append(get(i, j));
			mf.append('\n');
		}

		return mf.toString();
	}
}

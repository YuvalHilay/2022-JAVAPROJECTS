package game;

public class Board {
	protected Player[][] board;
	protected int n,m;
	public Board(int n, int m) {//constructor
		this.n=n;
		this.m=m;
		board=new Player[n][m];
	}
	protected boolean set(int i, int j, Player p) {//set player on board
		if(!(isEmpty(i,j)))
			return false;
		board[i][j]=p;
		return true;
	}
	public boolean isEmpty(int i, int j) {//check if place is empty
		if(board[i][j]==null)
			return true;
		return false;
	}
	public Player get(int i, int j) {//return player on board
		if(board[i][j]==null)
			return null;
		return board[i][j]; 
	}
	public boolean isFull() {//check if the board is full
		for(int i=0;i<n;i++) { 
			for(int j=0;j<m;j++) {
				if(isEmpty(i,j))
					return false;
			}
		}
		return true;

    }
	@Override
	public String toString() {//to string a board
		String s="";
		for(int i=0;i<n;i++) { 
			for(int j=0;j<m;j++) {
				if(isEmpty(i,j))
					s=s+".";
				else
					s=s+board[i][j].getMark();
			}
			s=s+"\n";
		}
		return s;
	}
	protected int maxLineContaining(int i, int j) {//func return max line with the same mark
		int maxlen=0;							   //using rayLength to check all options
		int dx=0;
		int dy=-1;
		int sum=0;
		sum=rayLength(i,j,dx,dy);
		dy=1;
		sum+=rayLength(i,j,dx,dy);
		if(sum>maxlen)
			maxlen=sum;
		
		dx=-1;
		dy=-1;
		sum=rayLength(i,j,dx,dy);
		dx=1;
		dy=1;
		sum+=rayLength(i,j,dx,dy);
		if(sum>maxlen)
			maxlen=sum;
		
		dx=-1;
		dy=1;
		sum=rayLength(i,j,dx,dy);
		dx=1;
		dy=-1;
		sum+=rayLength(i,j,dx,dy);
		if(sum>maxlen)
			maxlen=sum;
		
		dx=-1;
		dy=0;
		sum=rayLength(i,j,dx,dy);
		System.out.println(sum);
		dx=1;
		dy=0;
		sum+=rayLength(i,j,dx,dy);
		System.out.println(sum);
		if(sum>maxlen)
			maxlen=sum;
		return maxlen-1;	
	}
	private int rayLength(int x, int y, int dx, int dy) {//func get index and direction and return the line length
		int len=0;
		char mark1=board[x][y].getMark();
		while(inframe(x,y,n,m)&&board[x][y]!=null) {
			if(board[x][y].getMark()==mark1) {
				len++;
				x=x+dx;
				y=y+dy;
			}	
			else
				break;
		}
		return len;
	}
	private boolean inframe(int x, int y,int numrow, int numcol) {//check if place in the table
		if(x<0 || x>=numrow ||y<0 ||y>=numcol)
			return false;
		return true;
	}
}

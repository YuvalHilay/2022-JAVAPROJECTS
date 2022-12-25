package images;

public class Filter extends ImageDecorator {
	
	public Filter(Image base, RGB filter) {//constructor
		super(base,filter);
	}
	
	@Override
	public RGB get(int x, int y) {//implement the get for image interface
		
		return g.get(x,y).filter(rgb);//get RGB of the index and filter it
	}

}

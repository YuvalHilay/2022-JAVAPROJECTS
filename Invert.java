package images;

public class Invert extends ImageDecorator {

	public Invert(Image base) {//constructor
		super(base);
	}

	@Override
	public RGB get(int x, int y) {//implement the get for image interface
		return g.get(x, y).invert();//get RGB of the index and invert it
	}
	
}

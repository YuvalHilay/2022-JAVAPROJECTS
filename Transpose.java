package images;

public class Transpose extends ImageDecorator {

	public Transpose(Image base) {//constructor
		super(base);
	}

	@Override
	public int getWidth() // return the correct width of the transposed image
	{ 
		return g.getHeight();
	}
	@Override
	public int getHeight() // return the correct height of the transposed image
	{ 
		return g.getWidth(); 
	}
	@Override
	public RGB get(int x, int y) {//implement the get for image interface
		return g.get(y,x);//change x with y
	}
}

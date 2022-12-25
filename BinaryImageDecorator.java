package images;

public abstract class BinaryImageDecorator implements Image{
	private int width, height;
	public BinaryImageDecorator(int width, int height)//constructor
	{
		this.width = width;
		this.height = height;
	}
	public int getWidth() {// return width and height of image
		return width;
	}
	public int getHeight() {
		return height; 
	}
	protected abstract RGB createColor(RGB rgb1, RGB rgb2);// return new color depend on class
}

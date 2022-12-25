package images;

public abstract class ImageDecorator implements Image {
	protected Image g;
	protected RGB rgb;
	public ImageDecorator(Image g)//constructor
	{
		this.g=g;
	}
	public ImageDecorator(Image g, RGB rgb)//constructor
	{
		this.g = g;
		this.rgb = rgb;
	}
	// return the width and height of the image
	public int getWidth() //geters
	{ 
		return g.getHeight(); 
	}
	public int getHeight() 
	{
		return g.getWidth(); 
	}
}

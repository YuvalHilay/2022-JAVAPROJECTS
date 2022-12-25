package images;

public abstract class BaseImage implements Image {
	private int width,height;//variables
	protected RGB rgb1,rgb2;
	public BaseImage(int width, int height, RGB rgb1, RGB rgb2) //constructor
	{
		this.width = width;
		this.height = height;
		this.rgb1 = rgb1;
		this.rgb2 = rgb2;
	}
	// return the width and height of the image
	public int getWidth() //geters
	{ 
		return width; 
	}
	public int getHeight() 
	{
		return height; 
	}
	public boolean InImage(int x,int y)// check if index is in the image
		{
			if(x <= width && y <= height)
				return true;
			return false;
		}
	
}

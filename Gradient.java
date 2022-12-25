package images;

public class Gradient extends BaseImage {
	public Gradient(int width, int height, RGB start, RGB end)//constructor
	{
		super(width,height,start,end);
	}
	@Override
	public RGB get(int x, int y) {//implement the get for image interface
		double alpha;
		if(InImage(x,y))//check point is in image
		{
			alpha=1-((double)x/getWidth());//calc the alpha for mix
			return RGB.mix(rgb1,rgb2,alpha);
		}
		else
			return null;	
	}


}

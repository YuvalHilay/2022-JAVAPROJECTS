package images;

public class Circle extends BaseImage {
	int centerX,centerY,radius;
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {//constructor
		super(width, height, center, outside);
		this.centerX=centerX;
		this.centerY=centerY;
		this.radius=radius;
	}
	public Circle(int size, int radius, RGB center, RGB outside) {//second constructor
		super(size,size,center,outside);
		this.centerX=size/2;
		this.centerY=size/2;
		this.radius=radius;
	}
	@Override
	public RGB get(int x, int y) {//implement the get for image interface
		double alpha,len;
		if(InImage(x,y))//check point is in image
		{
			len = Math.sqrt(Math.pow(centerX - x, 2) + Math.pow(centerY - y, 2));//calc the len of the line from center to index
			if(len>radius)//check what alpha to give
				alpha=0;
			else
				alpha=(1- len / (double)radius);
			return RGB.mix(rgb1,rgb2,alpha);
		}
		else
			return null;	
	}
	

}

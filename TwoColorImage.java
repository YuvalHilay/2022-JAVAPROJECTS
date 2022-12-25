package images;

public class TwoColorImage extends BaseImage {
	private TwoDFunc func;
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {//constructor
		super(width, height, zero, one);
		this.func=func;
	}

	@Override
	public RGB get(int x, int y) {//implement the get for image interface
		double alpha;
		double calcforalpha;
		double newx=(double)x/getWidth();//normal the x and y 
		double newy=(double)y/getHeight();
		calcforalpha= 1 - func.f(newx, newy);//use func for decide color
		if(calcforalpha>1)//check if above 1 or under 0
			alpha=1;
		else if(calcforalpha<0)
			alpha=0;
		else
			alpha=calcforalpha;
		return RGB.mix(rgb1, rgb2, alpha);//return mix color with calc alpha
			
	}

}

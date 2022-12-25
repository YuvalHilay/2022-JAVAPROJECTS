package images;

public class Mix extends BinaryImageDecorator{
	private double alpha;
	private Image g1, g2;
	public Mix(Image base1, Image base2, double alpha) {//constructor
		super(Math.max(base1.getWidth(), base2.getWidth()), Math.max(base1.getHeight(), base2.getHeight()));//send the max Width and height
		this.alpha=alpha;
		this.g1=base1;
		this.g2=base2;
	}
	@Override
	public RGB get(int x, int y) {//implement the get for image interface
		if(g1.get(x,y)!=null&&g2.get(x,y)!=null)//check situation and return correct RGB
		{
			return createColor(g1.get(x,y),g2.get(x,y));
		}
		else if(g1.get(x,y)!=null||g2.get(x,y)!=null)
		{
			if(g1.get(x,y)==null)
				return g2.get(x, y);
			return g1.get(x, y);
		}
		else
			return RGB.BLACK;
	}
	@Override
	protected RGB createColor(RGB rgb1, RGB rgb2) {//create demanded color
		return RGB.mix(rgb1,rgb2,alpha);
	}
	
}

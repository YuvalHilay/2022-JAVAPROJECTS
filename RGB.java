package images;

public class RGB {
	private double red, green, blue;
	public static final RGB BLACK = new RGB(0); //given colors
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1,0,0);
	public static final RGB GREEN = new RGB(0,1,0);
	public static final RGB BLUE = new RGB(0,0,1);
	public RGB(double red, double green, double blue) {//constructor
		this.red=check(red);
		this.green=check(green);
		this.blue=check(blue);
	}
	public RGB(double grey) {//constructor get 1 argument
		red=check(grey);
		green=check(grey);
		blue=check(grey);
	}
	private static double check(double x)//func that check the color value is valid
	{
		if(x>1)
			return 1;
		else if(x<0)
			return 0;
		else 
			return x;
	}
	public double getRed() {//geters
		return red;
	}
	public double getBlue() {
		return blue;
	}
	public double getGreen() {
		return green;
	}
	public RGB invert() {//func invert the color
		return new RGB(1-red,1-green,1-blue);
	}
	public RGB filter(RGB filter) {//func filter color 
		return new RGB(red*filter.red,green*filter.green,blue*filter.blue);
	}
	public static RGB superpose(RGB rgb1, RGB rgb2) {//func create new color base 2 given 
		RGB b=new RGB(0);
		b.red=check(rgb1.red+rgb2.red);
		b.green=check(rgb1.green+rgb2.green);
		b.blue=check(rgb1.blue+rgb2.blue);
		return b;	
	}
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {//func mix 2 color to new one
		alpha=check(alpha);
		return new RGB(alpha*rgb1.red + (1-alpha)*rgb2.red,alpha*rgb1.green + (1-alpha)*rgb2.green,alpha*rgb1.blue + (1-alpha)*rgb2.blue);
	}
	@Override
	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>",red,green,blue);
	}


}

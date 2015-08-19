import java.util.Comparator;


/*
 * Critical points maintained in a map from x Coordinate to height values at that position on the x axs
 *
 */

public class CriticalPoint{

	double x;
	double height;

	public CriticalPoint(double x, double h) {
		this.x= x;
		this.height = h;
	}

	public double getHeight(){
		return this.height;

	}

	public double getX(){
		return this.x;

	}




}

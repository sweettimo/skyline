// This rectangle object represents the bounding box of the 
// tower generated based on pseudo-random input.

public class Rectangle {

	double rightX;
	double leftX;
	double height;

	public Rectangle(double lX, double rX, double h) {
		this.leftX = lX;
		this.rightX = rX;
		this.height = h;
	}

	public double getHeight() {
		return this.height;
	}

	public double getLeftX() {
		return this.leftX;
	}

	public double getRightX() {
		return this.rightX;
	}

}

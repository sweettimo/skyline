import java.util.*;


public class RectangleSorter implements Comparator<Rectangle>{



	// Overriding the compare method to sort the age
	public int compare(Rectangle c, Rectangle c1){
		if(c.leftX == c1.leftX){
			return (int)(c.height - c1.height);
		}
		else return (int)(c.leftX - c1.leftX);

	}




	public static void main(String [] args){

		//RectangleSorter sorter = new RectangleSorter();
	    List<Rectangle> points = new ArrayList<Rectangle>();


	   //TODO: remove debug code when sorter is finished
	   points.add(new Rectangle(2, 4, 3));
	   points.add(new Rectangle(1, 3, 1));
	   points.add(new Rectangle(2, 5, 2));


	   //Debug
	   for(Rectangle c: points){//printing the unsorted list of ages
		      System.out.println(c.getLeftX() +", "+ c.getRightX() + ", " + c.getHeight());
		   }


	   // Sorts the array list using comparator
	   Collections.sort(points, new RectangleSorter());

	   //Debug
	   System.out.println(" ");
	   for(Rectangle c: points){//printing the sorted list of ages
		    System.out.println(c.getLeftX() +", "+ c.getRightX() + ", " + c.getHeight());
	   }





	}








}

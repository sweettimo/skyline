import java.util.*;


public class SkylineBuilder {

	ArrayList<Rectangle> buildings;
	HashMap<Double, ArrayList<Rectangle>> critPoints;
	ArrayList<CriticalPoint> skyline;

	//Takes a sorted list of buildings(rectangles) and outputs a skyline sequence
	public SkylineBuilder(ArrayList<Rectangle> buildings, HashMap<Double, ArrayList<Rectangle>> critPoints) {

		this.buildings = buildings;
		this.critPoints = critPoints;
		this.skyline = createSkyline();
		drawSkyline();

	}

	public ArrayList<CriticalPoint> createSkyline(){

		ArrayList<CriticalPoint>sky = new ArrayList<CriticalPoint>();

		//TODO: Populate "sky" with all the critical points of the skyline

		System.out.println("Hash Map contents");

	    Iterator it = critPoints.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());


	        //iterate through all Rectangles in the list
	        for(Rectangle r: (ArrayList<Rectangle>)pair.getValue()){
	        	System.out.println("Critical point at " + pair.getKey() + ". Rectangle points: left = " + r.getLeftX() + ", right = " + r.getRightX() + ", height = " + r.getHeight());

	        }

	        it.remove(); // avoids a ConcurrentModificationException
	    }


		return sky;
	}

	public void drawSkyline(){

		//TODO: draw the skyline by connecting points in the field skyline with lines

	}

	public static void main(String[] args) {
		//RectangleSorter sorter = new RectangleSorter();
	    ArrayList<Rectangle> rects = new ArrayList<Rectangle>();


	   //TODO: remove debug code when sorter is finished
	   rects.add(new Rectangle(2, 4, 3));
	   rects.add(new Rectangle(1, 3, 1));
	   rects.add(new Rectangle(2, 5, 2));


	   //Debug
	   for(Rectangle c: rects){//printing the unsorted list of ages
		      System.out.println(c.getLeftX() +", "+ c.getRightX() + ", " + c.getHeight());
		   }


	   // Sorts the array list using comparator
	   //TODO: use merge sort here instead of Collections.sort
	   Collections.sort(rects, new RectangleSorter());

	   HashMap<Double, ArrayList<Rectangle>> critPoints = new HashMap<Double, ArrayList<Rectangle>>();
	  //ArrayList<CriticalPoint> changePoints = new ArrayList<CriticalPoint>();
	   System.out.println(" ");
	   for(Rectangle c: rects){//printing the sorted list of ages and building critical point list
		    System.out.println(c.getLeftX() +", "+ c.getRightX() + ", " + c.getHeight());

		    //break each rectangle up into two critical points
		    //CriticalPoint p = new CriticalPoint(c.getLeftX(), c.getHeight());
		   // CriticalPoint p1 = new CriticalPoint(c.getRightX(), c.getHeight());

		    //changePoints.add(p);
		    //changePoints.add(p1);

		    //check if there is already a value in the map for this x coord
		    //if so, add the rect with a critical point here to its value list
		    if(critPoints.containsKey(c.getLeftX())){
		    	critPoints.get(c.getLeftX()).add(c);

		    }

		    else if(!critPoints.containsKey(c.getLeftX())) {
            //If not, create new list and add that to the entry for this critical point position
            ArrayList<Rectangle> rectList = new ArrayList<Rectangle>();
            rectList.add(c);
            critPoints.put(c.getLeftX(), rectList);

		    }

		    if(critPoints.containsKey(c.getRightX())){
		    	critPoints.get(c.getRightX()).add(c);

		    }

		    else if(!critPoints.containsKey(c.getRightX())) {
            //If not, create new list and add that to the entry for this critical point position
            ArrayList<Rectangle> rectList = new ArrayList<Rectangle>();
            rectList.add(c);
            critPoints.put(c.getRightX(), rectList);

		    }



	   }




		// Construct a skyline builder and pass it the list of rectangles and critical points
	   SkylineBuilder sb = new SkylineBuilder(rects, critPoints);


	   }



	}



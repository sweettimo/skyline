
import java.util.*;


public class CriticalPointSorter  implements Comparator<CriticalPoint>{

	public CriticalPointSorter() {
		// TODO Auto-generated constructor stub
	}

	// Overriding the compare method to sort the age
	public int compare(CriticalPoint c, CriticalPoint c1){
		if(c.x == c1.x){
			return (int)(c.height - c1.height);
		}
		else return (int)(c.x - c1.x);

	}




	public static void main(String [] args){

		//CriticalPointSorter sorter = new CriticalPointSorter();
	    List<CriticalPoint> points = new ArrayList<CriticalPoint>();


	   //TODO: remove debug code when sorter is finished

	   points.add(new CriticalPoint(1,1));
	   points.add(new CriticalPoint(2, 2));
	   points.add(new CriticalPoint(3, 0));
	   points.add(new CriticalPoint(5, 0));
	   points.add(new CriticalPoint(2, 3));
	   points.add(new CriticalPoint(4, 0));

	   for(CriticalPoint c: points){//printing the unsorted list of ages
		      System.out.print(c.getX() +": "+ c.getHeight() + ", ");

		   }


	   // Sorts the array list using comparator
	   Collections.sort(points, new CriticalPointSorter());
	   System.out.println(" ");
	   for(CriticalPoint c: points){//printing the sorted list of ages
	      System.out.print(c.getX() +": "+ c.getHeight() + ", ");

	   }
	}


}


/*class Dog implements Comparator<Dog>, Comparable<Dog>{
private String name;
private int age;
Dog(){
}

Dog(String n, int a){
   name = n;
   age = a;
}

public String getDogName(){
   return name;
}

public int getDogAge(){
   return age;
}

// Overriding the compareTo method
public int compareTo(Dog d){
   return (this.name).compareTo(d.name);
}

// Overriding the compare method to sort the age
public int compare(Dog d, Dog d1){
   return d.age - d1.age;
}
}

public class Example{

public static void main(String args[]){
   // Takes a list o Dog objects
   List<Dog> list = new ArrayList<Dog>();

   list.add(new Dog("Shaggy",3));
   list.add(new Dog("Lacy",2));
   list.add(new Dog("Roger",10));
   list.add(new Dog("Tommy",4));
   list.add(new Dog("Tammy",1));
   Collections.sort(list);// Sorts the array list

   for(Dog a: list)//printing the sorted list of names
      System.out.print(a.getDogName() + ", ");

   // Sorts the array list using comparator
   Collections.sort(list, new Dog());
   System.out.println(" ");
   for(Dog a: list)//printing the sorted list of ages
      System.out.print(a.getDogName() +"  : "+
		 a.getDogAge() + ", ");
}
}

*/
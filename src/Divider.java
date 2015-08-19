import java.util.*;


public class Divider {

	//store the current number of computational steps
	int barometer =0;

	HashMap <Integer, ArrayList<Integer>> skyTuples = new HashMap<Integer, ArrayList<Integer>> ();


	/*
	public static void main(String [] args){

		Divider d = new Divider();

	}

	*/

	public Divider(){


		makeList();


	}

	public void makeList(){

		skyTuples = new HashMap<Integer, ArrayList<Integer>> ();

		for(int i = 0; i< 100; i++){

			ArrayList<Integer> currentTuple = new ArrayList<Integer>();
			int x1 = (int)(i*Math.random());
			int x2 = x1 + (int)(i*Math.random());
			int height = 1 + (int)(i*Math.random());
			if(x1 == 0){

				height = 0;

			}

			currentTuple.add(x1);
			currentTuple.add(x2);
			currentTuple.add(height);
			skyTuples.put(i, currentTuple);
		}

		//TODO: Convert this into the method that calls merge sort
		splitter(skyTuples);
	}




	public HashMap<Integer, ArrayList<Integer>> splitter(HashMap<Integer, ArrayList<Integer>> sky){

		if(sky.isEmpty()){
			return sky;
		}
		else{

		System.out.println(sky);

		return sky;
		}
	}

	public HashMap<Integer, ArrayList<Integer>> getList(){


		return skyTuples;
		}
	}






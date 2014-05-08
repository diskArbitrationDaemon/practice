import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.naming.spi.DirStateFactory.Result;


public class runSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] data = {5, 4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1,4, 3, 17, 1};
		
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		//String[] data = {"there", "is", "nothing", "to", "worry", "about"};
		//MergeSort<String> mergeSort = new MergeSort<String>();
		
		System.out.println("inserting");
		Random r = new Random();
		for (int i = 0; i < 100000000; i++){
			numbers.add(r.nextInt());
		}
		System.out.println("sorting");
		//ArrayList<String> result = mergeSort.sort(new ArrayList<String>(Arrays.asList(data)));
		ArrayList<Integer> result = mergeSort.sort(numbers);
		int previous = result.get(0);
		int current = result.get(1);
		for (int i = 1; i < result.size(); i++){
			assert(previous < current);
		}
		System.out.println("yay!");
		
	}

}

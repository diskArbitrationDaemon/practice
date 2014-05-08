
public class RunIncrement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Increment increment = new Increment();
		
		int[] input = {1,9,9,9,9};
		int[] result = increment.increment(input);
		
		for (int i = 0; i < result.length; i++){
			System.out.print(result[i]+ " ");
		}

	}

}

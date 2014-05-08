import java.util.Arrays;


public class Product {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {2, 3, 4,5};
		
		int[] b = product(a);
		
		for (int number : b){
			System.out.print(number + " ");
		}
	}
	
	private static int[] product(int[] a){
		int[] b = new int[a.length];
		Arrays.fill(b, 1);
		int product = 1;
		
		for (int i = 1; i < a.length; i++){
			product *= a[i - 1];
			b[i] = product;
		}
		
		product = 1;
		for (int i = a.length -2; i >=0; i--){
			product *= a[i + 1];
			b[i] *= product;
		}
		
		return b;
	}

}

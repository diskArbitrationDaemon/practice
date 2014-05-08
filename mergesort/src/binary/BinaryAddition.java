package binary;

public class BinaryAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(add(3, 5));
		System.out.println(subtract(10, 3));
	}
	
	private static int add (int a, int b){
		int sum = a ^ b;
		int carry = (a & b) << 1;
		while (carry > 0){
			int tmpSum = sum ^ carry;
			carry = (carry & sum) << 1;
			sum = tmpSum;
		}
		
		return sum;
	}
	
	// a - b
	private static int subtract(int a, int b){
		int sum = a ^ b;
		int carry = a & (b << 1);
		while (carry > 0){
			int tmpSum = sum ^ carry;
			carry = carry & (sum << 1);
			sum = tmpSum;
		}
		
		return sum;
	}


}

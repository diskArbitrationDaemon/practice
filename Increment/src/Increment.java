
public class Increment {
	
	
	public Increment(){
		
	}
	
	
	public int[] increment(int[] input){
		
		int result = 0;
		int carry = 1;
		for (int i = input.length - 1; i >= 0; i--){
			result = input[i] + carry;
			carry = result / 10;
			result = result % 10;
			
			input[i] = result;
		}
		
		if (carry != 0){
			int[] temp = new int[input.length + 1];
			
			for (int i = 0; i < input.length; i++){
				temp[i + 1] = input[i];
			}
			
			temp[0] = carry;
			input = temp;
		}
		
		return input;
		
		
		
	}

}

import java.util.ArrayList;


public class NextBiggest {
	
	public int nextBiggest(int input){
		int[] number = intToArray(input);
		
		int prevIndex = number.length - 1;
		int currIndex = prevIndex - 1;
		
		while (currIndex >= 0 && number[currIndex] > number[prevIndex]){
			currIndex--;
			prevIndex--;
		}
		
		if (currIndex < 0){
			return input;
		} else {
			swapGivenIndex(currIndex, number.length - 1, number);
			reverse(prevIndex, number.length - 1, number);
			return arrayToInt(number);
		}
		
		
	}
	
	public int[] intToArray(int number){
		ArrayList<Integer> list = new ArrayList<>();
		while (number > 0){
			int result = number % 10;
			number /= 10;
			list.add(0, result);
		}
		
		int[] result = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++){
			result[i] = list.get(i);
		}
		
		return result;
	}
	
	public void swapGivenIndex(int fromIndex, int toIndex, int[] array){
		
		assert (fromIndex >= 0 && fromIndex < array.length);
		assert (toIndex >= 0 && toIndex < array.length);
		
		int temp = array[fromIndex];
		array[fromIndex] = array[toIndex];
		array[toIndex] = temp;
	}
	
	public void reverse(int fromIndex, int toIndex, int[] array){
		for (int i = 0; i <= (toIndex - fromIndex)/2; i++){
			swapGivenIndex(fromIndex + i, toIndex - i, array);
		}
	}
	
	public int arrayToInt(int[] number){
		int result = 0;
		int multiplier = 1;
		
		for (int i = number.length - 1; i >= 0; i--){
			result += number[i] * multiplier;
			multiplier *= 10;
		}
		
		return result;
		
	}

}
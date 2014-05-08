package balances;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import balances.Balance.Direction;

public class RunBalance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			Balance root = null;
			
			Scanner in = new Scanner(new FileReader("balance.txt"));
			String line = in.nextLine(); // don't care about number of balances
			
			int numBalances = Integer.parseInt(line);
			Balance[] balances = new Balance[numBalances];
			
			for (int i = 0; i < numBalances; i++){
				balances[i] = new Balance();
			}
			
			int direction = 0;
			int currentBalanceIndex = 0; // the index of the balance currently
								  // being traversed in file
			
			while (in.hasNext()){
				
				line = in.nextLine();
				String[] sArr = line.split(" ");
				int[] numbers = convertToIntegers(sArr);
				
				Direction d = Balance.Direction.values()[direction];
				
				Balance current = balances[currentBalanceIndex];
				
				if (root == null){
					root = current;
				}
				
				if (d == Balance.Direction.Left){
					current.setLeftWeights(numbers[0]);
					for (int i = 1; i < numbers.length; i++){
						current.addBalance(Balance.Direction.Left, balances[numbers[i]]);
						
						if (root == balances[numbers[i]]){
							root = current;
						}
						
					}
				} else {
					current.setRightWeights(numbers[0]);
					for (int i = 1; i < numbers.length; i++){
						current.addBalance(Balance.Direction.Right, balances[numbers[i]]);
						
						if (root == balances[numbers[i]]){
							root = current;
						}
					}
					currentBalanceIndex++;
				}
				
				direction = direction ^ 1;
			}
			
			for (Balance b : balances){
				if (!b.hasParent()){
					b.balance();
				}
			}
			
			int i = 0;
			for (Balance b : balances){
				System.out.print(i++ + ":" + b.getAddedLeft() + " " + b.getAddedRight());
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	private static int [] convertToIntegers(String[] numbers){
		int[] retVal = new int[numbers.length];
		
		int index = 0;
		for (String s : numbers){
			retVal[index++] = Integer.parseInt(s);
		}
		return retVal;
		
	}

}

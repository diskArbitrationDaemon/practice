package balances;

import java.util.ArrayList;
import java.util.List;

public class Balance {
	
	public static int defaultMass = 10;
	
	public enum Direction {
		Left, Right
	}

	private List<Balance> left;
	private List<Balance> right;
	
	private int leftWeights;
	private int rightWeights;
	
	private int addedLeft = 0;
	private int addedRight = 0;
	
	private boolean hasParent;
	
	public Balance(){
		
		this.left = new ArrayList<Balance>();
		this.right = new ArrayList<Balance>();
		hasParent = false;
	}
	
	public void setLeftWeights(int weights){
		this.leftWeights = weights;
	}
	
	public void setRightWeights(int weights){
		this.rightWeights = weights;
	}
	
	public void setParent(){
		this.hasParent = true;
	}
	
	public boolean hasParent(){
		return this.hasParent;
	}
	
	/***
	 * Adds a Balance to either the left side or the right side
	 * of the Balance. If either parameter is null this will
	 * silently fail.
	 * @param direction Left or Right
	 * @param balance A valid balance.
	 */
	public void addBalance(Direction direction, Balance balance){
		
		if (balance == null) return;
		if (direction == null) return;
		
		if (direction == Direction.Left){
			left.add(balance);
		} else {
			right.add(balance);
		}
		balance.setParent();
	}
	
	/***
	 * 
	 * @return the mass on the Left side
	 */
	public int getLeftMass(){
		int leftMass = this.leftWeights;
		for (Balance b : left){
			leftMass += b.getMass();
		}
		
		return leftMass;
	}
	
	/***
	 * 
	 * @return The mass on the right side
	 */
	public int getRightMass(){
		int rightMass = this.rightWeights;

		for (Balance b : right){
			rightMass += b.getMass();
		}
		
		return rightMass;
	}
	
	/***
	 * 
	 * @return The total mass of the Balance
	 */
	
	public int getMass(){
		return getLeftMass() + getRightMass() + defaultMass;
	}
	
	/***
	 * adds weight to either left or right to balance
	 * the children "Balance" first and then this Balance
	 */
	public void balance(){
		for (Balance b : left){
			b.balance();
		}
		
		for (Balance b : right){
			b.balance();
		}
		
		
		int difference = getLeftMass() - getRightMass();
		
		if (difference < 0){
			leftWeights += Math.abs(difference);
			addedLeft += Math.abs(difference);
		} else {
			rightWeights += difference;
			addedRight += difference;
		}
	}
	
	public int getAddedLeft (){
		return this.addedLeft;
	}

	public int getAddedRight(){
		return this.addedRight;
	}
}

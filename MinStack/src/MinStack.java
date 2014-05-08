import java.util.Stack;


public class MinStack {
	
	private Stack<Integer> data;
	private Stack<Integer> min;
	
	public MinStack(){
		this.data = new Stack<>();
		this.min = new Stack<>();
	}
	
	public void push(int data){
		this.data.push(data);
		if (this.min.isEmpty() || min.peek() > data){
			this.min.push(data);
		}
	}
	
	public int pop(){
		
		
		int retVal = this.data.pop();
		
		if (this.min.peek() == retVal){
			this.min.pop();
		}
		
		return retVal;
	}
	
	public int min(){
		
		return this.min.peek();
	}
}

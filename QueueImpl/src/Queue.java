import java.util.Stack;


public class Queue<E> {
	
	Stack<E> stack1;
	Stack<E> stack2;
	
	public Queue(){
		this.stack1 = new Stack<E>();
		this.stack2 = new Stack<E>();
	}
	
	public void push (E e){
		stack1.push(e);
	}
	
	public E pop(){
		
		if (stack2.isEmpty()){
			while (!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		
		return stack2.pop();
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}

}

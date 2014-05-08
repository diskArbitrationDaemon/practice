
public class RunMinStack {

	public static void main(String[] args){
		
		MinStack ms = new MinStack();
		
		ms.push(3);
		assert(ms.min() == 3);
		
		ms.push(9);
		assert(ms.min() == 3);
		
		ms.push(2);
		assert(ms.min() == 2);
		
		ms.pop();
		assert(ms.min() == 3);
		
		ms.pop();
		assert(ms.min() == 3);
		
		ms.pop();
		
		System.out.println("YAY all tests passed");
	}
}

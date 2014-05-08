
public class runQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"hello", "there", "how", "are", "you", "?"};
		
		Queue<String> queue = new Queue<>();
		
		for (String s : data){
			queue.push(s);
		}
		
		while (!queue.isEmpty()){
			System.out.println(queue.pop());
		}
	}

}


public class MinSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data ={2,2,8, 2};
		
		System.out.println(minSeq(data, 8));
	}
	
	public static int minSeq(int[]data, int sum){
		int start = 0, end = 0, currentSeq = 0, seqSum = 0;
		
		while (end < data.length && seqSum < sum){
			seqSum += data[end++];
			currentSeq++;
		}
		
		if (end == data.length && seqSum < sum) return -1;
		boolean endLoop = false;
		while (!endLoop){
			
			boolean exit = false;
			while (!exit){
				
				int tmpSeqSum = seqSum - data[start];
				if (tmpSeqSum >= sum){
					currentSeq--;
					start++;
					seqSum = tmpSeqSum;
					exit = false;
				} else {
					exit = true;
				}
				
			}
			
			if (end < data.length){
				seqSum -= data[start++];
				seqSum += data[end++];
			}
			while (seqSum < sum && end < data.length){
				seqSum -= data[start++];
				seqSum += data[end++];
			}
			
			if (end >= data.length && start >= data.length - 1){
				endLoop = true;
			}
			
			
		}
		
		return currentSeq;
		
	}

}

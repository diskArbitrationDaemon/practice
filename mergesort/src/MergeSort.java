import java.util.ArrayList;


public class MergeSort<E extends Comparable<E>> {
	
	ArrayList<E> data;
	ArrayList<E> helper;
	
	public MergeSort(){
	}
	
	public ArrayList<E> sort(ArrayList<E> data){
		this.data = data;
		this.helper = new ArrayList<E>(this.data.size());
		
		for (E e : data){
			helper.add(e);
		}

		sort(0, data.size());
		
		return data;
	}
	
	private void sort(int start, int end){
		//System.out.println("start: " + start + " | end:" + end);

		int midPoint = (end + start) / 2;
		if (end - start > 1){
			sort(start, midPoint);
			sort(midPoint, end);
			merge(start, midPoint, midPoint, end);
		}
	}
	
	private void merge(int startA, int endA, int startB, int endB){
		
		int currentA = startA;
		int currentB = startB;
		int i = startA;
		while (currentA < endA && currentB < endB){
			if (data.get(currentA).compareTo(data.get(currentB)) < 0){
				helper.set(i, data.get(currentA));
				i++;
				currentA++;
			} else {
				helper.set(i, data.get(currentB));
				currentB++;
				i++;
			}
		}
		
		while (currentA < endA){
			helper.set(i, data.get(currentA));
			i++;
			currentA++;
		}
		
		copyArray(helper, data, startA, i);
		
	}
	
	private void copyArray(ArrayList<E> src, ArrayList<E> dest, int start, int length){
		for (int i = start; i < length; i++){
			dest.set(i, src.get(i));
		}
	}

}

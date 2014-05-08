package execute;

import iterator.BinarySearchTreeIterator;
import bst.BinarySearchTree;

public class runBst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] values = {10, 8, 18, 7, 9, 12, 20};
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		for (int i : values){
			tree.insert(i);
		}
		tree.inOrderTraversal();
		tree.printByLevel();
		
		BinarySearchTreeIterator<Integer> iterator = tree.iterator();
		
		while (iterator.hasNext()){
			System.out.print(iterator.next().getValue() + " ");
		}
	}

}

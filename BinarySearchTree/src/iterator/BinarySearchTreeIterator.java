package iterator;

import java.util.Iterator;

import bst.TreeNode;

public class BinarySearchTreeIterator<E extends Comparable<E>> implements Iterator<TreeNode<E>>{

	private TreeNode<E> currentNode;
	private boolean setToFirst = false;
	
	public BinarySearchTreeIterator(TreeNode<E> treeNode){
		currentNode = treeNode;
	}
	@Override
	public boolean hasNext() {
		
		boolean hasNext = false;
		
		if (currentNode == null){
			return false;
		}
		
		if (setToFirst == false){
			return true;
		}

		if (currentNode.hasRight()){
			hasNext = true;
		} else {
			TreeNode<E> current = currentNode.getParent();
			TreeNode<E> child = currentNode;
			
			boolean stop = false;
			while (!stop){
				if (current.hasRight() && current.getRight() != child){
					hasNext = true;
					stop = true;
				} else if (!current.hasParent()) {
					hasNext = false;
					stop = true;
				} else {
					child = current;
					current = current.getParent();
				}
			}
		}
		
		return hasNext;
	}

	@Override
	public TreeNode<E> next() {
		
		if (currentNode == null){
			return null;
		}
		
		if (setToFirst == false){
			setToFirst = true;
			return currentNode;
		}
		
		TreeNode<E> next = null;
		if (currentNode.hasRight()){
			next = currentNode.getRight();
			currentNode = next;
		} else {
			TreeNode<E> parent = currentNode.getParent();
			TreeNode<E> child = currentNode;
			
			boolean stop = false;
			while (!stop){
				if (parent.hasRight() && parent.getRight() != child){
					next = parent;
					this.currentNode = parent;
					stop = true;
				} else if (!parent.hasParent()) {
					next = null;
					stop = true;
				} else {
					child = parent;
					parent = parent.getParent();
				}
			}
		}
		
		return next;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	

}

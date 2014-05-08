package bst;

import iterator.BinarySearchTreeIterator;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {

	private TreeNode<E> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public BinarySearchTreeIterator<E> iterator(){
		TreeNode<E> current = root;
		
		while (current.hasLeft()){
			current = current.getLeft();
		}
		
		return new BinarySearchTreeIterator<E>(current);
	}
	
	public void insert(E value){
		
		if (root == null){
			root = new TreeNode<E>(value);
		} else {
			
			boolean exitLoop = false;
			TreeNode<E> current = root;
			
			while (!exitLoop){
				if (value.compareTo(current.getValue()) < 0){
					if (current.hasLeft()){
						current = current.getLeft();
					} else {
						TreeNode<E> node = new TreeNode<E>(value);
						current.setLeft(node);
						node.setParent(current);
						exitLoop = true;
					}
				} else {
					if (current.hasRight()){
						current = current.getRight();
					} else {
						TreeNode<E> node = new TreeNode<E>(value);
						current.setRight(node);
						node.setParent(current);
						exitLoop = true;
					}
				}
				
			}
		}
	}
	
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(TreeNode<E> n){
		if (n.hasLeft()) inOrderTraversal(n.getLeft());
		System.out.println(n.getValue());
		if (n.hasRight()) inOrderTraversal(n.getRight());
	}
	
	public void printByLevel(){
		ArrayList<ArrayList<E>> treeData = new ArrayList<ArrayList<E>>();
		printByLevel(root, 0, treeData);
		
		int level = 0;
		for (ArrayList<E> list : treeData){
			System.out.print(level++ + ": " );
			for (E element : list){
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
	
	private void printByLevel(TreeNode<E> node, int level, ArrayList<ArrayList<E>> treeData){
		if (treeData.size() < level + 1){
			treeData.add(new ArrayList<E>());
		}
		
		ArrayList<E> list = treeData.get(level);
		list.add(node.getValue());
		if (node.hasLeft()) printByLevel(node.getLeft(), level + 1, treeData);
		if (node.hasRight()) printByLevel(node.getRight(), level + 1, treeData);
		
	}
	
	

}

package bst;

public class TreeNode<E extends Comparable<E>>{

	private E data;
	private TreeNode<E> left;
	private TreeNode<E> right;
	private TreeNode<E> parent;
	
	public TreeNode(E data){
		this.data = data;
	}
	
	public E getValue(){
		return this.data;
	}
	
	public void setParent(TreeNode<E> node){
		this.parent = node;
	}
	
	public TreeNode<E> getParent(){
		return this.parent;
	}
	
	public boolean hasParent(){
		return (parent != null);
	}
	
	public boolean hasLeft (){
		return (left != null);
	}
	
	public boolean hasRight(){
		return (right != null);
	}
	
	public void setLeft(TreeNode<E> data){
		this.left = data;
	}
	
	public void setRight(TreeNode<E> data){
		this.right = data;
	}
	
	public TreeNode<E> getLeft(){
		return this.left;
	}
	
	public TreeNode<E> getRight(){
		return this.right;
	}
	

}

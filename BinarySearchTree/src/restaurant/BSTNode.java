package restaurant;

public class BSTNode<E> {
	E data;
	BSTNode<E> left;
	BSTNode<E> right;
	
	public BSTNode(E data, BSTNode<E> left, BSTNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BSTNode<E> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}

	public BSTNode<E> getRight() {
		return right;
	}

	public void setRight(BSTNode<E> right) {
		this.right = right;
	}

	
}

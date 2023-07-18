package project;

public class LinkStack<E> {
	private Node<E> top;
	private int manyNodes;
	
	public LinkStack() {
		top = null;
	    manyNodes = 0;
	}

	public void push (E e) {
		top = new Node<E>( e, top); 
		manyNodes++; 
	}
	
	public E pop() {
		E element = top.getData();
		top = top.getLink();
		manyNodes--; 
		return element;
	}
	
	public E peek() {
		if(isEmpty()) {
			System.out.println("Is empty!");
		}
		return top.getData();
	}
	
	public boolean isEmpty() {
		if(top == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}

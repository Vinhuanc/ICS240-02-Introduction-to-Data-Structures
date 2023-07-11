package project;

public class LinkStack<E> {
	private Node<E> top;
	
	public LinkStack() {
		top = null;
	//	int manyNodes = 0; //unsure if this is needed
	}

	public void push (E e) {
		//Node<E> newNode = new Node<E>(e);
//		newNode.setNext(top);
//		top = newNode;
		top = new Node<E>( e, top); //unsure if this is the right way
		//manyNodes++; //unsure if this is needed
	}
	
	public E pop() {
		E element = top.getData();
		top = top.getLink();
		//manyNodes--; //unsure if this is needed
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

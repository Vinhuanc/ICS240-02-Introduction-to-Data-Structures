package project;

public class LinkQueue<E> {
	private Node<E> head;
	private Node<E> tail;
	private int manyNodes;
	
	public LinkQueue() {}
	
	public void enqueue(E e) {
		if(manyNodes == 0) {
			head = new Node<E>(e, null);
			tail = head;
		} else {
			tail.setLink(head);
			tail = tail.getLink();
		}
		manyNodes++;
	}
	
	public E dequeue() {
		E element = head.getData();
		head = head.getLink();
		manyNodes--;
		if(manyNodes == 0) {
			tail = null;
		}
		return element;
	}
	
	public E peek() {
		if(isEmpty()) {
			System.out.println("Is empty!");
		}
		return head.getData();
	}
	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		} else {
			return false;
		}
	}
}

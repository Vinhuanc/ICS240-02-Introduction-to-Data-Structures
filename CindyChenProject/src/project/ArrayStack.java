package project;

public class ArrayStack<E> {
	private Object[] data;
	private int top;
	
	public ArrayStack(int num) {
		data = new Object[num];
		top = 0;
	}

	public void push (E e) {
		data[top++] = e;
	}
	
	public E pop() {
		if(isEmpty()) {
			System.out.println("Is empty!");
		}
		return (E) data[--top];
	}
	
	public E peek() {
		if(isEmpty()) {
			System.out.println("Is empty!");
		}
		return (E) data[top];
	}
	
	public boolean isEmpty() {
		if(data == null) {
			return true;
		} else {
			return false;
		}
	}
}

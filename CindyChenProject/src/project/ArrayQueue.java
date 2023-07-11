package project;

public class ArrayQueue<E> {
	private Object[] data;
	private int head;
	private int manyItems;
	
	public ArrayQueue(int num) {
		data = new Object[num];
		manyItems = 0;
	}

	public void enqueue(E e) {
		data[(head+manyItems) % data.length] = e;
		manyItems++;
	}
	
	public E dequeue() {
		E temp = (E) data[head];
		head = (head + 1) % data.length;
		manyItems--;
		return temp;
	}
	
	public E peek() {
		if(isEmpty()) {
			System.out.println("Is empty!");
		}
		return (E) data[head];
	}
	
	public boolean isEmpty() {
		if(data == null) {
			return true;
		} else {
			return false;
		}
	}
}

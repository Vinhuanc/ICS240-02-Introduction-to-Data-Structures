package MapsHeapsWeek;

public class PriorityQueue<E extends Comparable> {
	private Heap<E> heap;
	
	public PriorityQueue(Heap<E> heap) {
		this.heap = heap;
	}

	public void add(E e) {
		heap.insert(e);
	}
	
	public E poll() {
		return heap.remove();
	}
	
	public E peek() {
		return heap.peek();
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
}

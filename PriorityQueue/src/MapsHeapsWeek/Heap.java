package MapsHeapsWeek;

import java.util.NoSuchElementException;

public class Heap<E extends Comparable>{
	private Object[] data;
	private int manyItems;
	
	public Heap(int manyItems) {
		data = new Object[manyItems];
		manyItems = 0;
	}
	
	public void insert(E e) {
		data[manyItems++] = e;
		
	}
	
	public E remove() {
		Object output = data[0];
		data[0] = data[manyItems - 1];
		manyItems--;
		heapifyDown(0);
		return (E) output;
	}
	
	public E peek() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return (E) data[1];
		}
	}
	
	public boolean isEmpty() {
		boolean status = false;
		if(data.length == 0) {
			status = true;
		}
		
		for(Object o: data) {
			if(o != null) {
				status = false;
			}
		}
		return status;
		
	}
	
	private void heapifyUp(int index) {
		int parentIndex = parent(index);
		if(index > 0 && ((Comparable) data[index]).compareTo(data[parentIndex]) > 0) {
			swap(index, parentIndex);
			heapifyUp(parentIndex);
		}
	}
	
	private void swap(int index1, int index2) {
		Object temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	private void heapifyDown(int index) {
		int largest = index;
		int left = left(index);
		int right = right(index);
		
		if(left < manyItems && ((Comparable) data[left]).compareTo(data[largest]) > 0) {
			largest = left;
		}
		
		if(right < manyItems && ((Comparable) data[right]).compareTo(data[largest]) > 0) {
			largest = right;
		}
		
		if(largest != index) {
			swap(largest, index);
			heapifyDown(largest);
		}
	}
	
	private int left(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	private int right(int parentIndex) {
		return 2 * parentIndex +2;
	}
	
	private int parent(int childIndex) {
		return (childIndex -1) /2 ;
	}
}

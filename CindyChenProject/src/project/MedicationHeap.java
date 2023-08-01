package project;

public class MedicationHeap {
	Medication[] heap;
	int numItems;
	
	public MedicationHeap(int numItems) {
		heap = new Medication[numItems];
		 numItems = 0;
	}
	
	public Medication poll() {
		Medication output = heap[0];
		heap[0] = heap[numItems - 1];
		numItems--;
		heapifyDown(0);
		return output;
	}
		
	private void heapifyDown(int parent) {
		int largest = parent;
		int left = left(parent);
		int right = right(parent);
		
		if(left < numItems && heap[left].compareTo(heap[largest]) > 0) {
			largest = left;
		}
		
		if(right < numItems && heap[right].compareTo(heap[largest]) > 0) {
			largest = right;
		}
		
		if(largest != parent) {
			swap(largest, parent);
			heapifyDown(largest);
		}
	}

	private void swap(int index1, int index2) {
		Medication temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	public void insert(Medication element) {
		heap[numItems++] = element;
		heapifyUp(numItems - 1);
	}
	
	private void heapifyUp(int index) {
		int parentIndex = parent(index);
		if(index > 0 && heap[index].compareTo(heap[parentIndex]) > 0) {
			swap(index, parentIndex);
			heapifyUp(parentIndex);
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

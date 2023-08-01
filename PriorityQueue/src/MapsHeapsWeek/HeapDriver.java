package MapsHeapsWeek;

public class HeapDriver {

	public static void main(String[] args) {
		Heap<String> heap = new Heap(10);
		heap.insert("Hello");
		heap.insert("World");
		heap.insert("Tuesday");

		
		
		
		PriorityQueue queue = new PriorityQueue(heap);
	queue.add("Wednesday");
queue.poll();
System.out.println(queue.peek());	
System.out.println(queue.isEmpty());



	}

}

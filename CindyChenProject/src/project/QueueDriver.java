package project;

public class QueueDriver {

	public QueueDriver() {}

	public static void main(String[] args) {
		ArrayQueue<Integer> numbers = new ArrayQueue<>(5);
		numbers.enqueue(34);
		numbers.enqueue(56);
		numbers.dequeue();
		System.out.println(numbers.peek());
		System.out.println(numbers.isEmpty());
		
		LinkQueue<String> messages = new LinkQueue<>();
		messages.enqueue("Hello");
		messages.enqueue("World");
		messages.dequeue();
		System.out.println(messages.peek());
		System.out.println(messages.isEmpty());
	}

}

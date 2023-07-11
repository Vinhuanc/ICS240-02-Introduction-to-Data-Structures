package project;

public class StackDriver {

	public StackDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ArrayStack<Integer> numbers = new ArrayStack<Integer>(5);
		numbers.push(1);
		numbers.push(2);
		numbers.pop();
		System.out.println(numbers.peek());
		System.out.println(numbers.isEmpty());
		
		LinkStack<String> messages = new LinkStack<String>();
		messages.push("Hello");
		messages.push("World");
		messages.pop();
		System.out.println(messages.peek());
		System.out.println(messages.isEmpty());

	}

}

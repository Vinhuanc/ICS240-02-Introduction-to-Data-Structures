package project;

public class Node<E> {
	Node<E> link;
	E data;
	
	public Node(E med, Node<E> objectBehind) {
		data = med;
		link = objectBehind;
	}

	public Node<E> getLink() {
		return link;
	}

	public void setLink(Node<E> link) {
		this.link = link;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	
}

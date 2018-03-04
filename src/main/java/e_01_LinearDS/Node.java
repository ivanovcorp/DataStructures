package e_01_LinearDS;

public class Node<T> {
	
	private T value;
	private Node<T> node ;
	
	public Node(T value) {
		this.setValue(value);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public void setNext(Node<T> node) {
		this.node = node;
	}
	
	public Node<T> getNext() {
		return this.node;
	}
}

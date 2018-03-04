package e_01_LinearDS;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

	
	private Node<T> head;
	private Node<T> tail;
    private int size;
    
    public LinkedList() {
    	this.head = null;
    	this.tail = null;
    	this.size = 0;
    }
    
    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(T item) {
    	Node node = new Node<T>(item);
    	if (this.size == 0) {
    		this.head = node;
    		this.tail = node;
    	} else {
    		node.setNext(this.head);
    		this.head = node;
    	}
    	this.size++;
    }

    public void addLast(T item) {
        Node<T> node = new Node(item);
        if (this.size == 0) {
    		this.head = node;
    		this.tail = node;
    	} else {
    		this.tail.setNext(node);
    		this.tail = node;
    	}
    	this.size++;
    }

    public T removeFirst() {
    	if (this.size == 0)
    		throw new UnsupportedOperationException();
    	
    	T elem = this.head.getValue();
    	if (this.size == 1) {
    		this.head = null;
    		this.tail = null;
    	} else {    		
    		this.head = this.head.getNext();     		    		
    	}
    	this.size--;
    	return elem;
    }

    public T removeLast() {
    	if (this.size == 0)
    		throw new UnsupportedOperationException();
    	
    	T elem = this.tail.getValue();
    	if (this.size == 1) {
    		this.head = null;
    		this.tail = null;
    	} else {    		
    		Node parent = this.head;
    		while (parent.getNext() != this.tail) {
    			parent = parent.getNext();
    		}
    		this.tail = parent;
    	}
    	this.size--;
    	return elem;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

    	private Node<T> start;
    	
    	public ListIterator() {
			this.start = head;
		}
    	
		@Override
		public boolean hasNext() {
			if (start != null) {
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			T elem = this.start.getValue();
			if(hasNext()) {
				this.start = this.start.getNext();
			}
			return elem;
		}
    	
    }
}

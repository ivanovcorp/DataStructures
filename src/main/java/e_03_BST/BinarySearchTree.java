package e_03_BST;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    
	private Node root;	

    public BinarySearchTree() {	
    	this.root = null;
    }
    
    public BinarySearchTree(Node node) {	
    	this.root = node;
    }

    public Node getRoot() {
        return this.root;
    }
        
    public void insert(T value) {
        if (this.root == null) {
        	this.root = new Node(value);
        	return;
        }
        
        Node parent = null;
        Node current = this.root;
        while (current != null) {
        	int result = current.getValue().compareTo(value);	
        	if (result > 0) {
        		parent = current;
        		current = current.left;
        	} else if (result < 0) {
        		parent = current;
        		current = current.right;
        	}
        	else {
        		return;
        	}
        }
        
        Node newNode = new Node(value);
        if (parent.getValue().compareTo(value) > 0) {
        	parent.left = newNode;
        } else {
        	parent.right = newNode;
        }
    }

    public boolean contains(T value) {
        
    	Node current = this.root;
    	while (current != null) {
    		int compare = current.value.compareTo(value);
    		if (compare > 0) {
    			current = current.left;
    		} else if (compare < 0) {
    			current = current.right;
    		} else {
    			return true;
    		}
    		
    	}
    	
    	return false;
    }

    public BinarySearchTree<T> search(T item) {
    	Node current = this.root;
        if (current == null) {
        	return null;
        }
        
        while (current != null) {
        	int compare = current.getValue().compareTo(item);
        	if (compare > 0) {
            	current = current.left;
            } else if (compare < 0) {
            	current = current.right;
            } else {            	
            	return new BinarySearchTree<>(current);
            }
        }
        return null;	
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(root, consumer);
    }

    private void eachInOrder(Node node, Consumer<T> consumer) {
    	if (node == null) {
    		return;
    	}
    	
    	this.eachInOrder(node.left, consumer);
    	consumer.accept(node.value);
    	this.eachInOrder(node.right, consumer);
    }
    
    public Iterable<T> range(T from, T to) {
        List<T> result = new ArrayList<>();
        this.range(this.root, result, from, to);
        return result;
    }

    private void range(Node node, List<T> result, T from, T to) {
		if (node == null) 
			return;
		
		int compareLow = node.value.compareTo(from);
		int compareHight = node.value.compareTo(to);
		if (compareLow > 0) {
			this.range(node.left, result, from, to);
		}
		
		if (compareLow >= 0 && compareHight <= 0) {
			result.add(node.value);
		}
		
		if (compareHight < 0) {
			this.range(node.right, result, from, to);
		}
	}

	class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}


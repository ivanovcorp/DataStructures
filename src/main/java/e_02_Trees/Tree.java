	package e_02_Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Tree<T> {
	
	private T value;
	private List<Tree<T>> children;

    public Tree(T value, Tree<T>... children) {
    	this.value = value;
    	this.children = new ArrayList<>();
    	for (Tree<T> child : children) {
    		this.children.add(child);
    	}
    }

    // append output to builder
    public String print(int indent, StringBuilder builder) {
    	String repeated = new String(new char[indent]).replace("\0", " ");
    	builder.append(repeated);
        builder.append(this.value);
        builder.append("\n");
        for (Tree<T> child : this.children) {        	
        	child.print(indent + 2, builder);        	
        }
        return builder.toString();
    }

    public void each(Consumer<T> consumer) {
        consumer.accept(value);
        for (Tree<T> child : this.children) {
        	child.each(consumer);
        }
    }

    public Iterable<T> orderDFS() {
        List<T> result = new ArrayList<>();
        this.DFS(this, result);
        
        return result;
    }

    private void DFS(Tree<T> node, List<T> result) {
    	for (Tree<T> child : node.children) {
    		node.DFS(child, result);
    	}
    	result.add(node.value);
    }
    
    public Iterable<T> orderBFS() {        
        ArrayDeque<Tree<T>> queue = new ArrayDeque<>();
        List<T> result = new ArrayList<>();
        queue.addLast(this);
        while (queue.size() > 0) {
        	Tree<T> current = queue.pollFirst();
        	result.add(current.value);
        	
        	for (Tree<T> child : current.children) {
        		queue.addLast(child);
        	}
        }
        return result;
    }

}
package e_02_Trees;

import java.util.function.Consumer;

public class BinaryTree<T> {

	private T value;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	public BinaryTree(T value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	public BinaryTree(T value, BinaryTree<T> child) {
		this.value = value;
		this.leftChild = child;
		this.rightChild = null;
	}

	public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightCHild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightCHild;
	}

	// append output to builder
	public String printIndentedPreOrder(int indent, StringBuilder builder) {

		this.printIndentedPreOrder(this, indent, builder);

		return builder.toString();
	}

	public StringBuilder printIndentedPreOrder(BinaryTree<T> node, int indent, StringBuilder builder) {
		if (node == null) {
			return builder;
		}
		String repeated = new String(new char[indent]).replace("\0", " ");
		builder.append(repeated);
		builder.append(node.value);
		builder.append("\n");
		this.printIndentedPreOrder(node.leftChild, indent + 2, builder);
		this.printIndentedPreOrder(node.rightChild, indent + 2, builder);
		return builder;
	}

	public void eachInOrder(Consumer<T> consumer) {
		this.eachInOrder(this, consumer);
	}

	private void eachInOrder(BinaryTree<T> node, Consumer<T> consumer) {
		if (node == null) {
			return;
		}
		if (node.leftChild != null) {
			eachInOrder(node.leftChild, consumer);
		}
		consumer.accept(node.value);
		if (node.rightChild != null) {
			eachInOrder(node.rightChild, consumer);
		}

	}

	public void eachPostOrder(Consumer<T> consumer) {
		this.eachPostOrder(this, consumer);
	}

	private void eachPostOrder(BinaryTree<T> node, Consumer<T> consumer) {
		if (node == null)
			return;
		if (node.leftChild != null) {
			eachPostOrder(node.leftChild, consumer);
		}
		if (node.rightChild != null) {
			eachPostOrder(node.rightChild, consumer);
		}
		consumer.accept(node.value);
		
	}
}

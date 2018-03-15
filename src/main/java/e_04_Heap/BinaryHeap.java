package e_04_Heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {

    private List<T> heap;

    public BinaryHeap() {
        this.heap = new ArrayList<T>();
    }

    public int size() {
        return this.heap.size();
    }

    public void insert(T element) {
        this.heap.add(element);
        this.heapifyUp(element, this.heap.size() - 1);
    }

    private void heapifyUp(T element, int index)
    {
        int parentIndex = (index - 1) / 2;
        int compare = this.heap.get(parentIndex).compareTo(element);

        if (compare < 0)
        {
            this.swap(parentIndex, index);
            this.heapifyUp(element, parentIndex);
        }

    }

    private void swap(int parentIndex, int index)
    {
        T temp = this.heap.get(parentIndex);
        this.heap.set(parentIndex, this.heap.get(index));
        this.heap.set(index, temp);

    }

    public T peek() {
        return this.heap.get(0);
    }

    public T pull() {
        if (this.size() == 0) {
            throw new IllegalArgumentException();
        }
        T elem = this.heap.get(0);
        this.heap.set(0, null);
        this.reorder();
        return elem;
    }

    private void reorder()
    {
        while (this.heap.remove(null)) {}
    }
}

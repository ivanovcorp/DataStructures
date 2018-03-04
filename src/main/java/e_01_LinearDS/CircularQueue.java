package e_01_LinearDS;

public class CircularQueue<T> {

	private static final int INITIAL_CAPACITY = 4;
	
	
    private int capacity;
    
    private T[] queue;
    private int elementCount;
    private int headIndex;

    public CircularQueue() {
    	this.headIndex = 0;
    	this.setCapacity(INITIAL_CAPACITY);
    	this.queue = (T[]) new Object[this.size()];
    }

    public CircularQueue(int initialCapacity) {
        this.setCapacity(initialCapacity);
        this.headIndex = 0;
        this.queue = (T[]) new Object[this.size()];
    }

    public int size() {
        return this.capacity;
    }

    private  void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(T element) {
        if (elementCount >= this.capacity) {
        	this.resize();            	
        }        
        int index;        
        index = (this.headIndex + this.elementCount) % this.capacity;
        this.queue[index] = element;
        this.elementCount++;
    }

    private void resize() {
		T[] newArr = (T[]) new Object[this.capacity * 2];
		for (int i = 0; i < this.capacity; i++) {
			newArr[i] = this.queue[(this.headIndex + i) % this.capacity];
		}
		this.queue = newArr;
		this.capacity = this.queue.length;
	}

	public T dequeue() {
		if (this.elementCount == 0) {
			throw new IllegalArgumentException();
		}
        T elem = this.queue[this.headIndex];
        this.queue[this.headIndex] = null;
        this.headIndex++;
        this.elementCount--;
        return elem;
    }

    public T[] toArray() {
        if (this.getElementsCount() == 0) {
        	throw new IllegalArgumentException();
        }
        T[] newArr = (T[]) new Object[this.elementCount];
		for (int i = 0; i < this.capacity; i++) {
			newArr[i] = this.queue[(this.headIndex + i) % this.capacity];
		}
		return newArr;
    }

	public int getElementsCount() {
		// TODO Auto-generated method stub
		return this.elementCount;
	}

}

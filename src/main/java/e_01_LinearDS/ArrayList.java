package e_01_LinearDS;

public class ArrayList<T>{

    private static final int INITIAL_CAPACITY = 2;

    private T[] array;
    private int capacity;
    private int index;
    private int elementsCount;


	@SuppressWarnings("unchecked")
    public ArrayList(int capacity){
		this.array = (T[])new Object[capacity];
		this.index = 0;
		this.capacity = capacity;
		this.elementsCount = 0;
	}

	@SuppressWarnings("unchecked")
    public ArrayList(){
	    this.array = (T[])new Object[INITIAL_CAPACITY];
	    this.index = 0;
        this.capacity = INITIAL_CAPACITY;
        this.elementsCount = 0;
	}


	public int getCount() {
		return this.elementsCount;
	}


	public T get(int index) {
		return this.array[index];
	}


	public void add(T element) {
	    if (this.index >= this.array.length) {
	        this.resize();
	    }
	    this.array[this.index] = element;
	    this.elementsCount++;
	    this.index++;
	}

	public T removeAt(int index) {
		try {
		    T res = this.array[index];
	        this.array[index] = null;
	        this.elementsCount--;
	        this.shrink();
	        return res;
		} catch (ArrayIndexOutOfBoundsException e) {
		    throw new IllegalArgumentException();
		}
	}


	public void shrink() {
	    T[] elems = this.array;
	    this.array = (T[])new Object[this.getCount()];
	    int myarrIndex = 0;
	    for (int i = 0; i < elems.length; i++) {
	        if (elems[i] != null) {
	            this.array[myarrIndex] = elems[i];
	            myarrIndex++;
	        }
	    }
	}

	public void set(int i, T item) {
	    try {
	        this.array[i] = item;
	    } catch (ArrayIndexOutOfBoundsException e) {
	        throw new IllegalArgumentException();
	    }
	}

	@SuppressWarnings("unchecked")
    public void resize()
	{
	    T[] elems = this.array;
	    int len = this.array.length;
	    this.array = (T[]) new Object[len * 2];
	    for (int i = 0; i < elems.length; i++) {
	        this.array[i] = elems[i];
	    }
	}

}

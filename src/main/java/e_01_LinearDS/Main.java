package e_01_LinearDS;

import junit.framework.Assert;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        /*ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < 100; i ++) {
            nums.add(i);
        }

        for (int i = 0; i < 50; i ++) {
            nums.removeAt(i);
        }

        for (int i = 0; i < nums.getCount(); i++) {
            System.out.println(nums.get(i));
        }*/

        /*ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.removeAt(0);
        System.out.println();*/
    	
    	/*Node<Integer> node1 = new Node<Integer>(5);
    	Node<Integer> node2 = new Node<Integer>(10);
    	node1.setNext(node2);
    	System.out.println(node1.getNext().getValue());*/

    	System.out.println((0 + 0) % 1);
    	
    	CircularQueue<Integer> numsQueue = new CircularQueue<>();
    	System.out.println(numsQueue.size());
    	numsQueue.enqueue(3);
    	numsQueue.enqueue(78);
    	numsQueue.enqueue(5);
    	System.out.println();
    	/*int count = 4;
    	for (int i = 0; i < 5; i++) {
    		System.out.println((2 + i) % 5);
    	}*/
    	
    	
    	int elementsCount = 32;
        int initialCapacity = 1;

        CircularQueue<Integer> queue = new CircularQueue<>(initialCapacity);
        for (int i = 0; i < elementsCount; i++) {
            queue.enqueue(i);
        }

   
        Object[] arr = queue.toArray();
        for (Object i : arr) {
        	System.out.println(i);
        }
        Assert.assertEquals(elementsCount, queue.size());
    }
}

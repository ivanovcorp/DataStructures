package e_01_LinearDS;

import org.junit.Assert;
import org.junit.Test;

public class CircularQueueTests {

    @Test
    public void enqueue_emptyQueue_shouldAddElement() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(5);

        int expectedSize = 1;
        Assert.assertEquals(expectedSize, queue.getElementsCount());
    }

    @Test
    public void enqueueDeque_shouldWorkCorrectly() {
        CircularQueue<String> queue = new CircularQueue<>();
        String element = "some value";

        queue.enqueue(element);
        String elementFromQueue = queue.dequeue();

        int expectedSize = 0;
        Assert.assertEquals(expectedSize, queue.getElementsCount());
        Assert.assertEquals(element, elementFromQueue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dequeue_emptyQueue_throwsException() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.dequeue();
    }

    @Test
    public void enqueueDequeue100Elements_shouldWorkCorrectly() {
        CircularQueue<Integer> queue = new CircularQueue<>();
        int numberOfElements = 100;

        for (int i = 0; i < numberOfElements; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < numberOfElements; i++) {
            int expectedSize = numberOfElements - i;

            Assert.assertEquals(expectedSize, queue.getElementsCount());
            int element = queue.dequeue();
            Assert.assertEquals(i, element);

            expectedSize = numberOfElements - i - 1;
            Assert.assertEquals(expectedSize, queue.getElementsCount());
        }
    }

   
    @Test
    public void initialCapacity1_enqueueDequeue20Elements_shouldWorkCorrectly() {
        int elementsCount = 32;
        int initialCapacity = 1;

        CircularQueue<Integer> queue = new CircularQueue<>(initialCapacity);
        for (int i = 0; i < elementsCount; i++) {
            queue.enqueue(i);
        }

        Assert.assertEquals(elementsCount, queue.getElementsCount());
        for (int i = 0; i < elementsCount; i++) {
            int elementFromQueue = queue.dequeue();
            Assert.assertEquals(i, elementFromQueue);
        }

        Assert.assertEquals(0, queue.getElementsCount());
    }

}

package e_04_Heap;

public class Heap {

    public static <E extends Comparable<E>> void sort(E[] array) {
        constructHeap(array);
        heapSort(array);
    }

    private static <E extends Comparable<E>> void constructHeap(E[] array) {

        for (int i = array.length / 2; i >= 0; i--) {
            heapifyDown(array, i, array.length);
        }

    }

    private static <E extends Comparable<E>> void heapSort(E[] array)
    {
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapifyDown(array, 0, i);
        }

    }

    private static <E extends Comparable<E>> void heapifyDown(E[] arr, int index, int lenght) {
        int parentIndex = index;

        while (parentIndex < lenght / 2) {
            int childIndex = (parentIndex * 2) + 1;

            if (childIndex + 1 < lenght && isGreater(arr, childIndex, childIndex + 1)) {
                childIndex += 1;
            }

            int compare = arr[parentIndex].compareTo(arr[childIndex]);
            if (compare < 0) {
                swap(arr, childIndex, parentIndex);
            }
            parentIndex = childIndex;
        }
    }

    private static <E extends Comparable<E>> boolean isGreater(E[] arr, int left, int right) {
        return arr[left].compareTo(arr[right]) < 0;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int parent, int index) {
        E temp = arr[parent];
        arr[parent] = arr[index];
        arr[index] = temp;
    }
}

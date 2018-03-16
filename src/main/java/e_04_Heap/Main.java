package e_04_Heap;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 8, 4, 12, 34, 2, 5};
        Heap.sort(arr);
        //Arrays.asList(arr).stream().forEach(x -> System.out.println(x + " "));
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

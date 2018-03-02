import arrayList.ArrayList;

public class Main {
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

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.removeAt(0);
        System.out.println();
    }
}

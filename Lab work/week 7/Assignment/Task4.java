import java.util.Collections;
import java.util.PriorityQueue;

public class Task4 {
    //tester
    public static void main(String[] args) {
        int[] nums = {4, 10, 2, 8, 6, 7};
        int k = 3;

        int[] desc = desc(nums, k);

        System.out.print("[");
        for(int i = 0; i < desc.length; i++) {
            System.out.print(desc[i]);
            if(i < desc.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //func
    private static int[] desc(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++) {
            maxheap.add(nums[i]);
        }

        int[] desc = new int[k];
        for(int i = 0; i < k; i++) {
            desc[i] = maxheap.poll();
        }

        return  desc;
    }
}

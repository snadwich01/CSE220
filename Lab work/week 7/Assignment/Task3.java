
import java.util.PriorityQueue;


public class Task3{

    //tester
    public static void main(String[] args) {
        int[] tasks = {2, 4, 7, 1, 6};
        int m = 4;

        int[] load = sched(tasks, m);

        System.out.print("[");
        for(int i = 0; i < load.length; i++) {
            System.out.print(load[i]);
            if(i < load.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //func
    public static int[] sched(int[] tasks, int m) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int i = 0; i < m; i++) {
            minheap.add(0);
        }

        for(int i = 0; i < tasks.length; i++) {
            int task = tasks[i];

            int head = minheap.poll();
            int update = task + head;

            minheap.add(update);
        }

        //type diff
        int[] res = new int[m];
        for(int i = 0; i < m; i++){
            res[i] = minheap.poll();
        }

        return res;
    }
}

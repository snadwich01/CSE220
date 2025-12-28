public class Task3 {

    public static void main(String[] args) {
        int[] tasks = {2, 4, 7, 1, 6};
        int m = 4;

        int[] load = sched(tasks, m);

        System.out.print("[");
        for (int i = 0; i < load.length; i++) {
            System.out.print(load[i]);
            if (i < load.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] sched(int[] tasks, int m) {
        MinHeap MinHeap = new MinHeap(m);

        for (int i = 0; i < m; i++) {
            MinHeap.insert(0);
        }

        for (int i = 0; i < tasks.length; i++) {
            int task = tasks[i];

            int head = MinHeap.extractMin();
            int update = head + task;

            MinHeap.insert(update);
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = MinHeap.extractMin();
        }

        return res;
    }

    static class MinHeap {

        private int[] heap;
        private int size;

        public MinHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        public void insert(int value) {
            if (size == heap.length) {
                return;
            }

            heap[size] = value;
            swim(size);
            size++;
        }

        public void swim(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;

                if (heap[index] >= heap[parent]) {
                    return;
                }

                swap(index, parent);
                index = parent;
            }
        }

        public int extractMin() {
            if (size == 0) {
                return -1;
            }

            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            sink(0);

            return min;
        }

        public void sink(int index) {
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int smallest = index;

                if (left < size && heap[left] < heap[smallest]) {
                    smallest = left;
                }

                if (right < size && heap[right] < heap[smallest]) {
                    smallest = right;
                }

                if (smallest == index) {
                    return;
                }

                swap(index, smallest);
                index = smallest;
            }
        }

        public void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
}

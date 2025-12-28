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
        minheap minheap = new minheap(m);

        for (int i = 0; i < m; i++) {
            minheap.insert(0);
        }

        for (int i = 0; i < tasks.length; i++) {
            int task = tasks[i];

            int head = minheap.extractMin();
            int update = head + task;

            minheap.insert(update);
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = minheap.extractMin();
        }

        return res;
    }
}

    class minheap {

    private int[] heap;
    private int size;

    public minheap(int capacity) {
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

    private void swim(int index) {
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

    private void sink(int index) {
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

    public int[] heapsort() {

        int[] copiedHeap = new int[heap.length];
        for (int i = 0; i < heap.length; i++) {
            copiedHeap[i] = heap[i];
        }

        int originalSize = size;

        int[] sorted = new int[size];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = extractMin();
        }

        heap = copiedHeap;
        size = originalSize;

        for (int i = 0; i < sorted.length / 2; i++) {
            int temp = sorted[i];
            sorted[i] = sorted[sorted.length - 1 - i];
            sorted[sorted.length - 1 - i] = temp;
        }

        return sorted;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

public class heap {

    // ==============================
    // 1) The required method
    // ==============================
    static void cpu_scheduler(int[] tasks, int k) {

        MaxHeap heap = new MaxHeap(tasks.length);

        // Step 1: Insert all task priorities into the MaxHeap
        for (int i = 0; i < tasks.length; i++) {
            heap.insert(tasks[i]);
        }

        // If k > number of tasks, prevent errors
        int limit = Math.min(k, tasks.length);

        // Step 2: Extract top k priorities and print in order
        for (int rank = 1; rank <= limit; rank++) {
            int highestPriority = heap.extract();  // removes & returns max
            System.out.println("Task " + rank + " - Priority " + highestPriority);
        }
    }

    // ==============================
    // 2) MaxHeap Implementation
    // ==============================
    static class MaxHeap {

        private int[] heap;
        private int size;

        public MaxHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        public void insert(int value) {
            if (size == heap.length) {
                System.out.println("Heap is full, cannot insert " + value);
                return;
            }

            heap[size] = value;
            swim(size);
            size++;
        }

        public int extract() {
            if (size == 0) {
                System.out.println("Heap is empty, cannot extract!");
                return -1;
            }

            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            sink(0);

            return max;
        }

        private void swim(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;

                if (heap[index] <= heap[parent]) {
                    return;
                }

                swap(index, parent);
                index = parent;
            }
        }

        private void sink(int index) {
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int largest = index;

                if (left < size && heap[left] > heap[largest]) {
                    largest = left;
                }

                if (right < size && heap[right] > heap[largest]) {
                    largest = right;
                }

                if (largest == index) {
                    return;
                }

                swap(index, largest);
                index = largest;
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    // ==============================
    // 3) Tester (main method)
    // ==============================
    public static void main(String[] args) {

        int[] tasks = {45, 70, 85, 60, 90, 75};
        int k = 3;

        System.out.println("Top " + k + " tasks based on extraction rank:\n");
        cpu_scheduler(tasks, k);

        // Try another test
        System.out.println("\n--- Another test ---");
        int[] tasks2 = {12, 99, 35, 64, 50};
        int k2 = 4;
        System.out.println("Top " + k2 + " tasks based on extraction rank:\n");
        cpu_scheduler(tasks2, k2);
    }
}

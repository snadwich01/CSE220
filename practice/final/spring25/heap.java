public class PriorityTaskTestNoLookup {

    // ======================================================
    // 1) METHOD AT THE TOP (as requested)
    // ======================================================
    static void priority_task(int[] tasks) {

        MinHeap minHeap = new MinHeap(tasks.length);

        // Step 1: Insert all task values into the MinHeap
        for (int i = 0; i < tasks.length; i++) {
            minHeap.insert(tasks[i]);
        }

        // Step 2: Extract tasks in ascending order (smallest value first)
        for (int step = 1; step <= tasks.length; step++) {

            int val = minHeap.extract();        // smallest task value
            int idx = getIndex(tasks, val);     // magical O(1) in exam
            int taskNum = idx + 1;

            System.out.println("Step " + step + " - Task " + taskNum);
        }
    }

    // ======================================================
    // 2) "MAGICAL" FUNCTION getIndex(arr, val)
    // In the exam: assume this runs in O(1) and is provided.
    // For local testing: we implement it with a simple loop.
    // ======================================================
    static int getIndex(int[] arr, int val) {
        // TESTING ONLY (this is O(n))
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1; // should not happen if value exists
    }

    // ======================================================
    // 3) MinHeap Implementation (insert + extract)
    // ======================================================
    static class MinHeap {
        private int[] heap;
        private int size;

        MinHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        void insert(int value) {
            heap[size] = value;
            swim(size);
            size++;
        }

        int extract() {
            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            sink(0);
            return min;
        }

        private void swim(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap[i] >= heap[parent]) return;
                swap(i, parent);
                i = parent;
            }
        }

        private void sink(int i) {
            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int smallest = i;

                if (left < size && heap[left] < heap[smallest]) {
                    smallest = left;
                }
                if (right < size && heap[right] < heap[smallest]) {
                    smallest = right;
                }
                if (smallest == i) return;

                swap(i, smallest);
                i = smallest;
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    // ======================================================
    // 4) BUILDER / CONSTRUCTOR for sample tasks array
    // ======================================================
    static int[] buildSampleTasks() {
        // Sample from the question:
        // tasks = [60, 85, 70, 45]
        return new int[]{60, 85, 70, 45};
    }

    // ======================================================
    // 5) TESTER (main)
    // ======================================================
    public static void main(String[] args) {

        int[] tasks = buildSampleTasks();

        System.out.println("Input tasks:");
        System.out.print("[");
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(tasks[i]);
            if (i < tasks.length - 1) System.out.print(", ");
        }
        System.out.println("]\n");

        System.out.println("Output:");
        priority_task(tasks);

        System.out.println("\nExpected (from sample):");
        System.out.println("Step 1 - Task 4");
        System.out.println("Step 2 - Task 1");
        System.out.println("Step 3 - Task 3");
        System.out.println("Step 4 - Task 2");
    }
}

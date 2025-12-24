public class MinHeap {

    private int[] heap;
    private int size;

    // Constructor
    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Insert element into heap
    public void insert(int value) {
        if (size == heap.length) {
            return; // heap is full, do nothing
        }

        heap[size] = value;
        swim(size);
        size++;
    }

    // Restore heap upward
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

    // Remove minimum element
    public int extractMin() {
        if (size == 0) {
            return -1; // heap is empty
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink(0);

        return min;
    }

    // Restore heap downward
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

    // Heapsort (Descending Order)
    public int[] heapsort() {

        // Step 1: Copy original heap into instance array
        int[] copiedHeap = new int[heap.length];
        for (int i = 0; i < heap.length; i++) {
            copiedHeap[i] = heap[i];
        }

        int originalSize = size;

        // Step 2: Sort using extractMin
        int[] sorted = new int[size];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = extractMin();
        }

        // Step 3: Restore original heap
        heap = copiedHeap;
        size = originalSize;

        // Step 4: Reverse for descending order
        for (int i = 0; i < sorted.length / 2; i++) {
            int temp = sorted[i];
            sorted[i] = sorted[sorted.length - 1 - i];
            sorted[sorted.length - 1 - i] = temp;
        }

        return sorted;
    }

    // Swap helper
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

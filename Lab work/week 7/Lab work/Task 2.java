public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Insert element
    public void insert(int value) {
        if (size == heap.length) {
            throw new RuntimeException("Heap is full");
        }
        heap[size] = value;
        swim(size);
        size++;
    }

    // Restore heap upward
    private void swim(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index] <= heap[parent]) break;
            swap(index, parent);
            index = parent;
        }
    }

    // Remove maximum element
    public int extractMax() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink(0);

        return max;
    }

    // Restore heap downward
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

            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }
    }

    // HeapSort (Ascending Order)
    public int[] heapsort() {
        int[] backup = new int[size];
        for (int i = 0; i < size; i++) {
            backup[i] = heap[i];
        }

        int originalSize = size;
        int[] sorted = new int[size];

        for (int i = sorted.length - 1; i >= 0; i--) {
            sorted[i] = extractMax();
        }

        // Restore original heap
        heap = new int[backup.length];
        for (int i = 0; i < backup.length; i++) {
            heap[i] = backup[i];
        }
        size = originalSize;

        return sorted;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

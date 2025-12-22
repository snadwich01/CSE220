public class MinHeap {

    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
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
            if (heap[index] >= heap[parent]) break;
            swap(index, parent);
            index = parent;
        }
    }

    // Remove minimum element
    public int extractMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
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

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    // HeapSort (Descending Order)
    public int[] heapsort() {
        int[] backup = new int[size];
        for (int i = 0; i < size; i++) {
            backup[i] = heap[i];
        }

        int originalSize = size;
        int[] sorted = new int[size];

        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = extractMin();
        }

        // Restore original heap
        heap = new int[backup.length];
        for (int i = 0; i < backup.length; i++) {
            heap[i] = backup[i];
        }
        size = originalSize;

        // Reverse to get descending order
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

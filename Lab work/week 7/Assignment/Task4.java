public class Task4 {
    public static void main(String[] args) {
        int[] nums = {4, 10, 2, 8, 6, 7};
        int k = 3;

        int[] out = desc(nums, k);

        System.out.print("[");
        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i]);
            if (i < out.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int[] desc(int[] nums, int k) {
        MaxHeap maxheap = new MaxHeap(nums.length);

        for (int i = 0; i < nums.length; i++) {
            maxheap.insert(nums[i]);
        }

        int[] desc = new int[k];
        for (int i = 0; i < k; i++) {
            desc[i] = maxheap.extractMax();
        }

        return desc;
    }
}

class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
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

            if (heap[index] <= heap[parent]) {
                return;
            }

            swap(index, parent);
            index = parent;
        }
    }

    public int extractMax() {
        if (size == 0) {
            return -1;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink(0);

        return max;
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

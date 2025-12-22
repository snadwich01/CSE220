public class Tester {

    public static void main(String[] args) {

        // ---------- MinHeap Test ----------
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(6);

        System.out.println("MinHeap Sorted (Descending):");
        int[] minSorted = minHeap.heapsort();
        for (int val : minSorted) {
            System.out.print(val + " ");
        }

        System.out.println("\nExtract Min: " + minHeap.extractMin());

        // ---------- MaxHeap Test ----------
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(1);
        maxHeap.insert(6);

        System.out.println("\nMaxHeap Sorted (Ascending):");
        int[] maxSorted = maxHeap.heapsort();
        for (int val : maxSorted) {
            System.out.print(val + " ");
        }

        System.out.println("\nExtract Max: " + maxHeap.extractMax());
    }
}

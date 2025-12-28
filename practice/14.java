public class RescueHeap {

    public static int[] rescue(int n, int[] scores) {

        // Step 1: add grace mark (+1) with cap at 100
        for (int i = 0; i < n; i++) {
            scores[i] = scores[i] + 1;
            if (scores[i] > 100) {
                scores[i] = 100;
            }
        }

        // Step 2: convert to max-heap in-place (bottom-up heapify)
        for (int i = (n / 2) - 1; i >= 0; i--) {
            sinkMax(scores, n, i);
        }

        return scores;
    }

    private static void sinkMax(int[] arr, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < size && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest == index) {
                return;
            }

            swap(arr, index, largest);
            index = largest;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

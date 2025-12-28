public class Task5 {

    public static void main(String[] args) {
        String[] names = {"Email", "Meeting", "Code Review", "Lunch", "Debug"};
        int[] priorities = {2, 5, 3, 1, 4};

        String[] ordered = sort(names, priorities);

        System.out.print("[");
        for (int i = 0; i < ordered.length; i++) {
            System.out.print(ordered[i]);
            if (i < ordered.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static String[] sort(String[] names, int[] priorities) {
        int n = names.length;

        maxheap heap = new maxheap(n);

        for (int i = 0; i < n; i++) {
            heap.insert(names[i], priorities[i]);
        }

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = heap.extractmax();
        }

        return result;
    }

    static class maxheap {

        private String[] names;
        private int[] priorities;
        private int size;

        public maxheap(int capacity) {
            names = new String[capacity];
            priorities = new int[capacity];
            size = 0;
        }

        public void insert(String name, int priority) {
            if (size == priorities.length) return;

            names[size] = name;
            priorities[size] = priority;
            swim(size);
            size++;
        }

        public String extractmax() {
            if (size == 0) return null;

            String maxName = names[0];

            names[0] = names[size - 1];
            priorities[0] = priorities[size - 1];
            size--;
            sink(0);

            return maxName;
        }

        private void swim(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;

                if (priorities[index] <= priorities[parent]) {
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

                if (left < size) {
                    if (priorities[left] > priorities[largest]) {
                        largest = left;
                    }
                }

                if (right < size) {
                    if (priorities[right] > priorities[largest]) {
                        largest = right;
                    }
                }

                if (largest == index) {
                    return;
                }

                swap(index, largest);
                index = largest;
            }
        }

        private void swap(int i, int j) {
            int tempP = priorities[i];
            priorities[i] = priorities[j];
            priorities[j] = tempP;

            String tempN = names[i];
            names[i] = names[j];
            names[j] = tempN;
        }
    }
}

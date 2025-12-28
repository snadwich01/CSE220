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

        TaskMaxHeap heap = new TaskMaxHeap(n);

        for (int i = 0; i < n; i++) {
            heap.insert(names[i], priorities[i]);
        }

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = heap.extractmax();
        }

        return result;
    }

    static class TaskMaxHeap {

        private String[] names;
        private int[] prios;
        private int size;

        public TaskMaxHeap(int capacity) {
            names = new String[capacity];
            prios = new int[capacity];
            size = 0;
        }

        public void insert(String name, int priority) {
            if (size == prios.length) return;

            names[size] = name;
            prios[size] = priority;
            swim(size);
            size++;
        }

        public String extractmax() {
            if (size == 0) return null;

            String maxName = names[0];

            names[0] = names[size - 1];
            prios[0] = prios[size - 1];
            size--;
            sink(0);

            return maxName;
        }

        private void swim(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;

                if (prios[index] <= prios[parent]) return;

                swap(index, parent);
                index = parent;
            }
        }

        private void sink(int index) {
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int largest = index;

                if (left < size && prios[left] > prios[largest]) largest = left;
                if (right < size && prios[right] > prios[largest]) largest = right;

                if (largest == index) return;

                swap(index, largest);
                index = largest;
            }
        }

        private void swap(int i, int j) {
            int tempP = prios[i];
            prios[i] = prios[j];
            prios[j] = tempP;

            String tempN = names[i];
            names[i] = names[j];
            names[j] = tempN;
        }
    }
}

public class F1Qualifying {

    public static String[] rankDrivers(String[] drivers, int[] lap1, int[] lap2) {
        int n = drivers.length;

        DriverMinHeap heap = new DriverMinHeap(n);

        // Insert each driver with their best lap time
        for (int i = 0; i < n; i++) {
            int best = lap1[i];
            if (lap2[i] < best) best = lap2[i];

            heap.insert(drivers[i], best);
        }

        // Extract from heap to get fastest -> slowest
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = heap.extractMinName();
        }

        return result;
    }

    // ------------------------------
    // MinHeap storing (name, bestLap)
    // ------------------------------
    static class DriverMinHeap {
        private String[] names;
        private int[] times;
        private int size;

        public DriverMinHeap(int capacity) {
            names = new String[capacity];
            times = new int[capacity];
            size = 0;
        }

        public void insert(String name, int time) {
            names[size] = name;
            times[size] = time;
            swim(size);
            size++;
        }

        public String extractMinName() {
            if (size == 0) return null;

            String minName = names[0];

            names[0] = names[size - 1];
            times[0] = times[size - 1];
            size--;
            sink(0);

            return minName;
        }

        private void swim(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;

                if (times[i] >= times[parent]) return;

                swap(i, parent);
                i = parent;
            }
        }

        private void sink(int i) {
            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int smallest = i;

                if (left < size && times[left] < times[smallest]) {
                    smallest = left;
                }
                if (right < size && times[right] < times[smallest]) {
                    smallest = right;
                }

                if (smallest == i) return;

                swap(i, smallest);
                i = smallest;
            }
        }

        private void swap(int i, int j) {
            int tempT = times[i];
            times[i] = times[j];
            times[j] = tempT;

            String tempN = names[i];
            names[i] = names[j];
            names[j] = tempN;
        }
    }

    // ------------------------------
    // Simple tester (optional)
    // ------------------------------
    public static void main(String[] args) {
        String[] drivers = {"Verstappen", "Hamilton", "Leclerc", "Norris", "Russell"};
        int[] lap1 = {75, 78, 77, 79, 80};
        int[] lap2 = {76, 74, 78, 80, 79};

        String[] ranked = rankDrivers(drivers, lap1, lap2);

        System.out.print("[");
        for (int i = 0; i < ranked.length; i++) {
            System.out.print(ranked[i]);
            if (i < ranked.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

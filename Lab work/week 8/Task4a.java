public class Task4a {

    public static int[][] toUndirected(int[][] matrix) {
        int n = matrix.length;
        int[][] undirected = new int[n][n];

        for (int i = 0; i < n; i++) {
            undirected[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int w1 = matrix[i][j];
                int w2 = matrix[j][i];

                int w = 0;

                if (w1 != 0 && w2 != 0) {
                    w = w1 + w2;
                } else if (w1 != 0) {
                    w = w1;
                } else if (w2 != 0) {
                    w = w2;
                } else {
                    w = 0;
                }

                undirected[i][j] = w;
                undirected[j][i] = w;
            }
        }

        return undirected;
    }

    public static void main(String[] args) {

        int[][] directed = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 0, 0, 3},
                {0, 0, 0, 0, 1, 3, 0},
                {0, 0, 0, 0, 3, 3, 0},
                {0, 0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}};

        int[][] undirected = toUndirected(directed);

        for (int i = 0; i < undirected.length; i++) {
            for (int j = 0; j < undirected.length; j++) {
                System.out.print(undirected[i][j] + " ");
            }
            System.out.println();
        }
    }
}

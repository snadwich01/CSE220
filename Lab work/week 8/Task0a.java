public class Task0a {

    public static int[][] buildGraphMatrix() {
        int V = 6;
        int[][] matrix = new int[V + 1][V + 1];

        addEdge(matrix, 1, 2, 1);
        addEdge(matrix, 1, 3, 2);
        addEdge(matrix, 1, 5, 3);
        addEdge(matrix, 1, 6, 3);

        addEdge(matrix, 2, 4, 1);
        addEdge(matrix, 2, 5, 3);

        addEdge(matrix, 3, 4, 3);
        addEdge(matrix, 3, 5, 3);

        addEdge(matrix, 4, 5, 2);

        addEdge(matrix, 5, 6, 1);

        return matrix;
    }

    private static void addEdge(int[][] matrix, int a, int b, int w) {
        matrix[a][b] = w;
        matrix[b][a] = w;
    }

    public static void main(String[] args) {
        int[][] matrix = buildGraphMatrix();

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

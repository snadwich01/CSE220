public class Task2a {

    public static int maxsum(int[][] matrix) {
        int n = matrix.length;

        int bestVertex = 0;
        int bestSum = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }

            if (sum > bestSum) {
                bestSum = sum;
                bestVertex = i;
            }
        }

        return bestVertex;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 0, 3, 3},
                {0, 1, 0, 0, 1, 3, 0},
                {0, 2, 0, 0, 3, 3, 0},
                {0, 0, 1, 3, 0, 2, 0},
                {0, 3, 3, 3, 2, 0, 1},
                {0, 3, 0, 0, 0, 1, 0}
        };

        int ans = maxsum(matrix);
        System.out.println("Vertex: " + ans);
    }
}

public class Task1a {

    public static int maxDegree(int[][] matrix) {
        int n = matrix.length;
        int bestDeg = 0;

        for (int i = 1; i < n; i++) {
            int deg = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 0) deg++;
            }
            if (deg > bestDeg) bestDeg = deg;
        }

        return bestDeg;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {0, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0}
        };

        int deg = maxDegree(matrix);
        System.out.println(deg);
    }
}

public static void rotateSecret(Character[][] board) {
    int n = board.length;
    int layers = n / 2;

    // Start from OUTERMOST layer and move inward
    for (int layer = 0; layer < layers; layer++) {

        int first = layer;
        int last = n - 1 - layer;
        int size = (last - first) * 4;
        int rotations = layer + 1; // outer = 1, next = 2, etc.

        // Step 1: copy this ring into a 1D array
        char[] ring = new char[size];
        int k = 0;

        // top row
        for (int j = first; j <= last; j++)
            ring[k++] = board[first][j];

        // right column
        for (int i = first + 1; i <= last - 1; i++)
            ring[k++] = board[i][last];

        // bottom row
        for (int j = last; j >= first; j--)
            ring[k++] = board[last][j];

        // left column
        for (int i = last - 1; i >= first + 1; i--)
            ring[k++] = board[i][first];

        // Step 2: rotate the ring clockwise
        for (int r = 0; r < rotations; r++) {
            char temp = ring[size - 1];
            for (int i = size - 1; i > 0; i--)
                ring[i] = ring[i - 1];
            ring[0] = temp;
        }

        // Step 3: write back the rotated ring
        k = 0;

        for (int j = first; j <= last; j++)
            board[first][j] = ring[k++];

        for (int i = first + 1; i <= last - 1; i++)
            board[i][last] = ring[k++];

        for (int j = last; j >= first; j--)
            board[last][j] = ring[k++];

        for (int i = last - 1; i >= first + 1; i--)
            board[i][first] = ring[k++];
    }

    // Step 4: print message
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print(board[i][j]);
    }
    System.out.println();
}

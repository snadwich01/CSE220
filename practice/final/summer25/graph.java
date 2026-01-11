static void maxMutual(int[][] g, String[] mapper) {
    int n = g.length;

    int bestI = -1, bestJ = -1;
    int max = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {

            int mutual = 0;
            for (int k = 0; k < n; k++) {
                // skip counting i or j without using continue
                if (k != i && k != j) {
                    if (g[i][k] == 1 && g[j][k] == 1) {
                        mutual++;
                    }
                }
            }

            if (mutual > max) {
                max = mutual;
                bestI = i;
                bestJ = j;
            }
        }
    }

    if (max == 0) {
        System.out.println("There are no mutual friends between any vertices.");
    } else {
        System.out.println(mapper[bestI] + " and " + mapper[bestJ] +
                " have " + max + " mutual friend(s).");
    }
}
static int second_max(Node root) {

    // best[0] = maximum value
    // best[1] = second maximum value
    int[] best = new int[2];

    // Step 1: find the maximum in the tree
    best[0] = root.elem;
    findMax(root, best);

    // Step 2: find the largest value that is < max
    // We initialize best[1] to root.elem first,
    // then update it when we find values < max.
    best[1] = root.elem;
    findSecondMax(root, best);

    return best[1];
}

static void findMax(Node node, int[] best) {
    if (node == null) return;

    if (node.elem > best[0]) {
        best[0] = node.elem;
    }

    findMax(node.left, best);
    findMax(node.right, best);
}

static void findSecondMax(Node node, int[] best) {
    if (node == null) return;

    int max = best[0];

    // first time we find something < max, set it
    if (node.elem < max) {
        // if best[1] is still equal to max OR node.elem is bigger
        // than current best[1], update it
        if (best[1] == max || node.elem > best[1]) {
            best[1] = node.elem;
        }
    }

    findSecondMax(node.left, best);
    findSecondMax(node.right, best);
}

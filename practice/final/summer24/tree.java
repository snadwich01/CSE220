public class tree {

    // ======================================================
    // 1) METHOD AT THE ABSOLUTE TOP (as requested)
    // ======================================================
    static String build_key(Node root) {
        return build_key_helper(root, 0);
    }

    static String build_key_helper(Node node, int level) {
        // Base case
        if (node == null) return "";

        // Check if leaf node
        boolean isLeaf = (node.left == null && node.right == null);

        // If it's a leaf AND level is even → include it
        if (isLeaf && level % 2 == 0) {
            return node.elem;
        }

        // Right to left traversal (IMPORTANT)
        String rightPart = build_key_helper(node.right, level + 1);
        String leftPart  = build_key_helper(node.left, level + 1);

        return rightPart + leftPart;
    }

    // ======================================================
    // 2) NODE CLASS
    // ======================================================
    static class Node {
        String elem;
        Node left;
        Node right;

        Node(String elem) {
            this.elem = elem;
            this.left = null;
            this.right = null;
        }
    }

    // ======================================================
    // 3) BUILDER METHOD (Constructs the exact tree in image)
    //
    //              U
    //           /     \
    //          V       W
    //        /   \   /   \
    //       X     Y Z     I
    //      / \      / \
    //     J   N    L   M
    //    /
    //   K
    //
    // Expected output (right-to-left even-level leaves): "IYK"
    // ======================================================
    static Node buildSampleTree() {

        Node U = new Node("U");
        Node V = new Node("V");
        Node W = new Node("W");

        Node X = new Node("X");
        Node Y = new Node("Y");

        Node Z = new Node("Z");
        Node I = new Node("I");

        Node J = new Node("J");
        Node N = new Node("N");

        Node L = new Node("L");
        Node M = new Node("M");

        Node K = new Node("K");

        // Connect nodes according to the diagram
        U.left = V;
        U.right = W;

        V.left = X;
        V.right = Y;

        W.left = Z;
        W.right = I;

        X.left = J;
        X.right = N;

        Z.left = L;
        Z.right = M;

        J.left = K;

        return U; // root
    }

    // ======================================================
    // 4) TESTER (main)
    // ======================================================
    public static void main(String[] args) {

        Node root = buildSampleTree();

        String key = build_key(root);

        System.out.println("Generated Key: " + key);
        System.out.println("Expected Key : IYK");
    }
}

public class Tester {

    // ================= NODE CLASS =================
    static class BSTNode {
        int elem;
        BSTNode left;
        BSTNode right;

        BSTNode(int elem) {
            this.elem = elem;
            this.left = null;
            this.right = null;
        }
    }

    // ================= isBST =================
    public static boolean isBST(BSTNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, null, null);
    }

    private static boolean helper(BSTNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.elem <= min) {
            return false;
        }
        if (max != null && node.elem >= max) {
            return false;
        }

        return helper(node.left, min, node.elem) && helper(node.right, node.elem, max);
    }

    // ================= SIZE OF TREE =================
    private static int size(BSTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // ================= LARGEST BST =================
    public static int largestBST(BSTNode root) {
        if (root == null) {
            return 0;
        }

        if (isBST(root)) {
            return size(root);
        }

        int left = largestBST(root.left);
        int right = largestBST(root.right);

        // manual max, because rules
        if (left > right) {
            return left;
        } else {
            return right;
        }
    }

    // ================= TESTER =================
    public static void main(String[] args) {

        // Building the sample tree
        BSTNode root = new BSTNode(4);

        root.left = new BSTNode(10);
        root.right = new BSTNode(20);

        root.left.left = new BSTNode(5);
        root.left.right = new BSTNode(12);
        root.left.right.right = new BSTNode(13);

        root.right.left = new BSTNode(17);
        root.right.right = new BSTNode(24);

        System.out.println("Expected Output: 4");
        System.out.println("Actual output: " + largestBST(root));
    }
}

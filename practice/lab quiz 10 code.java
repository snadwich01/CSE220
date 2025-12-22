class TreeNode {
    int elem;
    TreeNode left;
    TreeNode right;

    TreeNode(int elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}

public class Tester {

    // ===== INSERT YOUR symmetricFactorDiff METHOD HERE ====
    public static void main(String[] args) {

        /*
                 8
               /   \
              6     12
             / \      \
            3   7      24
         */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(24);

        int x = 8;

        int result = symmetricFactorDiff(root, x);

        System.out.println("Result: " + result);
        System.out.println("Expected: 27");
    }

    public static int symmetricFactorDiff(TreeNode root, int x) {
        if(root == null || root.left == null || root.right == null) {
            return 0;
        }

        int sum = mirror(root.left, root.right);

        return sum;
    }

    public static int mirror(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            return 0;
        }

        int diff = 0, sum = 0;

        if(right.elem % left.elem == 0) {
            diff = right.elem - left.elem;
        }

        diff += mirror(left.left, right.right);
        diff += mirror(left.right, right.left);

        return diff;
    }
}

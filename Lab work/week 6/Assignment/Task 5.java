//Assignment Task (must Submit)
// Complete the sumOfLeaves method
public class Task5 {

    //===================================TASK#5======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Integer mirrorSum( BSTNode root ){
        if(root == null || root.left == null || root.right == null) {
            return 0;
        }

        int sum = mirror(root.left, root.right);

        return sum;
    }

    private static int mirror(BSTNode left, BSTNode right) {
        if(left == null || right == null) {
            return 0;
        }

        int sum = left.elem + right.elem;

        sum += mirror(left.left, right.right);
        sum += mirror(left.right, right.left);

        return sum;
    }
    //===============================================================


}

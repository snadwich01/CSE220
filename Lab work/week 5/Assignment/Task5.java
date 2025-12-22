// Complete the subtractSummation method
//ASSIGNMENT TASK MUST SUBMIT
public class Task5 {

    //===================================TASK#5===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer subtractSummation( BTNode root ){
        if(root == null) { return 0; }

        int leftSum = trav(root.left);
        int rightSum = trav(root.right);

        return leftSum - rightSum;
    }

    private static int trav(BTNode node) {
        if(node == null) { return 0; }

        return (Integer) node.elem + trav(node.left) + trav(node.right);
    }
    //============================================================================

}

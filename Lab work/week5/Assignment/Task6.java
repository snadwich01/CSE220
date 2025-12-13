// Complete the levelSum method
//ASSIGNMENT TASK MUST SUBMIT
public class Task6 {

    //===================================TASK#6===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum(BTNode root) {
        return trav(root, 0);
    }

    private static int trav(BTNode node, int level) {
        if (node == null) { return 0; }

        int parent = (Integer) node.elem;

        if (level % 2 == 0) {
            return - parent + trav(node.left, level + 1) + trav(node.right, level + 1);
        } else {
            return parent + trav(node.left, level + 1) + trav(node.right, level + 1);
        }
    }
    //============================================================================

}

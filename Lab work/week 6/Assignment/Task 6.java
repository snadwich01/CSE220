//Assignment Task (must Submit)
// Complete the isBST method
public class Task6 {

    //===================================TASK#6======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need

    public static Boolean isBST(BSTNode root){
        if(root == null) {
            return true;
        }
        
        return helper(root, null, null);
    }

    private static boolean helper(BSTNode node, Integer min, Integer max) {
        if(node == null) {
            return true;
        }
        
        if(min != null && node.elem <= min) {
            return false;
        }
        
        if(max != null && node.elem >= max) {
            return false;
        }
        
        if (!helper(node.left, min, node.elem)) {
            return false;
        }

        if (!helper(node.right, node.elem, max)) {
            return false;
        }

        return true;
    }
    //===============================================================


}

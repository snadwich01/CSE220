//LAB TASK NO NEED TO SUBMIT
// Complete the countNodes method
public class Task2 {

    //===================================TASK#2===================================
    // This method takes only 1 parameters root
    // This method return total count of the nodes in the tree
    public static int countNodes(BTNode root){
        if(root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        int total = 1 + leftCount + rightCount;

        return total;
    }
    //============================================================================
}

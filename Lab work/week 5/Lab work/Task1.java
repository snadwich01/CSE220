//LAB TASK NO NEED TO SUBMIT
// Complete the inOrder method
public class Task1 {

    //======================TASK#1======================
    // This method takes only 1 parameter which is root
    // You'll traverse the tree in-order
    public static void inOrder( BTNode root ){
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.elem + " ");
        inOrder(root.right);
    }
    //==================================================

}

//LAB TASK NO NEED TO SUBMIT
// Complete the kthLevelPrint method
public class Task3 {

        //===================================TASK#3===================================
        // This method takes 2 parameters, root and level
        // This method returns nothing
        // You can use extra helper private static methods as per need
        public static void kthLevelPrint( BTNode root, int lvl ){
            if (root == null) {
            return;
        }

        if (lvl == 0) {
            System.out.print(root.elem + " ");
            return;
        }

        kthLevelPrint(root.left,  lvl - 1);
        kthLevelPrint(root.right, lvl - 1);
        }
        //===========================================================================
}

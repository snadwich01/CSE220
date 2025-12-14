public static void task3(){
        taskPrint("\n====================== TASK#3 =====================");
        taskPrint("================== Sum of Leaves ==================");
        
        BSTNode root = new BSTNode(30);
        root.left = new BSTNode(10);
        root.left.left = new BSTNode(3);
        // CONSTRUCT THE REST OF THE TREE ON YOUR OWN
        // FROM THE EXAMPLE SHOWN IN THE QUESTION
        // TO DO
        root.left.right = new BSTNode(15);
        root.left.left.left = new BSTNode(2);

        root.right = new BSTNode(40);
        root.right.left = new BSTNode(35);
        root.right.right = new BSTNode(55);
        root.right.left.right = new BSTNode(36);
            
        //The following lines tests the sumOfLeaves. It's already been done for you.
        //So don't change the lines below
        System.out.println("::Given Binary Tree::");
        BSTPrinter.printNode(root);
        System.out.println("--------------------------------------------------");
        String t1 = "Task#3";
        System.out.println(":Expected Output: 108");
        Integer out = Task3.sumOfLeaves(root,0);
        System.out.println(":  Your Output  : "+out);
        if(out==null || out!=108) failedPrint(t1);
        else successPrint(t1);
        System.out.println("--------------------------------------------------");
    }

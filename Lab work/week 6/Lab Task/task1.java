public static void task1(){
        taskPrint("\n========================== TASK#1 =========================");
        taskPrint("================== Lowest Common Ancestor =================");
        
        BSTNode root = new BSTNode(15);
        root.left = new BSTNode(10);
        root.left.left = new BSTNode(8);
        // TO DO
        // CONSTRUCT THE REST OF THE TREE ON YOUR OWN FROM 
        // THE EXAMPLE SHOWN IN THE QUESTION
        root.left.right = new BSTNode(12);

        root.left.left.left = new BSTNode(6);
        root.left.left.right = new BSTNode(9);

        root.right = new BSTNode(25);
        root.right.left = new BSTNode(20);
        root.right.right = new BSTNode(30);

        root.right.left.left = new BSTNode(18);
        root.right.left.right = new BSTNode(22);

        // Once the you're done creating the tree then uncomment the following lines
        
        System.out.println("::Given Binary Tree::");
        BSTPrinter.printNode(root);
        System.out.println("--------------------------------------------------");
        
        //First test case is already written for you so, don' change it
        String t1 = "Task#1 Test#1";
        System.out.println(":Expected Output: LCA(6,12)=10");
        Integer out = Task1.lowestCommonAncestor(root,6,12);
        System.out.println(":  Your Output  : LCA(6,12)="+out);
        if(out==null || out!=10) failedPrint(t1);
        else successPrint(t1);
        
        //Write the rest of the test cases yourself
        
        System.out.println("------------------------------");
        // Test Case 2 (20,6)
        String t2 = "Task#1 Test#2";
        System.out.println(":Expected Output: LCA(20,6)=15");
        out = Task1.lowestCommonAncestor(root,20,6);
        System.out.println(":  Your Output  : LCA(20,6)="+out);
        if(out==null || out!=15) failedPrint(t2);
        else successPrint(t2);

        System.out.println("------------------------------");
        // Test Case 3 (18,22)
        String t3 = "Task#1 Test#3";
        System.out.println(":Expected Output: LCA(18,22)=20");
        out = Task1.lowestCommonAncestor(root,18,22);
        System.out.println(":  Your Output  : LCA(18,22)="+out);
        if(out==null || out!=20) failedPrint(t3);
        else successPrint(t3);

        System.out.println("------------------------------");
        // Test Case 4 (20,25)
        String t4 = "Task#1 Test#4";
        System.out.println(":Expected Output: LCA(20,25)=25");
        out = Task1.lowestCommonAncestor(root,20,25);
        System.out.println(":  Your Output  : LCA(20,25)="+out);
        if(out==null || out!=25) failedPrint(t4);
        else successPrint(t4);

        System.out.println("------------------------------");
        // Test Case 5 (10,12)
        String t5 = "Task#1 Test#5";
        System.out.println(":Expected Output: LCA(10,12)=10");
        out = Task1.lowestCommonAncestor(root,10,12);
        System.out.println(":  Your Output  : LCA(10,12)="+out);
        if(out==null || out!=10) failedPrint(t5);
        else successPrint(t5);

        System.out.println("------------------------------");
    }

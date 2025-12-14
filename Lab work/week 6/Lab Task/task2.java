public static void task2(){
        taskPrint("\n==================== TASK#2 =====================");
        taskPrint("================== Find Path ====================");
        
        BSTNode root = new BSTNode(30);
        root.left = new BSTNode(10);
        root.left.left = new BSTNode(3);
        // CONSTRUCT THE REST OF THE TREE ON YOUR OWN
        // FROM THE EXAMPLE SHOWN IN THE QUESTION
        // TO DO
        root.left.right = new BSTNode(15);
        root.right = new BSTNode(40);
        root.right.left = new BSTNode(35);
        root.right.right = new BSTNode(55);

        //The following 2 lines print the binary tree. So no need to change it
        System.out.println("::Given Binary Tree::");
        BSTPrinter.printNode(root);
        //The following lines tests the code. So no need to change it
        System.out.println("----------------------Test1----------------------");
        String exp = "30 10 15";
        System.out.println("\n::Expected Output String::");
        System.out.println(exp);
        System.out.println(bold+"\n::Your Output String::");
        String out = Task2.findPath(root, 15);
        System.out.println(out);
        System.out.print(normal);
        if( out!=null && exp.equals( out.trim() ) ) successPrint("Task#2 Test1");
        else failedPrint("Task#2 Test1");

        System.out.println("\n----------------------Test2----------------------");
        exp = "No Path Found";
        System.out.println("\n::Expected Output String::");
        System.out.println(exp);
        System.out.println(bold+"\n::Your Output String::");
        out = Task2.findPath(root, 50);
        System.out.println(out);
        System.out.print(normal);
        if( out!=null && exp.equals( out.trim() ) ) successPrint("Task#2 Test2");
        else failedPrint("Task#2 Test2");
    }

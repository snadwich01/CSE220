public class AssignmentTask6 {

    //SUBMIT ONLY THIS METHOD
    public static void pairJoin(DNode dh1, DNode dh2) {
        DNode c1 = dh1.next;
        DNode c2 = dh2.next;
        DNode t1 = dh1;

        while(c1 != null && c2 != null) {
            t1.next = c1;
            c1.prev = t1;
            t1 = c1;
            c1 = c1.next;

            t1.next = c2;
            c2.prev = t1;
            t1 = c2;
            c2 = c2.next;
        }
        
        t1.next = dh1;
        dh1.prev = t1;

        while(c1 != null) {
            System.out.print(c1.elem + " ");

            c1 = c1.next;
        }
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] list1 = {"A", "B", "C", "D"};
        Object[] list2 = {"E", "F", "G", "H"};

        DNode dh1 = LinkedListHelpers.createDummyHeadedDoublyLL(list1, false);
        DNode dh2 = LinkedListHelpers.createDummyHeadedDoublyLL(list2, false);

        System.out.println("Given Linked List 1:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh1);

        System.out.println("Given Linked List 2:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh2);

        System.out.println("\nExpected Output:");
        Object[] expected = {"A", "E", "B", "F", "C", "G", "D", "H"};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);

        //Running the Pair Join
        pairJoin(dh1, dh2);
        //Printing after Pair Join
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh1);
    }
}

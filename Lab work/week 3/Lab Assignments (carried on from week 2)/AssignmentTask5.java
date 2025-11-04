public class AssignmentTask5 {

    //SUBMIT ONLY THIS METHOD
    public static void sumOddAppend(Node dh) {
        // TO DO
        Node prev = dh;
        Node curr = dh.next;
        Node next = curr.next;

        int sum = 0;
        

        while(curr != dh) {
            if((int) curr.elem % 2 != 0) {
                sum += (int) curr.elem;
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        Node oddsum = new Node(sum);
        prev.next = oddsum;
        oddsum.next = dh;
    }

    //DO NOT SUBMIT THE DRIVER CODE BE  LOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {11, 22, 33, 44, 55, 66};
        Node head = LinkedListHelpers.createDummyHeadedSinglyCircularLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(head);
        System.out.println("\nExpected Output:");
        Object[] expected = {22, 44, 66, 99};
        Node expectedHead = LinkedListHelpers.createDummyHeadedSinglyCircularLL(expected, true);
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(expectedHead);
        
        //Running the Sum Odd Append
        sumOddAppend(head);
        //Printing after Sum Odd Append
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(head);
    }
}

public class MergeLLTest {

    // ======================================================
    // 1) METHOD AT THE ABSOLUTE TOP (as requested)
    // ======================================================
    static Node mergeLL(Node h1, Node h2) {

        if (h1 == null || h2 == null) return null;

        // -----------------------------
        // 1) Compute lengths of both lists
        // -----------------------------
        int len1 = 0, len2 = 0;
        Node t1 = h1, t2 = h2;

        while (t1 != null) {
            len1++;
            t1 = t1.next;
        }

        while (t2 != null) {
            len2++;
            t2 = t2.next;
        }

        // -----------------------------
        // 2) Align pointers so same distance to end
        // -----------------------------
        Node p1 = h1;
        Node p2 = h2;

        if (len1 > len2) {
            int diff = len1 - len2;
            for (int i = 0; i < diff; i++) {
                p1 = p1.next;
            }
        } else {
            int diff = len2 - len1;
            for (int i = 0; i < diff; i++) {
                p2 = p2.next;
            }
        }

        // -----------------------------
        // 3) Find intersection node
        // -----------------------------
        Node inter = null;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                inter = p1;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // If no intersection, return null
        if (inter == null) return null;

        // -----------------------------
        // 4) Find the node just BEFORE intersection in h1
        // -----------------------------
        Node prev = h1;
        while (prev.next != inter) {
            prev = prev.next;
        }

        // -----------------------------
        // 5) Merge: connect h1's non-overlap part to head of h2
        // -----------------------------
        prev.next = h2;

        return h1;
    }

    // ======================================================
    // 2) NODE CLASS
    // ======================================================
    static class Node {
        int elem;
        Node next;

        Node(int elem) {
            this.elem = elem;
            this.next = null;
        }
    }

    // ======================================================
    // 3) BUILDER: Intersecting example from the picture
    //
    // h1: 56 -> 78 -> 91 -> 62 -> 17 -> 89 -> 24
    // h2: 43 -> 33 -> (same 62 -> 17 -> 89 -> 24)
    //
    // merged should be:
    // 56 -> 78 -> 91 -> 43 -> 33 -> 62 -> 17 -> 89 -> 24
    // ======================================================
    static Node[] buildIntersectingExample() {

        // Shared tail: 62 -> 17 -> 89 -> 24
        Node shared62 = new Node(62);
        Node shared17 = new Node(17);
        Node shared89 = new Node(89);
        Node shared24 = new Node(24);

        shared62.next = shared17;
        shared17.next = shared89;
        shared89.next = shared24;

        // h1: 56 -> 78 -> 91 -> shared62
        Node h1_56 = new Node(56);
        Node h1_78 = new Node(78);
        Node h1_91 = new Node(91);

        h1_56.next = h1_78;
        h1_78.next = h1_91;
        h1_91.next = shared62;

        // h2: 43 -> 33 -> shared62
        Node h2_43 = new Node(43);
        Node h2_33 = new Node(33);

        h2_43.next = h2_33;
        h2_33.next = shared62;

        return new Node[]{h1_56, h2_43};
    }

    // ======================================================
    // 4) BUILDER: Non-intersecting example from the picture
    //
    // h1: 56 -> 78 -> 91 -> 17 -> 89 -> 24
    // h2: 43 -> 33 -> 36 -> 29
    //
    // merged should be null
    // ======================================================
    static Node[] buildNonIntersectingExample() {

        Node h1_56 = new Node(56);
        Node h1_78 = new Node(78);
        Node h1_91 = new Node(91);
        Node h1_17 = new Node(17);
        Node h1_89 = new Node(89);
        Node h1_24 = new Node(24);

        h1_56.next = h1_78;
        h1_78.next = h1_91;
        h1_91.next = h1_17;
        h1_17.next = h1_89;
        h1_89.next = h1_24;

        Node h2_43 = new Node(43);
        Node h2_33 = new Node(33);
        Node h2_36 = new Node(36);
        Node h2_29 = new Node(29);

        h2_43.next = h2_33;
        h2_33.next = h2_36;
        h2_36.next = h2_29;

        return new Node[]{h1_56, h2_43};
    }

    // ======================================================
    // 5) PRINT LIST (utility for testing)
    // ======================================================
    static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.elem);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    // ======================================================
    // 6) TESTER
    // ======================================================
    public static void main(String[] args) {

        // -------- Test 1: Intersecting Lists
        System.out.println("=== Test 1: Intersecting Lists ===");
        Node[] intersecting = buildIntersectingExample();
        Node h1 = intersecting[0];
        Node h2 = intersecting[1];

        System.out.print("h1: ");
        printList(h1);
        System.out.print("h2: ");
        printList(h2);

        Node merged = mergeLL(h1, h2);

        System.out.print("Merged result: ");
        printList(merged);
        System.out.println("Expected     : 56 -> 78 -> 91 -> 43 -> 33 -> 62 -> 17 -> 89 -> 24");

        // -------- Test 2: Non-intersecting Lists
        System.out.println("\n=== Test 2: Non-intersecting Lists ===");
        Node[] nonIntersecting = buildNonIntersectingExample();
        Node h1b = nonIntersecting[0];
        Node h2b = nonIntersecting[1];

        System.out.print("h1: ");
        printList(h1b);
        System.out.print("h2: ");
        printList(h2b);

        Node merged2 = mergeLL(h1b, h2b);

        System.out.print("Merged result: ");
        printList(merged2);
        System.out.println("Expected     : null");
    }
}

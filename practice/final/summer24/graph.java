public class graph {

     // =====================================
    // YOUR METHOD: is_complete
    // =====================================
    static boolean is_complete(Edge[] network) {
        int n = network.length;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n];

            Edge cur = network[i];
            while (cur != null) {
                int j = cur.destination;
                if (j != i) {
                    seen[j] = true;
                }
                cur = cur.next;
            }

            for (int j = 0; j < n; j++) {
                if (j != i && !seen[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // =============================
    // Edge node (linked list node)
    // =============================
    static class Edge {
        int destination;
        Edge next;

        public Edge(int destination) {
            this.destination = destination;
            this.next = null;
        }
    }

    // =====================================
    // Add an edge to the adjacency list
    // network[from] is the head of linked list
    // =====================================
    static void addEdge(Edge[] network, int from, int to) {
        Edge newNode = new Edge(to);

        // if list is empty, new node becomes head
        if (network[from] == null) {
            network[from] = newNode;
        } else {
            // otherwise append to end
            Edge cur = network[from];
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    // =====================================
    // Builder: builds a COMPLETE undirected graph
    // with n vertices: 0..n-1
    // =====================================
    static Edge[] buildCompleteGraph(int n) {
        Edge[] network = new Edge[n];

        // for every pair (i, j), i != j, add edge i -> j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    addEdge(network, i, j);
                }
            }
        }
        return network;
    }

    // =====================================
    // Builder: builds an INCOMPLETE graph example
    // (missing at least one connection)
    // =====================================
    static Edge[] buildIncompleteGraph() {
        int n = 4;
        Edge[] network = new Edge[n];

        // Make it almost complete, but we will remove one required edge
        addEdge(network, 0, 1);
        addEdge(network, 0, 2);
        addEdge(network, 0, 3);

        addEdge(network, 1, 0);
        addEdge(network, 1, 2);
        addEdge(network, 1, 3);

        addEdge(network, 2, 0);
        addEdge(network, 2, 1);
        // MISSING: addEdge(network, 2, 3);   <-- This makes it incomplete

        addEdge(network, 3, 0);
        addEdge(network, 3, 1);
        addEdge(network, 3, 2);

        return network;
    }

    // =====================================
    // Print adjacency list (for debugging)
    // =====================================
    static void printNetwork(Edge[] network) {
        for (int i = 0; i < network.length; i++) {
            System.out.print(i + ":");
            Edge cur = network[i];
            while (cur != null) {
                System.out.print(" -> " + cur.destination);
                cur = cur.next;
            }
            System.out.println();
        }
    }

   
    // =====================================
    // TESTER
    // =====================================
    public static void main(String[] args) {

        // -------- Test 1: Complete graph with 4 vertices
        System.out.println("=== Test 1: Complete Graph (n=4) ===");
        Edge[] complete = buildCompleteGraph(4);
        printNetwork(complete);
        System.out.println("is_complete? " + is_complete(complete));

        // -------- Test 2: Incomplete graph example
        System.out.println("\n=== Test 2: Incomplete Graph (missing one edge) ===");
        Edge[] incomplete = buildIncompleteGraph();
        printNetwork(incomplete);
        System.out.println("is_complete? " + is_complete(incomplete));
    }
}

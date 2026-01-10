public class graph {

    // ======================================================
    // 1) METHOD AT THE TOP (as requested)
    // NO Integer.parseInt, NO String.valueOf
    // ======================================================
    static String find_minimum(Edge[] graph) {
        int n = graph.length;

        // incomingSum[i] = total incoming traffic coming INTO city i
        int[] incomingSum = new int[n];

        // 1) Compute incoming sums by scanning all outgoing edges
        for (int i = 0; i < n; i++) {
            Edge cur = graph[i];

            while (cur != null) {
                // destination is a String like "0", "1", "2"...
                int dest = cur.destination.charAt(0) - '0';

                incomingSum[dest] += cur.weight;
                cur = cur.next;
            }
        }

        // 2) Find city with minimum incoming sum
        int minCity = 0;
        int minVal = incomingSum[0];

        for (int i = 1; i < n; i++) {
            if (incomingSum[i] < minVal) {
                minVal = incomingSum[i];
                minCity = i;
            }
        }

        // 3) Return city label as String WITHOUT valueOf
        return "" + (char) ('0' + minCity);
    }

    // ======================================================
    // 2) EDGE CLASS
    // Each adjacency list is a linked list of Edge nodes
    // ======================================================
    static class Edge {
        String source;
        String destination;
        int weight;
        Edge next;

        Edge(String source, String destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.next = null;
        }
    }

    // ======================================================
    // 3) APPEND EDGE to adjacency list
    // graph[from] is the head of linked list
    // ======================================================
    static void addEdge(Edge[] graph, String from, String to, int w) {
        int fromIndex = from.charAt(0) - '0';
        Edge newEdge = new Edge(from, to, w);

        if (graph[fromIndex] == null) {
            graph[fromIndex] = newEdge;
        } else {
            Edge cur = graph[fromIndex];
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newEdge;
        }
    }

    // ======================================================
    // 4) BUILDER: builds the sample graph in the question
    //
    // Sample Input Table (from image):
    //
    // 0: <0,1,20> -> <0,2,55> -> <0,3,40>
    // 1: <1,0,70> -> <1,2,35> -> <1,3,20>
    // 2: <2,0,30> -> <2,1,25> -> <2,3,55>
    // 3: <3,2,60>
    //
    // Expected Answer: "1"
    // ======================================================
    static Edge[] buildSampleGraph() {
        int n = 4;  // cities 0..3
        Edge[] graph = new Edge[n];

        addEdge(graph, "0", "1", 20);
        addEdge(graph, "0", "2", 55);
        addEdge(graph, "0", "3", 40);

        addEdge(graph, "1", "0", 70);
        addEdge(graph, "1", "2", 35);
        addEdge(graph, "1", "3", 20);

        addEdge(graph, "2", "0", 30);
        addEdge(graph, "2", "1", 25);
        addEdge(graph, "2", "3", 55);

        addEdge(graph, "3", "2", 60);

        return graph;
    }

    // ======================================================
    // 5) PRINT GRAPH (for debugging)
    // ======================================================
    static void printGraph(Edge[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + ": ");
            Edge cur = graph[i];
            while (cur != null) {
                System.out.print("<" + cur.source + "," + cur.destination + "," + cur.weight + "> ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    // ======================================================
    // 6) OPTIONAL: print incoming sums (to verify)
    // ======================================================
    static void printIncomingSums(Edge[] graph) {
        int n = graph.length;
        int[] incomingSum = new int[n];

        for (int i = 0; i < n; i++) {
            Edge cur = graph[i];
            while (cur != null) {
                int dest = cur.destination.charAt(0) - '0';
                incomingSum[dest] += cur.weight;
                cur = cur.next;
            }
        }

        System.out.println("\nIncoming traffic totals:");
        for (int i = 0; i < n; i++) {
            System.out.println("City " + i + " incoming = " + incomingSum[i]);
        }
    }

    // ======================================================
    // 7) TESTER
    // ======================================================
    public static void main(String[] args) {

        Edge[] graph = buildSampleGraph();

        System.out.println("Adjacency List:");
        printGraph(graph);

        printIncomingSums(graph);

        String answer = find_minimum(graph);

        System.out.println("\nCity with MIN incoming traffic: " + answer);
        System.out.println("Expected: 1");
    }
}

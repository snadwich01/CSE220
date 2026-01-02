// EdgeNode.java
class EdgeNode {
    int toV;
    int weight;
    EdgeNode next;

    public EdgeNode(int toV, int weight) {
        this.toV = toV;
        this.weight = weight;
        this.next = null;
    }
}


// GraphUtils.java
class GraphUtils {
        // Print a single adjacency list (linked list)
    public static void printLL(EdgeNode head) {
        EdgeNode n = head;
        while (n != null) {
            System.out.print(" -> (" + n.toV + "," + n.weight + ")");
            n = n.next;
        }
        System.out.println();
    }

    
    // Append a new edge node to adjacency list
    public static void appendLL(EdgeNode head, EdgeNode eNode) {
        EdgeNode n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = eNode;
    }

    
    // Add an edge to adjacency list (directed graph)
    public static void addEdge(EdgeNode[] adjList, int from, int to, int weight) {
        EdgeNode newNode = new EdgeNode(to, weight);
        if (adjList[from] == null) {
            adjList[from] = newNode;
        } else {
            appendLL(adjList[from], newNode);
        }
    }

    
    // Show adjacency list for all vertices
    public static void showAdjList(EdgeNode[] adjList) {
        for (int i = 1; i < adjList.length; i++) {
            System.out.print("Vertex " + i + ":");
            printLL(adjList[i]);
        }
    }
}


// GraphDemo.java
public class Task0b {
    public static void main(String[] args) {
                int V = 6; // number of vertices
                EdgeNode[] adjList = new EdgeNode[V + 1]; // array of adjacency lists

        GraphUtils.addEdge(adjList, 1, 2, 1);
        GraphUtils.addEdge(adjList, 1, 3, 2);
        GraphUtils.addEdge(adjList, 1, 6, 3);

        GraphUtils.addEdge(adjList, 2, 4, 1);
        GraphUtils.addEdge(adjList, 2, 5, 3);

        GraphUtils.addEdge(adjList, 3, 4, 3);
        GraphUtils.addEdge(adjList, 3, 5, 3);

        GraphUtils.addEdge(adjList, 4, 5, 2);

        GraphUtils.addEdge(adjList, 5, 6, 1);

                // Show adjacency list
        System.out.println("Adjacency List Representation:");
        GraphUtils.showAdjList(adjList);
    }
}

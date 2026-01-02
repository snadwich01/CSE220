public class Task4b {

    static class EdgeNode {
        int toV;
        int weight;
        EdgeNode next;

        public EdgeNode(int toV, int weight) {
            this.toV = toV;
            this.weight = weight;
            this.next = null;
        }
    }

    static class GraphUtils {

        public static void appendLL(EdgeNode head, EdgeNode node) {
            EdgeNode n = head;
            while (n.next != null) n = n.next;
            n.next = node;
        }

        public static void addEdge(EdgeNode[] adjList, int from, int to, int weight) {
            EdgeNode node = new EdgeNode(to, weight);
            if (adjList[from] == null) adjList[from] = node;
            else appendLL(adjList[from], node);
        }

        public static void printLL(EdgeNode head) {
            EdgeNode n = head;
            while (n != null) {
                System.out.print(" -> (" + n.toV + "," + n.weight + ")");
                n = n.next;
            }
            System.out.println();
        }

        public static void showAdjList(EdgeNode[] adjList) {
            for (int i = 0; i < adjList.length; i++) {
                System.out.print("Vertex " + i + ":");
                printLL(adjList[i]);
            }
        }

        //Task 4b------------------------------------------------

        public static int getweight(EdgeNode head, int to) {
            EdgeNode curr = head;
            while (curr != null) {
                if (curr.toV == to) return curr.weight;
                curr = curr.next;
            }
            return 0;
        }

        public static void addOrSumEdge(EdgeNode[] undirected, int a, int b, int weight) {
            int existing = getweight(undirected[a], b);
            if (existing == 0) {
                addEdge(undirected, a, b, weight);
                addEdge(undirected, b, a, weight);
            } else {
                int newweight = existing + weight;
                updateWeight(undirected[a], b, newweight);
                updateWeight(undirected[b], a, newweight);
            }
        }

        public static void updateWeight(EdgeNode head, int to, int newweight) {
            EdgeNode curr = head;
            while (curr != null) {
                if (curr.toV == to) {
                    curr.weight = newweight;
                    return;
                }
                curr = curr.next;
            }
        }

        public static EdgeNode[] conv(EdgeNode[] directed) {
            EdgeNode[] undirected = new EdgeNode[directed.length];

            for (int from = 0; from < directed.length; from++) {
                EdgeNode curr = directed[from];

                while (curr != null) {
                    int to = curr.toV;
                    int weight = curr.weight;

                    if (from != to) {
                        addOrSumEdge(undirected, from, to, weight);
                    }

                    curr = curr.next;
                }
            }

            return undirected;
        }
    }

    public static void main(String[] args) {

        int V = 6;
        EdgeNode[] directed = new EdgeNode[V + 1];

        GraphUtils.addEdge(directed, 1, 2, 1);
        GraphUtils.addEdge(directed, 1, 3, 2);
        GraphUtils.addEdge(directed, 1, 6, 3);

        GraphUtils.addEdge(directed, 2, 4, 1);
        GraphUtils.addEdge(directed, 2, 5, 3);

        GraphUtils.addEdge(directed, 3, 4, 3);
        GraphUtils.addEdge(directed, 3, 5, 3);

        GraphUtils.addEdge(directed, 4, 5, 2);

        GraphUtils.addEdge(directed, 5, 6, 1);

        EdgeNode[] undirected = GraphUtils.conv(directed);

        System.out.println("Undirected Adjacency List:");
        GraphUtils.showAdjList(undirected);
    }
}

public class Task1b {

    static class EdgeNode {
        int toV;
        EdgeNode next;

        public EdgeNode(int toV) {
            this.toV = toV;
            this.next = null;
        }
    }

    static class GraphUtils {

        public static void appendLL(EdgeNode head, EdgeNode node) {
            EdgeNode n = head;
            while (n.next != null) n = n.next;
            n.next = node;
        }

        public static void addEdge(EdgeNode[] adjList, int from, int to) {
            EdgeNode node = new EdgeNode(to);
            if (adjList[from] == null) adjList[from] = node;
            else appendLL(adjList[from], node);
        }

        public static void addUndirectedEdge(EdgeNode[] adjList, int a, int b) {
            addEdge(adjList, a, b);
            addEdge(adjList, b, a);
        }

        public static int maxDegree(EdgeNode[] adjList) {
            int bestDeg = 0;

            for (int i = 1; i < adjList.length; i++) {
                int deg = 0;
                EdgeNode cur = adjList[i];
                while (cur != null) {
                    deg++;
                    cur = cur.next;
                }
                if (deg > bestDeg) bestDeg = deg;
            }

            return bestDeg;
        }
    }

    public static void main(String[] args) {
        int V = 6;
        EdgeNode[] adjList = new EdgeNode[V + 1];

        GraphUtils.addUndirectedEdge(adjList, 1, 2);
        GraphUtils.addUndirectedEdge(adjList, 1, 3);
        GraphUtils.addUndirectedEdge(adjList, 1, 5);
        GraphUtils.addUndirectedEdge(adjList, 1, 6);

        GraphUtils.addUndirectedEdge(adjList, 2, 4);
        GraphUtils.addUndirectedEdge(adjList, 2, 5);

        GraphUtils.addUndirectedEdge(adjList, 3, 4);
        GraphUtils.addUndirectedEdge(adjList, 3, 5);

        GraphUtils.addUndirectedEdge(adjList, 4, 5);

        GraphUtils.addUndirectedEdge(adjList, 5, 6);

        int deg = GraphUtils.maxDegree(adjList);
        System.out.println(deg);
    }
}

public class Task3b {

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

        public static void addEdge(EdgeNode[] adjList, int from, int to, int w) {
            EdgeNode node = new EdgeNode(to, w);
            if (adjList[from] == null) adjList[from] = node;
            else appendLL(adjList[from], node);
        }

        //Task 3b-------------------------------------------------------------------------------

        public static int maxdeg(EdgeNode[] adjList) {
            int bestDeg = 0;

            for (int i = 0; i < adjList.length; i++) {
                int deg = 0;
                EdgeNode cur = adjList[i];
                while (cur != null) {
                    deg++;
                    cur = cur.next;
                }
                if (deg > bestDeg) {
                    bestDeg = deg;
                }
            }

            return bestDeg;
        }

        public static int maxsum(EdgeNode[] adjList) {
            int vert = 0;
            int maxSum = 0;

            for (int i = 0; i < adjList.length; i++) {
                int sum = 0;
                EdgeNode cur = adjList[i];

                while (cur != null) {
                    sum += cur.weight;
                    cur = cur.next;
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    vert = i;
                }
            }

            return vert;
        }
    }

    public static void main(String[] args) {

        int V = 6;
        EdgeNode[] adjList = new EdgeNode[V + 1];

        GraphUtils.addEdge(adjList, 1, 2, 1);
        GraphUtils.addEdge(adjList, 1, 3, 2);
        GraphUtils.addEdge(adjList, 1, 6, 3);

        GraphUtils.addEdge(adjList, 2, 4, 1);
        GraphUtils.addEdge(adjList, 2, 5, 3);

        GraphUtils.addEdge(adjList, 3, 4, 3);
        GraphUtils.addEdge(adjList, 3, 5, 3);

        GraphUtils.addEdge(adjList, 4, 5, 2);

        GraphUtils.addEdge(adjList, 5, 6, 1);

        int deg = GraphUtils.maxdeg(adjList);
        int vert = GraphUtils.maxsum(adjList);

        System.out.println("Max degree: " + deg);
        System.out.println("Maxsum vertex: " + vert);
    }
}

public class Task2b {

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

        public static void appendLL(EdgeNode head, EdgeNode eNode) {
            EdgeNode n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = eNode;
        }

        public static void addEdge(EdgeNode[] adjList, int from, int to, int weight) {
            EdgeNode newNode = new EdgeNode(to, weight);
            if (adjList[from] == null) {
                adjList[from] = newNode;
            } else {
                appendLL(adjList[from], newNode);
            }
        }

        public static void addundirect(EdgeNode[] adjList, int a, int b, int w) {
            addEdge(adjList, a, b, w);
            addEdge(adjList, b, a, w);
        }

        //Task 2b---------------------------------------------------------------

    public static int maxsum(EdgeNode[] adjList) {

        int vert = 0;
        int maxSum = -1;

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

        GraphUtils.addundirect(adjList, 1, 2, 1);
        GraphUtils.addundirect(adjList, 1, 3, 2);
        GraphUtils.addundirect(adjList, 1, 6, 3);

        GraphUtils.addundirect(adjList, 2, 4, 1);
        GraphUtils.addundirect(adjList, 2, 5, 3);

        GraphUtils.addundirect(adjList, 3, 4, 3);
        GraphUtils.addundirect(adjList, 3, 5, 3);

        GraphUtils.addundirect(adjList, 4, 5, 2);

        GraphUtils.addundirect(adjList, 5, 6, 1);

        int ans = GraphUtils.maxsum(adjList);
        System.out.println("Maxsum vertex: " + ans);
    }
}

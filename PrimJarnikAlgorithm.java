import java.util.*;

class PrimJarnikAlgorithm {

    static class Edge implements Comparable<Edge> {
        int target, weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    public static void primMST(List<List<Edge>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<int[]> mst = new ArrayList<>();

        visited[0] = true;
        pq.addAll(graph.get(0));

        while (!pq.isEmpty() && mst.size() < n - 1) {
            Edge edge = pq.poll();
            if (!visited[edge.target]) {
                visited[edge.target] = true;
                mst.add(new int[]{edge.target, edge.weight});
                pq.addAll(graph.get(edge.target));
            }
        }

        System.out.println("Minimum Spanning Tree:");
        int totalWeight = 0;
        for (int[] e : mst) {
            System.out.println("Node: " + e[0] + ", Weight: " + e[1]);
            totalWeight += e[1];
        }
        System.out.println("Total Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 2));
        graph.get(1).add(new Edge(0, 4));
        graph.get(1).add(new Edge(2, 5));
        graph.get(1).add(new Edge(3, 10));
        graph.get(2).add(new Edge(0, 2));
        graph.get(2).add(new Edge(1, 5));
        graph.get(2).add(new Edge(4, 3));
        graph.get(3).add(new Edge(1, 10));
        graph.get(3).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 3));
        graph.get(4).add(new Edge(3, 7));

        primMST(graph);
    }
}


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 *
 * 섬 연결하기
 */
class Programmers42861 {
    private static int[] parent;
    private static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{ {0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }

    public static int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] ints : costs) {
            edges.add(new Edge(ints[0], ints[1], ints[2]));
        }

        Collections.sort(edges);

        int answer = 0;
        for (Edge edge : edges) {
            if (answer == n - 1) {
                break;
            }
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);

                answer += cost;
            }
        }

        return answer;
    }

    private static int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    private static void unionParent(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);
        parent[rootB] = rootA;
    }

    private static class Edge implements Comparable<Edge> {
        private final int nodeA;
        private final int nodeB;
        private final int distance;

        private Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        private int getDistance() {
            return this.distance;
        }

        private int getNodeA() {
            return this.nodeA;
        }

        private int getNodeB() {
            return this.nodeB;
        }

        @Override
        public int compareTo(Edge other) {
            return this.distance - other.distance;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] DA = new int[1001][1001];

        // 첫째줄에는 n, m, k 가 주어짐
        // n = 노드 갯수 / m = 엣지 갯수 / c = 가중치
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] distQueue = new PriorityQueue[n + 1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };

        for (int i = 0; i < n + 1; i++) {
            distQueue[i] = new PriorityQueue<>(c, cp);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            DA[x][y] = a;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        distQueue[1].add(0);
        while (!pq.isEmpty()) {
            Node u = pq.poll();

            for (int adjNode = 1; adjNode <= n; adjNode++) {
                if (DA[u.node][adjNode] != 0) {
                    if (distQueue[adjNode].size() < c) {
                        distQueue[adjNode].add(u.value + DA[u.node][adjNode]);
                        pq.add(new Node(adjNode, u.value + DA[u.node][adjNode]));
                    } else if (distQueue[adjNode].peek() > u.value + DA[u.node][adjNode]) {
                        distQueue[adjNode].poll();
                        distQueue[adjNode].add(u.value + DA[u.node][adjNode]);
                        pq.add(new Node(adjNode, u.value + DA[u.node][adjNode]));
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distQueue[i].size() == c) {
                System.out.println(distQueue[i].peek());
            } else {
                System.out.println("-1");
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }

        public int compareTo(Node node) {

            return this.value < node.value ? -1 : 1;
        }
    }
}
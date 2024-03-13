import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Edge> A[];
    static boolean visited[];
    static int distance[];
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드의 개수 V와 에지의 개수 E가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 2번째 줄은 노드의 출발 번호 K 가 주어진다.
        int K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        A = new ArrayList[V + 1];

        // 그래프 초기화
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 3번째 줄부터는 (U, S, W) 로 주어지는데 U에서 S로 가는 가중치 W인 엣지가 존재한다는 뜻이고 U 와 S는 다르다.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            A[U].add(new Edge(S, W));
        }

        q.add(new Edge(K, 0));
        distance[K] = 0;

        while (!q.isEmpty()) {
            Edge current = q.poll();
            int cHead = current.head;

            if (visited[cHead]) {
                continue;
            }
            visited[cHead] = true;

            for (int i = 0; i < A[cHead].size(); i++) {

                Edge temp = A[cHead].get(i);
                int head = temp.head;
                int value = temp.value;

                if (distance[head] > distance[cHead] + value) {

                    distance[head] = distance[cHead] + value;
                    q.add(new Edge(head, distance[head]));
                }
            }
        }

        // 모든 노드의 개수에는 1부터 V까지 번호가 메겨져 있다.
        // 1번째부터 V번째까지 최단 경로값을 출력 / 경로가 없다면 INF를 출력

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static class Edge implements Comparable<Edge> {

        int head;
        int value;

        public Edge(int head, int value) {
            this.head = head;
            this.value = value;
        }

        public int compareTo(Edge e) {
            if (this.value > e.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
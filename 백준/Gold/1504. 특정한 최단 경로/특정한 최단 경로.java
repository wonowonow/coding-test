import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Nodes = Integer.parseInt(st.nextToken());
        int Edges = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= Nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < Edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long result1 = dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, Nodes);

        long result2 = dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, Nodes);

        long answer = Math.min(result1, result2);

        System.out.println(answer >= INF ? -1 : answer);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            int to = now.to;
            int cost = now.cost;

            if (cost > dist[to]) {
                continue;
            }

            for (Node next : graph.get(to)) {
                if (dist[next.to] > dist[to] + next.cost) {
                    dist[next.to] = dist[to] + next.cost;
                    q.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist[end];
    }

    private static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}

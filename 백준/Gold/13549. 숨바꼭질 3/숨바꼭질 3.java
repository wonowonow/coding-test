import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);
        System.out.println(answer);
    }

    private static void bfs(int start, int end) {
        boolean[] visited = new boolean[100001];
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2)-> {
            return o1.cnt - o2.cnt;
        });
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;

            if (x == end) {
                answer = now.cnt;
                return;
            }
            
            if (visited[x]) {
                continue;
            }
            visited[x] = true;

            int[] nexts = {2 * x, x - 1, x + 1};
            
            if (nexts[0] <= 100000 && !visited[nexts[0]]) {
                q.add(new Node(nexts[0], now.cnt));
            }
            
            if (nexts[1] >= 0 && !visited[nexts[1]]) {
                q.add(new Node(nexts[1], now.cnt + 1));
            }
            
            if (nexts[2] <= 100000 && !visited[nexts[2]]) {
                q.add(new Node(nexts[2], now.cnt + 1));
            }
        }

    }

    public static class Node {
        int x;
        int cnt;
        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}

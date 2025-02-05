import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[] order = new int[count];
            for (int j = 0; j < count; j++) {
                order[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < count - 1; j++) {
                int u = order[j];
                int v = order[j + 1];
                graph.get(u).add(v);
                indegree[v]++;
            }
        }

        List<Integer> answer = topologicalSort(N, graph, indegree);

        if (answer.size() != N) {
            System.out.println(0);
        } else {
            for (int num : answer) {
                System.out.println(num);
            }
        }
    }

    private static List<Integer> topologicalSort(int n, ArrayList<ArrayList<Integer>> graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            for (int v : graph.get(now)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return result;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long distance[];
    static Edge edgeArray[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        // 간선 갯수
        distance = new long[node + 1];
        edgeArray = new Edge[line + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeArray[i] = new Edge(start, end, weight);
        }

        distance[1] = 0;

        for (int i = 1; i < node; i++) { // node 보다 1개 적은 수 만큼 반복하기
            for (int j = 0; j < line; j++) {
                Edge edge = edgeArray[j];

                if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.weight) {
                    distance[edge.end] = distance[edge.start] + edge.weight;
                }
            }
        }
        boolean havingMinusCycle = false;

        for (int i = 0; i < line; i++) { // 음수 사이클 확인
            Edge edge = edgeArray[i];
            if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.weight) {
                havingMinusCycle = true;
            }
        }

        if (!havingMinusCycle) {
            for (int i = 2; i <= node; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
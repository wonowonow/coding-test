import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 건물 종류 수 N
        int N = Integer.parseInt(br.readLine());
        // 건물 짓는데 걸리는 시간과 건물을 짓기위해 먼저 지어야하는 건물들의 번호 - 번호 없으면 먼저 지어야될게 없는 것 -1로 구분
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1]; // 진입 차수 배열
        int[] selfBuild = new int[N + 1]; // 자기 자신을 짓는 데 걸리는 시간 배열

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken()); // 건물 짓는데 걸리는 시간

            while (true) { // 인접 리스트 초기화
                int preTemp = Integer.parseInt(st.nextToken());
                if (preTemp == -1) {
                    break;
                }
                A.get(preTemp).add(i);
                indegree[i]++; // 진입 차수 배열 초기화
            }
        }

        // 위상정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : A.get(now)) {
                indegree[next]--;
                // 시간 업데이트
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
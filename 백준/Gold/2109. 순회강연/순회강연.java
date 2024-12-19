import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {

            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }

            return o2[0] - o1[0];
        });

        int max = 0;

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            max = Math.max(max, day);

            q.add(new int[]{value, day});
        }

        int answer = 0;
        boolean[] visited = new boolean[max + 1];


        while(!q.isEmpty()) {

            int[] arr = q.poll();

            for (int i = arr[1]; i > 0; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer += arr[0];
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}
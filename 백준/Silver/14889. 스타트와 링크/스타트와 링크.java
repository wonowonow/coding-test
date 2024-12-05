import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[] visited;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        visited = new boolean[size];
        arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.print(answer);
    }

    public static void dfs(int depth, int idx) {
        
        if (depth == arr.length / 2) {
            answer = Math.min(answer, getStats());
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static int getStats() {
        int firstTeam = 0;
        int secondTeam = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (visited[i] && visited[j]) {
                    firstTeam += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    secondTeam += arr[i][j] + arr[j][i];
                }
            }
        }
        return Math.abs(firstTeam - secondTeam);
    }
}
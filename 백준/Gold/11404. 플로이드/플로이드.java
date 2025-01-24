import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        int[][] cost = new int[city][city];

        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (i != j) {
                    cost[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], value);
        }

        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                for (int k = 0; k < city; k++) {
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                }
            }
        }

        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                System.out.print(cost[i][j] == Integer.MAX_VALUE / 2 ? 0 : cost[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

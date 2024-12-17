import java.util.*;

public class Main {
    
    static int max;
    static int n;
    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        max = sc.nextInt();

        arr = new int[max];
        dfs(1, 0);
    }

    public static void dfs(int now, int depth) {

        if (depth == max) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = now; i <= n; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
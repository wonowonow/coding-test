import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int computers = sc.nextInt();
        int graph = sc.nextInt();
        arr = new ArrayList[computers];
        visited = new boolean[computers];

        for (int i = 0; i < computers; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph; i++) {

            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            arr[x].add(y);
            arr[y].add(x);
        }

        solution(0);
        int answer = 0;
        for (int i = 1; i < visited.length; i++) {

            if (visited[i]) {
                answer++;
            }
        }

        System.out.println(answer);;
    }

    public static void solution(int me) {

        visited[me] = true;
        int size = arr[me].size();
        for (int i = 0; i < size; i++) {
            if (!visited[arr[me].get(i)]) {
                solution(arr[me].get(i));
            }
        }
    }
}

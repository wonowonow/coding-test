import java.util.*;

public class Main {
    
    static int[] inDgree;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 학생 수
        int M = sc.nextInt(); // 키를 비교한 횟수

        inDgree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            // a는 b앞에 서야한다!
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            // 진입 차수 증가
            inDgree[b]++;
        }

        // 위상 정렬 bfs 로 구현해보장
        bfs();

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }

    public static void bfs() {

        Queue<Integer> q = new LinkedList<>();

        // 0인 애들 싹 다!!
        for (int i = 1; i < inDgree.length; i++) {
            if (inDgree[i] == 0) {
                q.add(i);
                answer.add(i);
            }
        }

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int next : list.get(now)) {

                // 진입 차수 감소
                inDgree[next]--;

                if (inDgree[next] == 0) {
                    q.add(next);
                    answer.add(next);
                }
            }
        }
    }
}
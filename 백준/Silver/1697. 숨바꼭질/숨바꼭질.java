import java.util.*;

public class Main {
    
    static boolean[] visited = new boolean[100001];
    
    public static void main(String[] args) {
        // X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
        // 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        int answer = bfs(start, end);
        
        System.out.print(answer - 1);
    }
    
    public static int bfs(int start, int end) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            cnt++;
            for (int i = 0; i < qSize; i++) {
                int num = q.poll();
                
                if (num == end) {
                    return cnt;
                }
                
                int[] nexts = {num - 1, num + 1, num * 2};
                
                for (int next : nexts) {
                    if (next >= 0 && next < 100001 && !visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}
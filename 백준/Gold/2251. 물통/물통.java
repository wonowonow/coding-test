import java.util.*;

public class Main {
    
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static int[] now;
    static boolean[][] visited;
    static boolean[] answer;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        
        visited = new boolean[201][201];
        answer = new boolean[201];
        
        bfs();
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }
    
    public static void bfs() {
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        
        while (!q.isEmpty()) {
            AB ab = q.poll();
            int A = ab.A;
            int B = ab.B;
            int C = now[2] - A - B;
            
            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                
                if (next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }
                
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class AB {
        int A;
        int B;
        
        public AB(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}
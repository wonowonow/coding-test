import java.util.*;

public class Main {
    
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int max = sc.nextInt();
        int now = sc.nextInt();
        int target = sc.nextInt();
        int up = sc.nextInt();
        int down = sc.nextInt();
        visited = new boolean[max + 1];
        int answer = bfs(max, now, target, up, down);
        if (answer == -1) {
            System.out.print("use the stairs");
        } else {
            System.out.print(answer);
        }
    }
    
    public static int bfs(int max, int now, int target, int up, int down) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        visited[now] = true;
        int answer = 0;
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            
            for (int i = 0; i < qSize; i++) {
                int floor = q.poll();
                
                if (floor == target) {
                    return answer;
                }
                
                int[] nextFloors = {floor + up, floor - down};
                
                for (int nextFloor : nextFloors) {
                    if (nextFloor > 0 && nextFloor <= max && !visited[nextFloor]) {
                        q.add(nextFloor);
                        visited[nextFloor] = true;
                    }
                }
            }
            
            answer++;
        }
        
        return -1;
    }
}
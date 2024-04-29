import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        List<Integer> picture = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        
        int[][] arr = new int[y][x];
        
        for (int i = 0; i < y; i++) {
            
            for (int j = 0; j < x; j++) {
                
                arr[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < y; i++) {
            
            for (int j = 0; j < x; j++) {
                
                if (arr[i][j] == 1) {
                    picture.add(bfs(new Node(j, i), arr));
                }
            }
        }
        
        int max = 0;
        for (int num : picture) {
            max = Math.max(num, max);
        }
        
        System.out.println(picture.size());
        System.out.println(max);
    }
    
    public static int bfs(Node node, int[][] arr) {
        int size = 1;
        Queue<Node> q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        q.add(node);
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node n = q.poll();
                arr[n.y][n.x] = 999;
            
                for (int j = 0; j < 4; j++) {
                    int nx = n.x + dx[j];
                    int ny = n.y + dy[j];
                    
                    if (ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[0].length) {
                        if (arr[ny][nx] == 1) {
                            size++;
                            arr[ny][nx] = 999;
                            q.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
        
        return size;
    }
}

class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
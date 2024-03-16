import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        int maxX = maps[0].length;
        int maxY = maps.length;
        
        int[][] joystick = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[maxY][maxX];
        Queue<Node> nodeQ = new LinkedList<>();
        
        nodeQ.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!nodeQ.isEmpty()) {
            Node node = nodeQ.poll();
            
            if (node.x == maxX-1 && node.y == maxY-1) {
                answer = node.count;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + joystick[i][0];
                int nextY = node.y + joystick[i][1];
                
                if (nextX <= maxX - 1 && nextY <= maxY -1 && nextX >= 0 && nextY >= 0 && !visited[nextY][nextX] && maps[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    nodeQ.add(new Node(nextX, nextY, node.count + 1));
                }
            }
        }
        
        return answer;
    }
    
    class Node {
        
        int x;
        int y;
        int count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
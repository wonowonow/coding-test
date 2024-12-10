import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] team;
    static ArrayList<Integer> teamScore = new ArrayList<>();
    static int xSize, ySize;
    
    
    public int solution(int[][] land) {
        xSize = land.length;
        ySize = land[0].length;
        visited = new boolean[xSize][ySize];
        team = new int[xSize][ySize];
        int teamNumber = 1;
        
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    teamScore.add(dfs(1, i, j, land, teamNumber));
                    teamNumber++;
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < ySize; i++) {
            int sum = 0;
            boolean[] check = new boolean[teamNumber];
            for (int j = 0; j < xSize; j++) {
                int t = team[j][i];
                if (t != 0 && !check[t]) {
                    sum += teamScore.get(t - 1);
                    check[t] = true;
                    continue;
                }
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    public int dfs(int cnt, int x, int y, int[][] land, int teamNumber) {
        
        team[x][y] = teamNumber;
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if (nx < 0 || ny < 0 || nx >= xSize || ny >= ySize) {
                continue;
            }
            
            if (visited[nx][ny] || land[nx][ny] == 0) {
                continue;
            }
            
            cnt = dfs(cnt + 1, nx, ny, land, teamNumber);
        }
        
        
        return cnt;
    }
}
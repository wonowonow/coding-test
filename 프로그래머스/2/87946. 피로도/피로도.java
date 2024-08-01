class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        
        for (int i = 0; i < dungeons.length; i++) {
            visited = new boolean[dungeons.length];
            visited[i] = true;
            bfs(k - dungeons[i][1], i, 1, dungeons);
            System.out.println("==================");
        }
        
        return answer;
    }
    
    public void bfs(int k, int cur, int cnt, int[][] dungeons) {
        
        if (cnt > dungeons.length) {
            return;
        }
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < dungeons.length; i++) {
            
            if (!visited[i] && k - dungeons[i][0] >= 0) {
                
                visited[i] = true;
                
                bfs(k - dungeons[i][1], i, cnt + 1, dungeons);
                
                visited[i] = false;
            }
        }
    }
}
import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static TeamAndCnt[][] remember;
    static int teamCnt = 0;
    
    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        remember = new TeamAndCnt[land.length][land[0].length];
        
        for (int i = 0; i < land[0].length; i++) {
            
            visited = new boolean[land.length][land[0].length];
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            int t = -1;
            
            for (int j = 0; j < land.length; j++) {
                
                if (land[j][i] == 1 && !visited[j][i]) {
                    list.add(bfs(land, i, j));
                }
                
                if (remember[j][i] != null && remember[j][i].cnt > 0 && !visited[j][i]) {
                    
                    if (t == remember[j][i].team) {
                        continue;
                    }
                    t = remember[j][i].team;
                    list.add(remember[j][i].cnt);
                }
                
            }
            
            for (int num : list) {
                sum += num;
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    public int bfs(int[][] land, int x, int y) {
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        Queue<NodeTeam> rq = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Node(x, y));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        while(!q.isEmpty()) {
            
            Node now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx >= 0 && nx < land[0].length && ny >= 0 && ny < land.length && land[ny][nx] == 1 && !visited[ny][nx]) {
                    q.add(new Node(nx, ny));
                    rq.add(new NodeTeam(new Node(nx, ny), teamCnt));
                    visited[ny][nx] = true;
                    cnt++;
                }
            }
        }
        
        while(!rq.isEmpty()) {
            NodeTeam nodeTeam = rq.poll();
            Node node = nodeTeam.node;
            remember[node.y][node.x] = new TeamAndCnt(teamCnt, cnt);
        }
        
        teamCnt++;
        
        return cnt;
    }
    
    class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    class NodeTeam {
        Node node;
        int team;
        
        public NodeTeam(Node node, int team) {
            this.node = node;
            this.team = team;
        }
    }
    
    class TeamAndCnt {
        int team;
        int cnt;
        
        public TeamAndCnt(int team, int cnt) {
            this.team = team;
            this.cnt = cnt;
        }
    }
}
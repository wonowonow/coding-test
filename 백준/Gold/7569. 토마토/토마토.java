import java.util.*;

public class Main {
    
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[][][] box;
    static boolean[][][] visited;
    static int xSize;
    static int ySize;
    static int zSize;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        xSize = sc.nextInt();
        ySize = sc.nextInt();
        zSize = sc.nextInt();
        boolean check = false;

        visited = new boolean[zSize][ySize][xSize];
        box = new int[zSize][ySize][xSize];

        for (int i = 0; i < zSize; i++) {
            for (int j = 0; j < ySize; j++) {
                for (int k = 0; k < xSize; k++) {
                    box[i][j][k] = sc.nextInt();
                    if (box[i][j][k] == 1) {
                        q.add(new Node(k, j, i));
                    }
                }
            }
        }

        bfs();
        int max = 0;

        for (int i = 0; i < zSize; i++) {
            for (int j = 0; j < ySize; j++) {
                for (int k = 0; k < xSize; k++) {
                    if (box[i][j][k] == 0) {
                        check = true;
                    } else {
                        max = Math.max(box[i][j][k], max);
                    }
                }
            }
        }

        if (check) {
            System.out.print(-1);
        } else {
            System.out.print(max - 1);
        }

    }

    public static void bfs() {

        while(!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Node node = q.poll();

                for (int j = 0; j < 6; j++) {
                    int nowDays = box[node.z][node.y][node.x];
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    int nz = node.z + dz[j];

                    if (nx >= 0 && nx < xSize && 
                        ny >= 0 && ny < ySize && 
                        nz >= 0 && nz < zSize &&
                        !visited[nz][ny][nx] && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = nowDays + 1;
                        q.add(new Node(nx, ny, nz));
                        visited[nz][ny][nx] = true;
                    }
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
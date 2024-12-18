import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] board;
    
    static int[][][] tetromino = {
        {{0, 1}, {0, 2}, {0, 3}}, // bar
        {{1, 0}, {2, 0}, {3, 0}}, // bar
        
        {{0, 1}, {1, 0}, {1, 1}}, // square
        
        {{1, 0}, {1, -1}, {2, -1}}, // zigzag
        {{0, 1}, {1, 1}, {1, 2}}, // zigzag
        {{1, 0}, {1, 1}, {2, 1}}, // zigzag
        {{0, 1}, {-1, 1}, {-1, 2}}, // zigzag
        
        {{0, 1}, {0, 2}, {1, 1}}, // mountain ㅜ
        {{1, 0}, {2, 0}, {1, 1}}, // mountain ㅏ
        {{0, 1}, {0, 2}, {-1, 1}}, // mountain ㅗ
        {{1, 0}, {2, 0}, {1, -1}}, // mountain ㅓ
        
        {{1, 0}, {2, 0}, {2, 1}}, // L
        {{0, 1}, {0, 2}, {-1, 2}}, // L
        {{0, 1}, {1, 1}, {2, 1}}, // L
        {{-1, 0}, {-1, 1}, {-1, 2}}, // L
        {{1, 0}, {2, 0}, {2, -1}}, // L
        {{1, 0}, {1, 1}, {1, 2}}, // L
        {{0, -1}, {1, -1}, {2, -1}}, // L
        {{0, 1}, {0, 2}, {1, 2}}, // L
    };
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        board = new int[y][x];
        
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                for (int[][] shape : tetromino) {
                    answer = Math.max(answer, calculateSum(i, j, shape, x, y));
                }
            }
        }
        
        System.out.print(answer);
    }
    
    public static int calculateSum(int startY, int startX, int[][] shape, int maxX, int maxY) {
        
        int sum = board[startY][startX];
        
        for (int[] move : shape) {
            int ny = startY + move[0];
            int nx = startX + move[1];
            
            if (ny < 0 || ny >= maxY || nx < 0 || nx >= maxX) {
                return 0;
            }
            
            sum += board[ny][nx];
        }
        
        return sum;
    }
}
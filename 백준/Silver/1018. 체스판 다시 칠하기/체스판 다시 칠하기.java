import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        
        char[][] arr = new char[x][y];
        
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= x - 8; i++) {
            
            for (int j = 0; j <= y - 8; j++) {
                answer = Math.min(search(arr, i, j), answer);
            }
        }
        
        System.out.println(answer);
    }
    
    public static int search(char[][] arr, int x, int y) {
        int cnt1 = 0;
        int cnt2 = 0;
        char[][] pattern1 = {{'W', 'B'}, {'B', 'W'}};
        char[][] pattern2 = {{'B', 'W'}, {'W', 'B'}};
        
        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 8; j++) {
                if (arr[x + i][y + j] != pattern1[i % 2][j % 2]) {
                    cnt1++;
                }
                if (arr[x + i][y + j] != pattern2[i % 2][j % 2]) {
                    cnt2++;
                }
            }
        }
        
        return Math.min(cnt1, cnt2);
    }
}
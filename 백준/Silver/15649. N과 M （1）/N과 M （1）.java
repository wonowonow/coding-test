import java.util.*;

public class Main {
    
    static boolean[] visited;
    static int[] result;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int max = sc.nextInt();
        int number = sc.nextInt();
        
        visited = new boolean[max + 1];
        result = new int[number];
        
        backTracking(max, number, 0);
        
    }
    
    public static void backTracking(int max, int number, int row) {
        
        if (row == number) {
            
            for (int i = 0; i < number; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 1; i <= max; i++) {
            
            if (!visited[i]) {
                visited[i] = true;
                result[row] = i;
                backTracking(max, number, row + 1);
                visited[i] = false; // 해제
            }
        }
        
    }
}
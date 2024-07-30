import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int[][] arr = new int[x][y];
        
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + sc.nextInt() + " ");
            }
            
            System.out.print("\n");
        }
    }
}
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        
        for (int i = 0; i < size; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            
            int floor = (N - 1) % H + 1;
            int endNum = (N - 1) / H + 1;
            
            System.out.printf("%d%02d\n", floor, endNum);
        }
    }
}
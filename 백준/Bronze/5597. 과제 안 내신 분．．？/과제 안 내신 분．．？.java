import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean[] visited = new boolean[31];
        for (int i = 0; i < 28; i++) {
            visited[sc.nextInt()] = true;
        }
        
        for (int i = 1; i <= 30; i++) {
            if (!visited[i]) {
                System.out.println(i);
            }
        }
    }
}
import java.util.*;

public class Main {
    
    static int[] parent;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        parent = new int[N];
        
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < N; i++) {
            
            for (int j = 0; j < N; j++) {
                
                int question = sc.nextInt();
                
                if (question == 1) {
                    union(i, j);
                }
            }
        }
        
        int target = find(sc.nextInt() - 1);
        boolean success = true;
        for (int i = 0; i < M - 1; i++) {
            if (target != find(sc.nextInt() - 1)) {
                success = false;
            }
        }
        
        if (success) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
    
    public static void union(int a, int b) {
        
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public static int find(int a) {
        
        if (parent[a] == a) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }
}
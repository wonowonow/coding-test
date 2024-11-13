import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int problem = sc.nextInt();
        
        for (int i = 0; i < problem; i++) {
            int size = sc.nextInt();
            sc.nextLine();
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < size; j++) {
                
                String str = sc.nextLine().split(" ")[1];
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            
            int answer = 1;
            
            for (String key : map.keySet()) {
                int value = map.get(key);
                
                answer *= value + 1;
            }
            
            System.out.println(answer - 1);
        }
    }
}
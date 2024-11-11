import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 'a'; i <= 'z'; i++) {
            map.put((char)i, 0);
        }
        
        int cnt = sc.nextInt();
        
        for (int i = 0; i < cnt; i++) {
            char first = sc.next().charAt(0);
            
            map.put(first, map.get(first) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char key : map.keySet()) {
            
            int value = map.get(key);
            if (value >= 5) {
                
                sb.append(key);
            }
        }
        
        if (sb.length() == 0) {
            System.out.print("PREDAJA");
        } else {
            System.out.print(sb.toString());
        }
    }
}
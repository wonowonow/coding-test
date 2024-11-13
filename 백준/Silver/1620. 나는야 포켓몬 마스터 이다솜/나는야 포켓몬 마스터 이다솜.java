import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int problem = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        
        for (int i = 1; i <= size; i++) {
            String str = sc.nextLine();
            
            map1.put(str, i);
            map2.put(i, str);
        }
        
        for (int i = 0; i < problem; i++) {
            String str = sc.nextLine();
            
            if (isNum(str)) {
                System.out.println(map2.get(Integer.parseInt(str)));
            } else {
                System.out.println(map1.get(str));
            }
        }
    }
    
    public static boolean isNum(String str) {
        
        return str.matches("^[0-9]+$");
    }
}
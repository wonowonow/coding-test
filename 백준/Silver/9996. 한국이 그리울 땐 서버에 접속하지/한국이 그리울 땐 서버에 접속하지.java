import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int cnt = sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split("\\*");
        
        for (int i = 0; i < cnt; i++) {
            
            String word = sc.nextLine();
            
            if (checking(word, arr[0], arr[1])) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
    
    public static boolean checking(String word, String first, String end) {
        
        if (word.length() < first.length() + end.length()) {
            return false;
        }
        
        if (!word.startsWith(first)) {
            return false;
        }
        
        if (!word.endsWith(end)) {
            return false;
        }
        
        return true;
    }
}
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        for (char c : str.toCharArray()) {
            
            if (Character.isLowerCase(c)) {
                System.out.print(Character.toUpperCase(c));
            } else {
                System.out.print(Character.toLowerCase(c));
            }
        }
    }
}
import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        for (char c : str.toCharArray()) {
            
            if (isLowerAlphabet(c)) {
                c += 13;
                if (c > 'z') {
                    c -= 26;
                } 
            }
            
            if (isUpperAlphabet(c)) {
                c += 13;
                if (c > 'Z') {
                    c -= 26;
                }
            }
            
            System.out.print(c);
        }
    }
    
    public static boolean isLowerAlphabet(char c) {
        return 'a' <= c && c <= 'z';
    }
    
    public static boolean isUpperAlphabet(char c) {
        return 'A' <= c && c <= 'Z';
    }
}
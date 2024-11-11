import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        
        int cnt = sc.nextInt();
        
        for (int i = 0; i < cnt; i++) {
            int first = sc.next().charAt(0) - 'a';
            arr[first]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 5) {
                sb.append((char)(i + 'a'));
            }
        }
        
        if (sb.length() == 0) {
            System.out.print("PREDAJA");
        } else {
            System.out.print(sb.toString());
        }
    }
}
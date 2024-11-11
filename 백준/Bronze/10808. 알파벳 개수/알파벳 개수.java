import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        
        String word = sc.nextLine();
        
        for (char c : word.toCharArray()) {
            arr[c - 97]++;
        }
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
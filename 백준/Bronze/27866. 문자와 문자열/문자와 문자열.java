import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int target = sc.nextInt();
        
        System.out.print(str.charAt(target - 1));
    }
}
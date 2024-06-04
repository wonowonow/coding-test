import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.trim().split(" ");
        
        if (str.equals(" ")) {
            System.out.print(0);
        } else {
            System.out.print(arr.length);
        }
    }
}
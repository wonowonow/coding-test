import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[] numbers = new int[8];
        for (int i = 0; i < 8; i++) {
            numbers[i] = sc.nextInt();
        }
        
        boolean ascending = true;
        boolean descending = true;
        
        for (int i = 0; i < 7; i++) {
            if (numbers[i] < numbers[i + 1]) {
                descending = false;
            } else if (numbers[i] > numbers[i + 1]) {
                ascending = false;
            }
        }
        
        if (ascending) {
            System.out.println("ascending");
        } else if (descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
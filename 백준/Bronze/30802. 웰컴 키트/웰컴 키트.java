import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tshirt = 0;
        int pens = 0;
        int pen = 0;
        
        int[] arr = new int[6];
        
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }
        
        int t = sc.nextInt();
        int p = sc.nextInt();
        
        for (int i : arr) {
            tshirt += (i + t - 1) / t;
        }
        
        pens = n / p;
        pen = n % p;
        
        System.out.print(tshirt + "\n" + pens + " " + pen);
        
    }
}
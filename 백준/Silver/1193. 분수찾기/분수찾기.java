import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        
        int crossCnt = 1;
        int crossSum = 0;
        
        while (true) {
            
            if (q <= crossCnt + crossSum) {
                
                if (crossCnt % 2 == 1) {
                    System.out.print((crossCnt - (q - crossSum - 1)) + "/" + (q - crossSum));
                    break;
                } else {
                    System.out.print((q - crossSum) + "/" + (crossCnt - (q - crossSum - 1)));
                    break;
                }
                
            } else {
                crossSum += crossCnt;
                crossCnt++;
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[Integer.parseInt(br.readLine())];

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 0; i < A.length - 1; i++) {
            
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
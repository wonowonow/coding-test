import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        for(int i = 1; i <= a; i++) {
            int space = a - i;
            System.out.println(" ".repeat(space) + "*".repeat(i));
        }
    }
}
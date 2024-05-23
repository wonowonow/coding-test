import java.util.Scanner;

public class Main {

    private static int[] arr;
    private static int[] tmp;
    private static long cnt;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        arr = new int[size];
        tmp = new int[size];
        cnt = 0;

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(0, size - 1);

        System.out.print(cnt);
    }

    public static void mergeSort(int l, int r) {

        if (l < r) {

            int m = l + (r - l) / 2;

            mergeSort(l, m);
            mergeSort(m + 1, r);

            merge(l, m, r);
        }
    }

    public static void merge(int l, int m, int r) {

        for (int i = l; i <= r; i++) {
            tmp[i] = arr[i];
        }

        int k = l;
        int lI = l;
        int rI = m + 1;

        while (lI <= m && rI <= r) {

            if (tmp[lI] <= tmp[rI]) {
                arr[k] = tmp[lI];
                lI++;
            } else {
                cnt = cnt + rI - k;
                arr[k] = tmp[rI];
                rI++;
            }
            k++;
        }

        while (lI <= m) {
            arr[k] = tmp[lI];
            k++;
            lI++;
        }

        while (rI <= r) {
            arr[k] = tmp[rI];
            k++;
            rI++;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        board = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(answer);
    }

    public static void dfs(int depth, int[][] arr) {

        if (depth == 5) {
            recMax(arr);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] copyArr = arrCopy(arr);

            if (i == 0) {
                dfs(depth + 1, down(copyArr));
            } else if (i == 1) {
                dfs(depth + 1, up(copyArr));
            } else if (i == 2) {
                dfs(depth + 1, left(copyArr));
            } else {
                dfs(depth + 1, right(copyArr));
            }
        }
    }

    public static int[][] down(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {

            int cursor = arr.length - 1;

            for (int j = arr.length - 1; j >= 0; j--) {

                if (arr[j][i] != 0) {
                    int tmp = arr[j][i];
                    arr[j][i] = 0;
                    if (arr[cursor][i] == 0) {
                        arr[cursor][i] = tmp;
                    } else if (arr[cursor][i] == tmp) {
                        arr[cursor][i] *= 2;
                        cursor--;
                    } else {
                        cursor--;
                        arr[cursor][i] = tmp;
                    }
                }
            }
        }

        return arr;
    }

    public static int[][] up(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {

            int cursor = 0;

            for (int j = 0; j < arr.length; j++) {

                if (arr[j][i] != 0) {
                    int tmp = arr[j][i];
                    arr[j][i] = 0;
                    if (arr[cursor][i] == 0) {
                        arr[cursor][i] = tmp;
                    } else if (arr[cursor][i] == tmp) {
                        arr[cursor][i] *= 2;
                        cursor++;
                    } else {
                        cursor++;
                        arr[cursor][i] = tmp;
                    }
                }
            }
        }
        return arr;
    }

    public static int[][] left(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {

            int cursor = 0;

            for (int j = 0; j < arr.length; j++) {

                if (arr[i][j] != 0) {
                    int tmp = arr[i][j];
                    arr[i][j] = 0;
                    if (arr[i][cursor] == 0) {
                        arr[i][cursor] = tmp;
                    } else if (arr[i][cursor] == tmp) {
                        arr[i][cursor] *= 2;
                        cursor++;
                    } else {
                        cursor++;
                        arr[i][cursor] = tmp;
                    }
                }
            }
        }
        return arr;
    }

    public static int[][] right(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {

            int cursor = arr.length - 1;

            for (int j = arr.length - 1; j >= 0; j--) {

                if (arr[i][j] != 0) {
                    int tmp = arr[i][j];
                    arr[i][j] = 0;
                    if (arr[i][cursor] == 0) {
                        arr[i][cursor] = tmp;
                    } else if (arr[i][cursor] == tmp) {
                        arr[i][cursor] *= 2;
                        cursor--;
                    } else {
                        cursor--;
                        arr[i][cursor] = tmp;
                    }
                }
            }
        }
        return arr;
    }

    public static int[][] arrCopy(int[][] arr) {
        int[][] tmp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    public static void recMax(int[][] arr) {
        for (int[] a : arr) {
            for (int num : a) {
                answer = Math.max(answer, num);
            }
        }
    }
}

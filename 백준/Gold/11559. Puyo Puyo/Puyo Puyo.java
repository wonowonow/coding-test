import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static String[][] arr;
    static Set<String> puyos;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean isBoomed = true;

    public static void main(String[] args) throws IOException {

        puyos = Arrays.stream(new String[]{"R", "G", "B", "P", "Y"}).collect(Collectors.toSet());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[12][6];
        int answer = 0;

        for (int i = 0; i < 12; i++) {
            String[] scan = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scan[j];
            }
        }


        while (isBoomed) {
            isBoomed = false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && puyos.contains(arr[i][j])) {
                        List<int[]> group = new ArrayList<>();
                        dfs(i, j, arr[i][j], group);

                        if (group.size() >= 4) {
                            isBoomed = true;
                            for (int[] pos : group) {
                                arr[pos[0]][pos[1]] = ".";
                            }
                        }
                    }
                }
            }
            if (isBoomed) {
                down();
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static void down() {
        boolean moved = true;

        while (moved) {
            moved = false;
            for (int i = arr.length - 1; i > 0; i--) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j].equals(".") && !arr[i - 1][j].equals(".")) {
                        arr[i][j] = arr[i - 1][j];
                        arr[i - 1][j] = ".";
                        moved = true;
                    }
                }
            }
        }
    }

    public static void dfs(int y, int x, String pu, List<int[]> group) {

        visited[y][x] = true;
        group.add(new int[]{y, x});

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6 || visited[ny][nx]) {
                continue;
            }

            if (arr[ny][nx].equals(pu)) {
                dfs(ny, nx, pu, group);
            }
        }
    }
}

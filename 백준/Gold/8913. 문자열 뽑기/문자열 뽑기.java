import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            System.out.println(solution(br.readLine()) ? 1 : 0);
            visited.clear();
        }
    }

    private static boolean solution(String str) {

        if (str.isEmpty()) {
            return true;
        }
        if (visited.contains(str)) {
            return false;
        }

        visited.add(str);
        int length = str.length();

        for (int i  = 0 ; i < length ; i++) {
            int j = i;

            while (j < length && str.charAt(j) == str.charAt(i)) {
                j++;
            }

            if (j - i >= 2) {
                StringBuilder next = new StringBuilder(str);
                next.delete(i, j);
                if (solution(next.toString())) {
                    return true;
                }
            }
        }

        return false;
    }
}

import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("all")) {
                set = new HashSet<>(Arrays.asList(arr));
                continue;
            } else if (command.equals("empty")) {
                set.clear();
                continue;
            }
            
            int number = Integer.parseInt(st.nextToken());
            
            if (command.equals("check")) {
                sb.append(set.contains(number) ? 1 : 0);
                sb.append("\n");
            } else if (command.equals("add")) {
                set.add(number);
            } else if (command.equals("remove") && set.contains(number)) {
                set.remove(number);
            } else if (command.equals("toggle")) {
                if (set.contains(number))
                    set.remove(number);
                else
                    set.add(number);
            }
        }
        
        System.out.println(sb.toString());
    }
}
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        // 현재 가능한 사람 중에서 가장 적은 Value 를 구하면 된다.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        
        int days = 0;
        
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            if (days < arr[0]) {
                days = arr[0];
                q.add(arr);
            } else {
                days += arr[1];
            }
        }
        
        System.out.println(days);
        
    }
}
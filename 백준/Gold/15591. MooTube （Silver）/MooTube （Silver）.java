import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<HashMap<Integer, ArrayList<Integer>>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodes = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= nodes; i++) {
            list.add(new HashMap<Integer, ArrayList<Integer>>());
        }

        for (int i = 0; i < nodes - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            HashMap<Integer, ArrayList<Integer>> mapP = list.get(p);
            if (!mapP.containsKey(r)) {
                mapP.put(r, new ArrayList<>());
            }
            mapP.get(r).add(q);

            HashMap<Integer, ArrayList<Integer>> mapQ = list.get(q);
            if (!mapQ.containsKey(r)) {
                mapQ.put(r, new ArrayList<>());
            }
            mapQ.get(r).add(p);
        }

        for (int i = 0; i < question; i++) {
            st = new StringTokenizer(br.readLine());
            int usado = Integer.parseInt(st.nextToken());
            int video = Integer.parseInt(st.nextToken());
            visited = new boolean[nodes + 1];
            visited[video] = true;

            System.out.println(getSize(video, usado));
        }

    }

    public static int getSize(int video, int usado) {

        int answer = 0;
        HashMap<Integer, ArrayList<Integer>> map = list.get(video);

        for (Integer key : map.keySet()) {

            if (key < usado) {
                continue;
            }

            for (int next : map.get(key)) {

                if (!visited[next]) {
                    visited[next] = true;
                    answer += 1;
                    answer += getSize(next, usado);
                }
            }
        }

        return answer;
    }
}

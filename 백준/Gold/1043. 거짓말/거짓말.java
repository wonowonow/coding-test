import java.util.*;
import java.io.*;

public class Main {
    
    static int[] parent;
    static int[] knows;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int peopleCnt = Integer.parseInt(st.nextToken()); // 총 인구 수
        int partyCnt = Integer.parseInt(st.nextToken()); // 총 파티 수
        parent = new int[peopleCnt + 1]; // union을 위한 배열 초기화
        for (int i = 1; i <= peopleCnt; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken()); // 아는 사람 수
        knows = new int[knowCnt]; // 아는 사람 배열
        for (int i = 0; i < knowCnt; i++) { // 아는 사람 배열 초기화
            knows[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] listArr = new ArrayList[partyCnt]; // 파티 배열
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < partyCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int partyPeopleCnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < partyPeopleCnt; j++) {
                int peopleNum = Integer.parseInt(st.nextToken());
                listArr[i].add(peopleNum);
            }

            int firstPeople = listArr[i].get(0);

            for (int j = 1; j < partyPeopleCnt; j++) {
                union(firstPeople, listArr[i].get(j));
            }
        }

        for (int i = 0; i < partyCnt; i++) {
            boolean theyKnow = false;
            int now = listArr[i].get(0);

            for (int know : knows) {

                if (find(now) == find(know)) {
                    theyKnow = true;
                }

            }

            if (!theyKnow) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    public static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {

        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}
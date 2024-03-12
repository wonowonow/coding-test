import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 개수 N / 에지의 개수 M / 시작 번호 V
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            A[S].add(E);
            A[E].add(S);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();
    }
    
    public static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
    
    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            System.out.print(nowNode + " ");
            for (int i : A[nowNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
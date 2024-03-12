import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수의 개수 N과 범위 크기 L이 주어진다.
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> nodeDeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            
            while (!nodeDeque.isEmpty() && nodeDeque.getLast().value > now) {
                nodeDeque.removeLast();
            }
            nodeDeque.addLast(new Node(now, i));
            if (nodeDeque.getFirst().index <= i - L) {
                nodeDeque.removeFirst();
            }
            
            bw.write(nodeDeque.getFirst().value + " ");
        }
        
        bw.flush();
        bw.close();
    }
    
    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
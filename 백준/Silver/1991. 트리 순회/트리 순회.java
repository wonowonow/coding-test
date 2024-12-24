import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        Tree tree = new Tree();
        
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.addNode(left, right, root);
        }
        
        Node root = tree.nodes.get("A");
        
        root.preOrder();
        System.out.println();
        root.inOrder();
        System.out.println();
        root.postOrder();
    }
}

class Tree {
    Map<String, Node> nodes;

    public Tree() {
        nodes = new HashMap<>();
    }

    public void addNode(String left, String right, String root) {
        nodes.putIfAbsent(root, new Node(root));
        Node now = nodes.get(root);

        if (!left.equals(".")) {
            nodes.putIfAbsent(left, new Node(left));
            now.left = nodes.get(left);
        }

        if (!right.equals(".")) {
            nodes.putIfAbsent(right, new Node(right));
            now.right = nodes.get(right);
        }
    }
}
    
class Node {
    Node left;
    Node right;
    String name;

    public Node(String name) {
        this.name = name;
    }

    public void preOrder() {
        System.out.print(name);
        if(left != null) left.preOrder();
        if(right != null) right.preOrder();
    }

    public void inOrder() {
        if(left != null) left.inOrder();
        System.out.print(name);
        if(right != null) right.inOrder();
    }

    public void postOrder() {
        if(left != null) left.postOrder();
        if(right != null) right.postOrder();
        System.out.print(name);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1991 {

    static Node tree = new Node('A', null, null);

    static class Node {
        char root;
        Node left;
        Node right;

        Node(char root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(tree, root, left, right);
        }
        preorder(tree);
        System.out.println();
        inorder(tree);
        System.out.println();
        postorder(tree);
    }

    static void insert(Node tree, char root, char left, char right) {
        if (tree.root == root) {
            if (left == '.')
                tree.left = null;
            if (left != '.')
                tree.left = new Node(left, null, null);
            if (right == '.')
                tree.right = null;
            if (right != '.')
                tree.right = new Node(right, null, null);
        } else {
            if (tree.left != null)
                insert(tree.left, root, left, right);
            if (tree.right != null)
                insert(tree.right, root, left, right);
        }
    }

    static void preorder(Node tree) {
        if (tree == null)
            return;
        System.out.print(tree.root);
        preorder(tree.left);
        preorder(tree.right);
    }

    static void inorder(Node tree) {
        if (tree == null)
            return;
        inorder(tree.left);
        System.out.print(tree.root);
        inorder(tree.right);
    }

    static void postorder(Node tree) {
        if (tree == null)
            return;
        postorder(tree.left);
        postorder(tree.right);
        System.out.print(tree.root);
    }
}

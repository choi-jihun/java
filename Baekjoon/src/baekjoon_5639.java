import java.io.*;
import java.util.*;

class Tree {
    int data;
    Tree left, right;

    public Tree(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {
    Tree tree;
    BufferedWriter bw;

    public BinaryTree() {
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void insert(int root) {
        tree = insertTree(tree, root);
    }

    private Tree insertTree(Tree tree, int root) {
        if (tree == null) {
            tree = new Tree(root);
            return tree;
        }
        if (root < tree.data) {
            tree.left = insertTree(tree.left, root);
        } else {
            tree.right = insertTree(tree.right, root);
        }

        return tree;
    }

    public void constructTree(List<Integer> list) {
        for (int data : list) {
            insert(data);
        }
    }

    public void printPostOrder(Tree tree) throws IOException {
        if (tree != null) {
            printPostOrder(tree.left);
            printPostOrder(tree.right);
            bw.write(tree.data + "\n");
        }
    }

    public void postOrder() throws IOException {
        printPostOrder(tree);
        bw.flush();
        bw.close();
    }
}


public class baekjoon_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            list.add(Integer.parseInt(line));
        }

        BinaryTree bTree = new BinaryTree();
        bTree.constructTree(list);
        bTree.postOrder();
    }
}

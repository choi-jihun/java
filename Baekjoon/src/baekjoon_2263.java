import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_2263 {

    static ArrayList<Integer> inOrder = new ArrayList<Integer>();
    static ArrayList<Integer> postOrder = new ArrayList<Integer>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postOrder.add(Integer.parseInt(st.nextToken()));
        }

        makePreOrder(0, N - 1, 0, N - 1);
        bw.write(sb + "");
        bw.flush();
    }

    static void makePreOrder(int inStartIdx, int inEndIdx, int postStartIdx, int postEndIdx) {
        if (inStartIdx > inEndIdx || postStartIdx > postEndIdx) {
            return;
        }

        int root = postOrder.get(postEndIdx);
        sb.append(root).append(" ");

        int rootIdx = inOrder.indexOf(root);
        int leftSubtreeSize = rootIdx - inStartIdx;

        makePreOrder(inStartIdx, rootIdx - 1, postStartIdx, postStartIdx + leftSubtreeSize - 1);
        makePreOrder(rootIdx + 1, inEndIdx, postStartIdx + leftSubtreeSize, postEndIdx - 1);
    }

}

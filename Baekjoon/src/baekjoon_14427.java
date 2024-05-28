import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_14427 {

    static int[] arr;
    static int[] tree;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        tree = new int[(N + 1) * 4];
        arr[0] = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, N, 1);
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                update(1, N, 1, idx, value);
            } else if (q == 2) {
                sb.append(tree[1]).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = start;
        }
        int mid = (start + end) / 2;
        int left = init(start, mid, node * 2);
        int right = init(mid + 1, end, node * 2 + 1);
        return tree[node] = getIndex(left, right);
    }

    static int update(int start, int end, int node, int idx, int val) {
        if (idx < start || idx > end)
            return tree[node];

        if (start == end) {
            arr[idx] = val;
            return tree[node] = idx;
        }

        int mid = (start + end) / 2;
        int left = update(start, mid, node * 2, idx, val);
        int right = update(mid + 1, end, node * 2 + 1, idx, val);
        return tree[node] = getIndex(left, right);
    }

    static int getIndex(int left, int right) {
        if (arr[left] == arr[right])
            return getMin(left, right);
        else if (arr[left] < arr[right])
            return left;
        else
            return right;
    }

    static int getMin(int left, int right) {
        if (left < right) {
            return left;
        } else
            return right;
    }

}

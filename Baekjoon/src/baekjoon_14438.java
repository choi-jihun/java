import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_14438 {
    static int[] arr;
    static int[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        tree = new int[(N + 1) * 4];
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
                int j = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                sb.append(query(1, N, 1, j, k)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    //트리 초기화
    static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        int left = init(start, mid, node * 2);
        int right = init(mid + 1, end, node * 2 + 1);
        return tree[node] = Math.min(left, right);
    }


    //값 업데이트
    //현재 노드는 자식 노드의 최솟값으로
    static int update(int start, int end, int node, int idx, int val) {
        if (idx < start || idx > end)
            return tree[node];

        if (start == end) {
            return tree[node] = arr[idx] = val;
        }

        int mid = (start + end) / 2;
        int left = update(start, mid, node * 2, idx, val);
        int right = update(mid + 1, end, node * 2 + 1, idx, val);
        return tree[node] = Math.min(left, right);
    }

    //i와 j사이에 최소값을 찾는 과정
    //구간 밖이면 Integer.MAX_VALUE 반환
    static int query(int start, int end, int node, int i, int j) {
        if (j < start || i > end)
            return Integer.MAX_VALUE;

        if (i <= start && end <= j)
            return tree[node];

        int mid = (start + end) / 2;
        return Math.min(query(start, mid, node * 2, i, j), query(mid + 1, end, node * 2 + 1, i, j));
    }
}

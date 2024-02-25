import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_15664 {

    static int N, M;
    static int[] arr;
    static int[] select;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        select = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int idx, int depth) {
        if (depth == M) {
            for (int num : select) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastUsed = -1;
        for (int i = idx; i < N; i++) {
            if (lastUsed != arr[i]) {
                select[depth] = arr[i];
                dfs(i + 1, depth + 1);
                lastUsed = arr[i];
            }
        }
    }
}

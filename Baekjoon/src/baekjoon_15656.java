import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_15656 {
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

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        select = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int idx) {
        if (idx == M) {
            for (int num : select) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            select[idx] = arr[i];
            dfs(idx + 1);
        }

    }
}

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_14225 {

    static int[] arr;
    static boolean[] visited = new boolean[20 * 100000 + 10];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        int ans = 1;
        while (visited[ans]) {
            ans++;
        }
        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            visited[sum] = true;
            return;
        }

        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}

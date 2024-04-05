import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_11051 {

    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= Math.min(n, K); k++) {
                dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k]) % MOD;
            }
        }

        bw.write(String.valueOf(dp[N][K]));
        bw.flush();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1890 {
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] > 0) {
                    if (map[i][j] > 0) {
                        int dx = i + map[i][j];
                        int dy = j + map[i][j];
                        if (dx < N)
                            dp[dx][j] += dp[i][j];
                        if (dy < N)
                            dp[i][dy] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}

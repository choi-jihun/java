import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_9465 {
    public static void main(String[] args) throws IOException {
        int[][] sticker;
        int[][] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sticker = new int[2][n + 1];
            dp = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n + 1; j++)
                    sticker[i][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            for (int i = 2; i < n + 1; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}

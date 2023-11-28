import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] health = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] happy = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][100];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 100; j++) {
                if (j >= health[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - health[i]] + happy[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][99]);
    }
}

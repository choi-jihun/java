import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_14495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 3) {
            System.out.println(1);
        } else {
            long[] dp = new long[N + 1];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i < N + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 3];
            }
            System.out.println(dp[N]);
        }
    }
}

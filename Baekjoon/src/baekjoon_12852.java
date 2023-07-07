import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 2; i < N + 1; i++) {
            if (i == 2 || i == 3) {
                dp[i] = 1;
                continue;
            }
            int min = dp[i - 1] + 1;

            if (i % 3 == 0)
                min = Math.min(min, dp[i / 3] + 1);
            if (i % 2 == 0)
                min = Math.min(min, dp[i / 2] + 1);

            dp[i] = min;
        }

        System.out.println(dp[N]);
        System.out.print(N+ " ");

        while (N > 1) {
            int min = dp[N - 1];
            int temp = N - 1;

            if (N % 3 == 0 && dp[N / 3] < min) {
                min = dp[N / 3];
                temp = N / 3;
            }
            if (N % 2 == 0 && dp[N / 2] < min) {
                min = dp[N / 2];
                temp = N / 2;
            }

            N = temp;
            System.out.print(N + " ");
        }
    }
}

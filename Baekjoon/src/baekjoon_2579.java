import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 2];
        int[] dp = new int[n + 2];
        for (int i = 1; i < n + 1; i++)
            stair[i] = Integer.parseInt(br.readLine());
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        for (int i = 3; i < n + 1; i++)
            dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];

        System.out.println(dp[n]);
    }
}

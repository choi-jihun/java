import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            card[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N + 1; i++)
            for (int j = 1; j <= i; j++)
                dp[i] = Math.max(dp[i], card[j] + dp[i - j]);
        System.out.println(dp[N]);
    }
}

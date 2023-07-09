import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            dp[i] = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int ans = 1;

        for (int i = 0; i < N - 1; i++) {
            if (dp[i] <= dp[i + 1])
                cnt++;
            else
                cnt = 1;
            ans = Math.max(ans, cnt);
        }

        int cnt2 = 1;
        for (int i = 0; i < N - 1; i++) {
            if (dp[i] >= dp[i + 1])
                cnt2++;
            else
                cnt2 = 1;
            ans = Math.max(ans, cnt2);
        }

        System.out.println(ans);
    }

}

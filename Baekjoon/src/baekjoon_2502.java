import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[D];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < D; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        for (int A = 1; A < K + 1; A++) {
            for (int B = A; B < K + 1; B++) {
                int total = dp[D - 3] * A + dp[D - 2] * B;
                if (total == K) {
                    System.out.println(A);
                    System.out.println(B);
                    return;
                }
            }
        }
    }
}

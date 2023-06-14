import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_24416 {

    static int recCnt = 0;
    static int dpCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        recursiveFibo(N);
        dpFibo(N);

        System.out.print(recCnt + " " + dpCnt);
    }

    static int recursiveFibo(int n) {
        if (n == 1 || n == 2) {
            recCnt++;
            return 1;
        }
        return recursiveFibo(n - 1) + recursiveFibo(n - 2);
    }

    static int dpFibo(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dpCnt++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}

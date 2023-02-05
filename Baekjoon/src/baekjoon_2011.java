import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long[] dp = new long[str.length() + 1];
        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != '0'){
                dp[i + 1] += dp[i];
                dp[i + 1] %= 1000000;
            }

            if (str.charAt(i - 1) != '0'){
                if (str.charAt(i) <= '6' && str.charAt(i-1) == '2') {
                    dp[i + 1] += dp[i - 1];
                    dp[i + 1] %= 1000000;
                } else if (str.charAt(i-1) == '1') {
                    dp[i+1] += dp[i - 1];
                    dp[i + 1] %= 1000000;
                }
            }
        }

        System.out.println(dp[str.length()]);
    }
}

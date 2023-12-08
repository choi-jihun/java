import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N + 1];
        double[] dp = new double[N + 1];
        double max = 0;
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.printf("%.3f%n", max);
    }
}

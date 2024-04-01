import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] dpRemoved = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        dpRemoved[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            dpRemoved[i] = Math.max(Math.max(dpRemoved[i - 1] + arr[i], dp[i - 1]), arr[i]);
            max = Math.max(max, Math.max(dp[i], dpRemoved[i]));
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}

import java.io.*;
import java.util.*;

public class baekjoon_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] vipSeats = new int[M];
        for (int i = 0; i < M; i++) {
            vipSeats[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (N >= 2) dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int lastSeat = 0;
        int result = 1;
        for (int i = 0; i < M; i++) {
            int vip = vipSeats[i];
            int segmentLength = vip - lastSeat - 1;
            result *= dp[segmentLength];
            lastSeat = vip;
        }

        int segmentLength = N - lastSeat;
        result *= dp[segmentLength];

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

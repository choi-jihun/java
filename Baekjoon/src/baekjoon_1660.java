import java.io.*;
import java.util.*;

public class baekjoon_1660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        int i = 1;
        while (true) {
            int temp = i * (i + 1) * (i + 2) / 6;
            if (temp > N)
                break;
            list.add(temp);
            i++;
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int t : list) {
            for (int j = t; j <= N; j++) {
                if (dp[j - t] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - t] + 1);
                }
            }
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

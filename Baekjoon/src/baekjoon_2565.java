import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] line = new int[501];
        Arrays.fill(line, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[a] = b;
        }

        int[] dp = new int[N + 1];
        int cnt = 0;

        for (int i = 0; i < 501; i++) {
            if (line[i] == -1) {
                continue;
            }
            int idx = Arrays.binarySearch(dp, 0, cnt, line[i]);
            if (idx < 0)
                idx = -(idx + 1);
            dp[idx] = line[i];
            if (idx == cnt)
                cnt++;
        }

        bw.write(N - cnt + "\n");
        bw.flush();
    }
}

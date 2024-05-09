import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_17953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dp[i][0] = arr[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++)
                    if (j == k) {
                        dp[j][i] = Math.max(dp[j][i], dp[k][i - 1] + arr[j][i] / 2);
                    } else {
                        dp[j][i] = Math.max(dp[j][i], dp[k][i - 1] + arr[j][i]);
                    }
            }
        }

        int result = 0;
        for(int i = 0; i < M; i++) {
            result = Math.max(result, dp[i][N-1]);
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}

import java.io.*;
import java.util.StringTokenizer;

//실패
public class baekjoon_24426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == 1 && j == 1)
                    dp[i][j] = arr[i][j];
                else
                    dp[i][j] = arr[i][j] + Math.max(i > 1 ? dp[i - 1][j] : 0, j > 1 ? dp[i][j - 1] : 0);
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = x; i < N + 1; i++) {
            for (int j = y; j < N + 1; j++) {
                if (i == x && j == y)
                    continue;
                dp[i][j] = arr[i][j] + Math.max(i > x ? dp[i - 1][j] : 0, j > y ? dp[i][j - 1] : 0);
            }
        }

        int maxPathThroughY = dp[N][N];

        dp = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = (i == x && j == y) ? 0 : arr[i][j];
                dp[i][j] = arr[i][j] + Math.max(i > 1 ? dp[i - 1][j] : 0, j > 1 ? dp[i][j - 1] : 0);
            }
        }

        int maxPathWithoutY = dp[N][N];

        bw.write(maxPathThroughY + " " + maxPathWithoutY);
        bw.flush();
    }
}

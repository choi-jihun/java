import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = minDp[0][i] = arr[0][i];
        }

        for (int i = 1; i <N; i++) {
            maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + arr[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]) + arr[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + arr[i][2];

            minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + arr[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]) + arr[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + arr[i][2];
        }

        int maxScore = Math.max(Math.max(maxDp[N-1][0], maxDp[N-1][1]), maxDp[N-1][2]);
        int minScore = Math.min(Math.min(minDp[N-1][0], minDp[N-1][1]), minDp[N-1][2]);

        System.out.println(maxScore + " " + minScore);
    }
}

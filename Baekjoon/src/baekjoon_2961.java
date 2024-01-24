import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2961 {
    static int N;
    static int[][] arr;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 1, 0);
        System.out.println(minDiff);
    }

    static void DFS(int depth, int sour, int bitter) {
        if (depth == N) {
            if (sour != 1 || bitter != 0) {
                int diff = Math.abs(sour - bitter);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
            return;
        }
        DFS(depth + 1, sour * arr[depth][0], bitter + arr[depth][1]);
        DFS(depth + 1, sour, bitter);
    }
}

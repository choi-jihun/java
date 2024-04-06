import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_10971 {

    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;dfs(0, 0, 0);

        bw.write(minCost + "\n");
        bw.flush();
    }

    static void dfs(int current, int depth, int curCost) {
        if (depth == N - 1) {
            if (arr[current][0] > 0) {
                minCost = Math.min(minCost, curCost + arr[current][0]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[current][i] > 0) {
                visited[i] = true;
                dfs(i, depth + 1, curCost + arr[current][i]);
                visited[i] = false;
            }
        }
    }
}

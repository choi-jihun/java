import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_17070 {
    static int N;
    static int[][] house;
    static int count = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        house = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 1, 0);
        System.out.println(dp[N - 1][N - 1]);
    }

    static void DFS(int x, int y, int dia) {
        if (x >= N || y >= N || house[x][y] == 1)
            return;
        if (dia == 0) {
            DFS(x, y + 1, 0);
            DFS(x + 1, y + 1, 1);
        } else if (dia == 1) {
            if (house[x - 1][y] == 1 || house[x][y - 1] == 1)
                return;
            DFS(x, y + 1, 0);
            DFS(x + 1, y + 1, 1);
            DFS(x + 1, y, 2);
        } else {
            DFS(x + 1, y + 1, 1);
            DFS(x + 1, y, 2);
        }
        dp[x][y]++;
    }
}
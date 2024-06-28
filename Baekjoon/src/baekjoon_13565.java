import java.io.*;

public class baekjoon_13565 {

    static int M, N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dimensions = br.readLine().split(" ");
        M = Integer.parseInt(dimensions[0]);
        N = Integer.parseInt(dimensions[1]);

        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        boolean isin = false;
        for (int j = 0; j < N; j++) {
            if (arr[0][j] == 0 && !visited[0][j]) {
                if (dfs(0, j)) {
                    isin = true;
                    break;
                }
            }
        }

        if (isin) {
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean dfs(int x, int y) {
        if (x == M - 1) {
            return true;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] == 0) {
                if (dfs(nx, ny)) {
                    return true;
                }
            }
        }

        return false;
    }
}

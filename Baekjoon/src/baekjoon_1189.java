import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1189 {

    static int R, C, K;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visited[R - 1][0] = true;
        bw.write(String.valueOf(dfs(R - 1, 0, 1)));
        bw.flush();
    }

    static int dfs(int x, int y, int cnt) {
        if (x == 0 && y == C - 1) {
            if (cnt == K) {
                return 1;
            }
            return 0;
        }

        count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                count += dfs(nx, ny, cnt + 1);
                visited[nx][ny] = false;
            }
        }

        return count;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C && arr[x][y] != 'T';
    }
}

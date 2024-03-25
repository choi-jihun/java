import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1987 {

    static int R, C;
    static int max = 0;
    static char[][] arr;
    static boolean[] visited = new boolean[26];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        bw.write(String.valueOf(max));
        bw.flush();
    }

    static void dfs(int x, int y, int cnt) {
        if (cnt > max) {
            max = cnt;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[arr[nx][ny] - 'A']) {
                visited[arr[nx][ny] - 'A'] = true;
                dfs(nx, ny, cnt + 1);
                visited[arr[nx][ny] - 'A'] = false;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_14503 {

    static int N, M;
    static int[][] arr;
    static int r, c;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        count = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        dfs(r, c, dir);
        bw.write(String.valueOf(count));
        bw.flush();
    }

    static void dfs(int x, int y, int d) {

        arr[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if (isValid(nextX, nextY) && arr[nextX][nextY] == 0) {
                count++;
                dfs(nextX, nextY, d);
                return;
            }
        }

        int backDir = (d + 2) % 4;
        int backX = x + dx[backDir];
        int backY = y + dy[backDir];

        if (isValid(backX, backY) && arr[backX][backY] != 1) {
            dfs(backX, backY, d);
        }

    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}

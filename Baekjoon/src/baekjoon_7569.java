import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_7569 {
    static int M, N, H;
    static int[][][] arr;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int day = 0;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        boolean isUnRipe = false;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if (arr[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                    }
                    if (arr[h][n][m] == 0) {
                        isUnRipe = true;
                    }
                }
            }
        }

        if (isUnRipe) {
            System.out.println(bfs());
        } else {
            System.out.println(0);
        }

    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            int z = tomato[0];
            int x = tomato[1];
            int y = tomato[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nz >= 0 && nz < H && nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nz][nx][ny] == 0) {
                    arr[nz][nx][ny] = arr[z][x][y] + 1;
                    queue.offer(new int[]{nz, nx, ny});
                }
            }
        }

        int day = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) {
                        return -1;
                    }
                    day = Math.max(day, arr[h][n][m]);
                }
            }
        }

        return day - 1;
    }
}

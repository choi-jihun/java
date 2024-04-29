import java.io.*;
import java.util.*;

public class baekjoon_1245 {

    static int N, M;
    static int peakCount = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!visited[x][y]) {
                    if (bfs(x, y)) {
                        peakCount++;
                    }
                }
            }
        }

        bw.write(String.valueOf(peakCount));
        bw.flush();
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        boolean isPeak = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int dir = 0; dir < 8; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (isValid(nx, ny)) {
                    if (arr[nx][ny] == arr[curX][curY] && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                    if (arr[nx][ny] > arr[curX][curY]) {
                        isPeak = false;
                    }
                }
            }
        }

        return isPeak;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

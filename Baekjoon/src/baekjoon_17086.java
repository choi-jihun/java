import java.io.*;
import java.util.*;

public class baekjoon_17086 {
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        bfs(queue);

        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDistance = Math.max(maxDistance, distance[i][j]);
            }
        }

        bw.write(String.valueOf(maxDistance));
        bw.flush();
        bw.close();
    }

    public static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && distance[nx][ny] == -1) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

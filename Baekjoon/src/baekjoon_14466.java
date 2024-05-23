import java.io.*;
import java.util.*;

public class baekjoon_14466 {
    static int N, K, R;
    static boolean[][][] visited;
    static int[][] arr;
    static List<List<Integer>> cows;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][N + 1][4];
        arr = new int[N + 1][N + 1];
        cows = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            if (r1 == r2) {
                if (c1 < c2) {
                    visited[r1][c1][3] = true;
                    visited[r2][c2][2] = true;
                } else {
                    visited[r1][c1][2] = true;
                    visited[r2][c2][3] = true;
                }
            } else {
                if (r1 < r2) {
                    visited[r1][c1][1] = true;
                    visited[r2][c2][0] = true;
                } else {
                    visited[r1][c1][0] = true;
                    visited[r2][c2][1] = true;
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Integer> cowPosition = new ArrayList<>();
            cowPosition.add(r);
            cowPosition.add(c);
            cows.add(cowPosition);
        }

        int region = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 0) {
                    region++;
                    bfs(i, j, region);
                }
            }
        }

        int[] cowRegion = new int[K];
        for (int i = 0; i < K; i++) {
            List<Integer> cow = cows.get(i);
            cowRegion[i] = arr[cow.get(0)][cow.get(1)];
        }

        int count = 0;
        for (int i = 0; i < K; i++) {
            for (int j = i + 1; j < K; j++) {
                if (cowRegion[i] != cowRegion[j]) {
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y, int region) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = region;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0];
            int cy = pos[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx > 0 && nx <= N && ny > 0 && ny <= N && arr[nx][ny] == 0 && !visited[cx][cy][d]) {
                    arr[nx][ny] = region;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}

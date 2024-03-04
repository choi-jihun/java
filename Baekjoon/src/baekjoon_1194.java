import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1194 {

    static class Point {
        int x, y, key, dist;

        Point(int x, int y, int key, int dist) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.dist = dist;
        }
    }

    static int N, M;
    static char[][] arr;
    static boolean[][][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    static Point start = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][64];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == '0') {
                    start = new Point(i, j, 0, 0);
                }
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y][start.key] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (arr[point.x][point.y] == '1') {
                return point.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                int nKey = point.key;
                if (isValid(nx, ny) && !visited[nx][ny][nKey]) {
                    char c = arr[nx][ny];
                    if (c == '#')
                        continue;

                    if (c >= 'a' && c <= 'f') {
                        nKey |= (1 << (c - 'a'));
                    }

                    if (c >= 'A' && c <= 'F' && (nKey & (1 << (c - 'A'))) == 0) {
                        continue;
                    }

                    visited[nx][ny][nKey] = true;
                    queue.offer(new Point(nx, ny, nKey, point.dist + 1));
                }
            }
        }
        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

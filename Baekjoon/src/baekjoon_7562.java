import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_7562 {

    static class Point {
        int x;
        int y;
        int cnt;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            int[][] chess = new int[I][I];

            Point[] p = new Point[2];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                p[j] = new Point(x, y);
            }
            sb.append(BFS(chess, p, I)).append("\n");
        }
        System.out.println(sb);
    }

    public static int BFS(int[][] arr, Point[] points, int N) {
        Queue<Point> q = new LinkedList<>();
        q.offer(points[0]);

        boolean[][] visited = new boolean[N][N];
        visited[points[0].x][points[0].y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == points[1].x && p.y == points[1].y) {
                return p.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int curX = p.x + dx[i];
                int curY = p.y + dy[i];
                if (curX < 0 || curY < 0 || curX >= N || curY >= N) {
                    continue;
                }
                if (!visited[curX][curY]) {
                    visited[curX][curY] = true;
                    q.offer(new Point(curX, curY, p.cnt + 1));
                }
            }
        }

        return -1;
    }
}

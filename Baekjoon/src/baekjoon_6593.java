import java.io.*;
import java.util.*;

public class baekjoon_6593 {
    static class Point {
        int x, y, z, time;

        public Point(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] arr = new char[L][R][C];
            Point start = null, end = null;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = str.charAt(k);
                        if (str.charAt(k) == 'S') {
                            start = new Point(i, j, k, 0);
                        } else if (str.charAt(k) == 'E') {
                            end = new Point(i, j, k, 0);
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(arr, start, end, L, R, C);
            if (result == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + result + " minute(s).\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(char[][][] building, Point start, Point end, int L, int R, int C) {
        boolean[][][] visited = new boolean[L][R][C];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][start.z] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == end.x && current.y == end.y && current.z == end.z) {
                return current.time;
            }

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];

                if (nx >= 0 && nx < L && ny >= 0 && ny < R && nz >= 0 && nz < C
                        && !visited[nx][ny][nz] && building[nx][ny][nz] != '#') {
                    queue.add(new Point(nx, ny, nz, current.time + 1));
                    visited[nx][ny][nz] = true;
                }
            }
        }

        return -1;
    }
}

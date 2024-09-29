import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1491 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int N, M;
    static int endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        spiralTraversal();
        bw.write(endX + " " + endY);
        bw.flush();
        br.close();
        bw.close();
    }

    static void spiralTraversal() {
        int x = 0;
        int y = 0;
        int direction = 0;

        while (true) {
            visited[x][y] = true;
            endX = x;
            endY = y;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (isValid(nx, ny)) {
                x = nx;
                y = ny;
            } else {
                direction = (direction + 1) % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];

                if (isValid(nx, ny)) {
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && !visited[x][y];
    }
}
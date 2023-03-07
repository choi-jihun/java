import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_7576 {

    static class tomato {
        int x;
        int y;

        tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        BFS();
    }

    static void BFS() {
        Queue<tomato> q = new LinkedList<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 1)
                    q.add(new tomato(i, j));

        while (!q.isEmpty()) {
            tomato t = q.poll();
            for (int i = 0; i < 4; i++) {
                int curX = t.x + dx[i];
                int curY = t.y + dy[i];
                if (curX >= 0 && curY >= 0 && curX < N && curY < M) {
                    if (map[curX][curY] == 0) {
                        map[curX][curY] = map[t.x][t.y] + 1;
                        q.add(new tomato(curX, curY));
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max - 1);
    }
}

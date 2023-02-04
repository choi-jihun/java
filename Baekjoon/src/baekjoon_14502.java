import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_14502 {

    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = Integer.MIN_VALUE;

    static class virus {
        int x, y;

        virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(result);
    }

    public static void DFS(int depth) {
        if (depth == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void BFS() {
        int[][] cp_map = new int[N][M];
        Queue<virus> q = new LinkedList<>();

        for (int i = 0; i < N; i++)
            cp_map[i] = map[i].clone();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (cp_map[i][j] == 2)
                    q.add(new virus(i, j));
        }

        while (!q.isEmpty()) {
            virus vi = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = vi.x + dx[i];
                int ny = vi.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(cp_map[nx][ny] == 0){
                        cp_map[nx][ny] = 2;
                        q.add(new virus(nx, ny));
                    }
                }
            }
        }
        safe(cp_map);
    }

    static void safe(int[][] cp_map) {
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (cp_map[i][j] == 0)
                    count++;
        result = Math.max(count, result);
    }
}

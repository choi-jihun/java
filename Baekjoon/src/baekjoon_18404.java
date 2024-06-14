import java.io.*;
import java.util.*;

public class baekjoon_18404 {
    private static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;

        int[][] arr = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
            arr[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[][] distances = bfs(N, startX, startY);

        for (int i = 0; i < M; i++) {
            int targetX = arr[i][0];
            int targetY = arr[i][1];
            bw.write(distances[targetX][targetY] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[][] bfs(int N, int startX, int startY) {
        int[][] arr = new int[N][N];
        for (int[] row : arr) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        arr[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int currentDist = arr[x][y];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == -1) {
                    arr[nx][ny] = currentDist + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        return arr;
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_4485 {
    static int[][] arr;
    static int[][] cost;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int idx = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            arr = new int[N][N];
            cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0);
            bw.write("Problem " + idx + ": " + cost[N - 1][N - 1] + "\n");
            bw.flush();
            idx++;
        }
    }

    static void bfs(int x, int y) {
        cost[0][0] = arr[0][0];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { x, y });

        while (!que.isEmpty()) {
            int[] edge = que.poll();
            x = edge[0];
            y = edge[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (isValid(newX, newY)) {
                    if (arr[newX][newY] + cost[x][y] < cost[newX][newY]) {
                        cost[newX][newY] = arr[newX][newY] + cost[x][y];
                        que.offer(new int[] { newX, newY });
                    }
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}

import java.io.*;
import java.util.*;

public class baekjoon_2636 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] arr;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int cheese = 0;
        while (true) {
            int cheeseCnt = bfs();
            if (cheeseCnt == 0) {
                break;
            }
            cheese = cheeseCnt;
            time++;
        }
        bw.write(String.format("%d\n%d", time, cheese));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (isValid(nx, ny) && !visited[nx][ny]) {
                    if (arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        visited[nx][ny] = true;
                        cnt++;
                    } else {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return cnt;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

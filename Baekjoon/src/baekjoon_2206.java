import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2206 {

    static class Node {
        int x;
        int y;
        int dist;
        int breakWall;

        public Node(int x, int y, int dist, int breakWall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.breakWall = breakWall;
        }
    }

    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isValid(nx, ny)) {
                    if (arr[nx][ny] == 0 && !visited[nx][ny][current.breakWall]) {
                        visited[nx][ny][current.breakWall] = true;
                        queue.offer(new Node(nx, ny, current.dist + 1, current.breakWall));
                    } else if (arr[nx][ny] == 1 && current.breakWall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Node(nx, ny, current.dist + 1, 1));
                    }
                }
            }
        }

        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

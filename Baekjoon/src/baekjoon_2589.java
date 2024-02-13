import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2589 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] ch;
    static int[][] dis;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int N, M;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new char[N][M];
        dis = new int[N][M];
        for (int i = 0; i < N; i++) {
            ch[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ch[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ch[i][j] == 'L') {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    static int  bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        dis[x][y] = 0;
        int maxDistance = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int curX = node.x + dx[i];
                int curY = node.y + dy[i];
                if (isValid(curX, curY) && ch[curX][curY] == 'L' && !visited[curX][curY]) {
                    q.offer(new Node(curX, curY));
                    visited[curX][curY] = true;
                    dis[curX][curY] = dis[node.x][node.y] + 1;
                    maxDistance = Math.max(maxDistance, dis[curX][curY]);
                }
            }
        }
        return maxDistance;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

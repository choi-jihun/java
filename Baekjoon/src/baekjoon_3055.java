import java.io.*;
import java.util.*;

public class baekjoon_3055 {

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int R, C;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> waters = new LinkedList<>();
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '*') {
                    waters.add(new Node(i, j, 0));
                }
                if (arr[i][j] == 'S') {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int result = bfs();
        if (result > 0) {
            bw.write(String.valueOf(result));
        } else {
            bw.write("KAKTUS");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs() {
        while (!queue.isEmpty() || !waters.isEmpty()) {
            int watersSize = waters.size();
            for (int i = 0; i < watersSize; i++) {
                Node water = waters.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = water.x + dx[j];
                    int ny = water.y + dy[j];
                    if (isValid(nx, ny) && arr[nx][ny] == '.') {
                        arr[nx][ny] = '*';
                        waters.offer(new Node(nx, ny, water.time + 1));
                    }
                }
            }

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node current = queue.poll();
                if (arr[current.x][current.y] == 'D') {
                    return current.time;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];
                    if (isValid(nx, ny) && (arr[nx][ny] == '.' || arr[nx][ny] == 'D') && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, current.time + 1));
                    }
                }
            }
        }
        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C && arr[x][y] != 'X';
    }
}

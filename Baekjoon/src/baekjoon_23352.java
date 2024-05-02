import java.io.*;
import java.util.*;

public class baekjoon_23352 {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;
        int maxLength = 0;

        ArrayList<int[]> endpoints = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    int[][] distance = bfs(i, j);
                    for (int a = 0; a < N; a++) {
                        for (int b = 0; b < M; b++) {
                            if (distance[a][b] > maxLength) {
                                maxLength = distance[a][b];
                                endpoints.clear();
                                endpoints.add(new int[]{i, j, a, b});
                            } else if (distance[a][b] == maxLength) {
                                endpoints.add(new int[]{i, j, a, b});
                            }
                        }
                    }
                }
            }
        }

        for (int[] end : endpoints) {
            int sum = map[end[0]][end[1]] + map[end[2]][end[3]];
            maxSum = Math.max(maxSum, sum);
        }

        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();
        br.close();
    }

    static int[][] bfs(int x, int y) {
        int[][] distances = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    distances[nx][ny] = distances[curX][curY] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return distances;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 0;
    }
}

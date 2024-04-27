import java.io.*;
import java.util.*;

public class baekjoon_21736 {
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        int startI = 0, startJ = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'I') {
                    startI = i;
                    startJ = j;
                }
            }
        }

        int peopleMet = bfs(startI, startJ);

        if (peopleMet > 0) {
            bw.write(String.valueOf(peopleMet));
        } else {
            bw.write("TT");
        }

        bw.flush();
    }

    public static int bfs(int startI, int startJ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startI, startJ});
        visited[startI][startJ] = true;

        int countPeople = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    if (arr[nx][ny] == 'P') {
                        countPeople++;
                    }
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return countPeople;
    }
}

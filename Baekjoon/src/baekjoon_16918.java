import java.io.*;
import java.util.*;

public class baekjoon_16918 {
    static int R, C, N;
    static char[][] grid;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        if (N == 1) {
            printGrid(grid);
            return;
        }

        if (N % 2 == 0) {
            char[][] fullGrid = new char[R][C];
            for (int i = 0; i < R; i++) {
                Arrays.fill(fullGrid[i], 'O');
            }
            printGrid(fullGrid);
            return;
        }

        char[][] firstState = simulate(grid);
        char[][] secondState = simulate(firstState);
        if ((N / 2) % 2 == 1) {
            printGrid(firstState);
        } else {
            printGrid(secondState);
        }
    }

    static void printGrid(char[][] grid) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(grid[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
    }

    static char[][] simulate(char[][] grid) {
        char[][] newGrid = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(newGrid[i], 'O');
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'O') {
                    newGrid[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            newGrid[nx][ny] = '.';
                        }
                    }
                }
            }
        }

        return newGrid;
    }

}

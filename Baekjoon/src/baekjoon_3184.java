import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3184 {
    static int R, C;
    static int lamp, wolves, cntLamp, cntWolves;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                cntWolves = 0;
                cntLamp = 0;
                if (map[i][j] == '#')
                    continue;
                if (!visited[i][j])
                    DFS(i, j);
                if (cntLamp > cntWolves)
                    lamp += cntLamp;
                else
                    wolves += cntWolves;
            }
        }
        System.out.println(lamp + " " + wolves);
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;
        if (map[x][y] == 'o')
            cntLamp++;
        if (map[x][y] == 'v')
            cntWolves++;
        for (int i = 0; i < 4; i++) {
            int current_X = x + dx[i];
            int current_Y = y + dy[i];
            if (current_Y >= 0 && current_X >= 0 && current_X < R && current_Y < C && !visited[current_X][current_Y]) {
                if (map[current_X][current_Y] != '#')
                    DFS(current_X, current_Y);
            }

        }
    }
}

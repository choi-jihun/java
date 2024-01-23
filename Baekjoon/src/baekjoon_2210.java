import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_2210 {
    static HashSet<String> set = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[][] map = new String[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(map, i, j, 0, new StringBuilder(map[i][j]));
            }
        }
        System.out.println(set.size());
    }

    static void DFS(String[][] map, int x, int y, int cnt, StringBuilder tmp) {
        if (cnt == 5) {
            set.add(tmp.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int currentX = x + dx[i];
            int currentY = y + dy[i];

            if (currentX >= 0 && currentX < map.length && currentY >= 0 && currentY < map.length) {
                DFS(map, currentX, currentY, cnt + 1, new StringBuilder(tmp + map[currentX][currentY]));
            }
        }
    }
}

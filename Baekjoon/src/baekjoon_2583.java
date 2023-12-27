import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_2583 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M, cnt;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int x = x1; x < x2; x++) {
                    arr[j][x] = 1;
                }
            }
        }

        ArrayList<Integer> areaCount = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    cnt = 0;
                    dfs(i, j);
                    areaCount.add(cnt);
                }
            }
        }

        Collections.sort(areaCount);

        sb.append(areaCount.size()).append("\n");
        for (int i : areaCount) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        arr[x][y] = 1;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (0 <= nx && nx < N && 0 <= ny && ny < M && arr[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }
}

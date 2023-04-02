import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1018 {
    static boolean[][] arr;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W')
                    arr[i][j] = true;
                else
                    arr[i][j] = false;
            }
        }
        for (int i = 0; i < N - 7; i++)
            for (int j = 0; j < M - 7; j++)
                find(i, j);

        System.out.println(min);
    }

    static void find(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int cnt = 0;

        boolean color = arr[x][y];
        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (arr[i][j] != color)
                    cnt++;

                color = !color;
            }
            color = !color;
        }
        cnt = Math.min(cnt, 64 - cnt);
        min = Math.min(cnt, min);
    }
}
